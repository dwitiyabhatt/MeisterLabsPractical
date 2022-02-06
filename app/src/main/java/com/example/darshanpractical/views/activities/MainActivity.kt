package com.example.darshanpractical.views.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.darshanpractical.MeisterApp
import com.example.darshanpractical.R
import com.example.darshanpractical.databinding.ActivityMainBinding
import com.example.darshanpractical.injectors.TaskListInjection
import com.example.darshanpractical.models.pojo.Filter
import com.example.darshanpractical.models.pojo.Status
import com.example.darshanpractical.models.pojo.task_list_response.TaskListResponse
import com.example.darshanpractical.models.pojo.task_list_response.TasksItem
import com.example.darshanpractical.utils.Constants
import com.example.darshanpractical.views.adapters.StatusFilterAdapter
import com.example.darshanpractical.views.adapters.TaskAdapter
import com.google.gson.Gson
import com.oncobuddy.app.view_models.TaskViewModel

class MainActivity : BaseActivity(), StatusFilterAdapter.Interaction, TaskAdapter.Interaction {

    private lateinit var binding : ActivityMainBinding

    private lateinit var taskViewModel: TaskViewModel

    private lateinit var statusFilterAdapter: StatusFilterAdapter
    private lateinit var statusArrayList: ArrayList<Status>

    private lateinit var taskList: ArrayList<TasksItem>
    private lateinit var taskAdapter: TaskAdapter

    private lateinit var taskDetailsDialogue: Dialog


