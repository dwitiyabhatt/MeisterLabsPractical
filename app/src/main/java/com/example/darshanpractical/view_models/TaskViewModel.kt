package com.oncobuddy.app.view_models

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.darshanpractical.MeisterApp
import com.example.darshanpractical.models.api_implementors.TaskVMImplementor
import com.example.darshanpractical.models.api_repositories.TaskVMRepository
import com.example.darshanpractical.models.pojo.task_list_response.TaskListResponse
import com.example.darshanpractical.models.pojo.task_list_response.TasksItem
import retrofit2.Response

class TaskViewModel(private val taskVMImplementor: TaskVMImplementor) : ViewModel() {


    private val _liveTaskListResponse = MutableLiveData<TaskListResponse>()
    val taskListResonseData: LiveData<TaskListResponse> = _liveTaskListResponse

    var liveDataLogin: LiveData<List<TasksItem>>? = null

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<String>()
    val onMessageError: LiveData<String> = _onMessageError



    fun insertData(context: Context, list: List<TasksItem>) {
        Log.d("db_log","0")
        TaskVMRepository.insertData(context, list)
    }



    fun getListFromDB(query: String) : LiveData<List<TasksItem>>? {
        Log.d("local_search","0")
        liveDataLogin = TaskVMRepository.getLiveData(MeisterApp.activityFromApp,query)
        Log.d("local_search","1")
        return liveDataLogin
    }

    /*fun getLoginDetails(context: Context, username: String) : LiveData<TasksItem>? {
        TaskVMRepository.insertData()
        return liveDataLogin
    }*/


    fun retiveMeisterData(token : String, filter: String, response_format: String) {
        Log.d("meister_log", "came here")
        _isViewLoading.postValue(true)
        taskVMImplementor.mesiterData(
            token,filter,response_format,
            object : TaskVMRepository.ApiCallBack<TaskListResponse?> {

                override fun onError(message: String?) {
                    Log.d("meister_log", "failue " + message)
                    Log.d("meister_log", "is_loading is 2")
                    _isViewLoading.postValue(false)
                    _onMessageError.postValue(message)
                }

                override fun onSuccess(responseData:TaskListResponse?) {
                    Log.d("meister_log", "Success")
                    Log.d("meister_log", "is_loading is 1")
                    _isViewLoading.postValue(false)
                    _liveTaskListResponse.postValue(responseData)
                    responseData?.results?.tasks?.let { insertData(MeisterApp.activityFromApp, it) }
                }

            })
    }




}