    private var query = "a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MeisterApp.activityFromApp = this@MainActivity
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        init()
        MeisterApp.savePreferenceDataString(Constants.PREF_AUTH_TOKEN,"Bearer 2N6edq_uS3ACq89RhzN2yQtdT5aEhbKgaE5-P9BD3hc")
        setStatusesRecyclerView()
        setupSearchListeners()
    }

    private fun setupSearchListeners() {
        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
                if (!isIntervalSearch()) {
                    if(checkInterNetConnection()){
                        fetchDataFromServer(query)
                    }else{
                        showToast("Internet not available! Getting data locally!")
                        getDataFromLocalDB()
                    }
                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })
    }

    private fun getDataFromLocalDB() {
        taskViewModel.getListFromDB(query)!!.observe(this@MainActivity, Observer { liveTaskList ->
            Log.d("local_search", "4 size " + liveTaskList.size)
            taskList = ArrayList()
            taskList.addAll(liveTaskList)
            setRecyclerView(taskList)

        })
    }

    override fun init() {
        setupVM()
        setupObservers()
        setupClickListeners()
    }

    override fun setupVM() {
        taskViewModel = ViewModelProvider(
            this,
            TaskListInjection.provideViewModelFactory()
        ).get(TaskViewModel::class.java)
    }

    override fun setupObservers() {
        taskViewModel.taskListResonseData.observe(this, taskListResponseObserver)
        taskViewModel.isViewLoading.observe(this, isViewLoadingObserver)
        taskViewModel.onMessageError.observe(this, errorMessageObserver)
    }

    override fun setupClickListeners() {
        binding.ivSearch.setOnClickListener(View.OnClickListener {
            if(!isDoubleClick()){
                showHideSearchBar(true)
                Log.d("db_log ", "0.0")
                //taskViewModel.get()
            }
        })

        binding.ivClose.setOnClickListener(View.OnClickListener {
            binding.edSearch.setText("")
        })

        binding.ivBackResults.setOnClickListener(View.OnClickListener {
            if(!isDoubleClick()){
                showHideSearchBar(false)
            }
        })
    }

    private fun fetchDataFromServer(query: String) {
        var filter = Filter()
        filter.text = query
        //filter.statues = intArrayOf(1,18)
        var gson = Gson()
        var jsonString = gson.toJson(filter)
        Log.d("meister_log", "jsonString " + jsonString)

        if(checkInterNetConnection()){
            MeisterApp.sharedPreferences.getString(Constants.PREF_AUTH_TOKEN, "")?.let {token ->
                taskViewModel.retiveMeisterData(
                    token, jsonString,
                    Constants.RESPONSE_FORMAT_TYPE)
            }
        }else{
            showToast("No internet! Fetching results from the database")

        }

    }


    private fun setStatusesRecyclerView() {
        statusArrayList = ArrayList()
        statusArrayList.add(Status(0,"All",0,true))
        statusArrayList.add(Status(1,"Active",1,false))
        statusArrayList.add(Status(2,"Archived",18,false))

        binding.rvStatusFilters.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            statusFilterAdapter = StatusFilterAdapter(this@MainActivity)
            adapter = statusFilterAdapter
            statusFilterAdapter.submitList(statusArrayList)
        }
    }

    private fun setRecyclerView(list: List<TasksItem>?) {

        val arrayList = list?.let { ArrayList<TasksItem>(it) }

        if(arrayList != null && arrayList.size > 0){
            showHideNoData(false)
            binding.rvTasks.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                taskAdapter = TaskAdapter(this@MainActivity)
                adapter = taskAdapter
                taskAdapter.submitList(arrayList)
            }
        }else{
            showHideNoData(true)
        }
    }

    private fun showHideNoData(shouldSHow: Boolean){
        if(shouldSHow){
            binding.rvTasks.visibility = View.GONE
            binding.tvNoData.visibility = View.VISIBLE
        }else{
            binding.rvTasks.visibility = View.VISIBLE
            binding.tvNoData.visibility = View.GONE

        }

    }

    override fun onFilterTagSelected(position: Int, item: Status, view: View) {
        for(statusObj in statusArrayList){
            statusObj.isSelected = statusObj.statusId == item.statusId
        }
        statusFilterAdapter.notifyDataSetChanged()
    }

    override fun onTaskSelected(position: Int, item: TasksItem, view: View) {
        Toast.makeText(applicationContext, "Item "+position,Toast.LENGTH_SHORT)
        if(view.id == R.id.cardRoot){
            showTaskDetailsDialogue(item)
        }
    }

    /**
     * shows simple dialogue with getting taskitem as a list
     */
    private fun showTaskDetailsDialogue(tasksItem: TasksItem) {

        taskDetailsDialogue = Dialog(this@MainActivity)
        taskDetailsDialogue.setContentView(R.layout.dialogue_task_view)

        val lp: WindowManager.LayoutParams = WindowManager.LayoutParams()
        lp.copyFrom(taskDetailsDialogue.window?.getAttributes())
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        lp.windowAnimations = R.style.DialogAnimation

        val window: Window? = taskDetailsDialogue?.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        window?.setBackgroundDrawableResource(android.R.color.transparent)

        taskDetailsDialogue.window?.setAttributes(lp)
        taskDetailsDialogue.window?.setBackgroundDrawableResource(android.R.color.transparent);

        val btnDOne: TextView = taskDetailsDialogue.findViewById(R.id.btnAppointments)
        val tvTaskTitle: TextView = taskDetailsDialogue.findViewById(R.id.tvTaskTitle)

        tvTaskTitle.setText(tasksItem.name)

        btnDOne.setOnClickListener(View.OnClickListener {
            taskDetailsDialogue.dismiss()
        })

        taskDetailsDialogue.show()
        //showToast("SHpwing dialogue")
    }

    // SetupObservers
    private val taskListResponseObserver = androidx.lifecycle.Observer<TaskListResponse> { responseObserver ->
        taskList = ArrayList()
        taskList.addAll(responseObserver.results.tasks)
        setRecyclerView(taskList)
        binding.executePendingBindings()
        binding.invalidateAll()
    }

    private val isViewLoadingObserver = Observer<Boolean> { isLoading ->
        showHideProgress(isLoading, binding.layoutProgress.frProgress)
    }

    private val errorMessageObserver = Observer<String> { message ->
        showToast(message)
    }

    private fun showHideSearchBar(shouldSHowSearch: Boolean) {
        if(shouldSHowSearch){
            binding.relTitleCOntainer.visibility = View.GONE
            binding.linSearchConteiner.visibility = View.VISIBLE
        }else{
            if(!binding.edSearch.text.isNullOrEmpty())binding.edSearch.setText("")
            binding.relTitleCOntainer.visibility = View.VISIBLE
            binding.linSearchConteiner.visibility = View.GONE
        }
    }


}