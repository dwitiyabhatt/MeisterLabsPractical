package com.example.darshanpractical.models.api_repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.darshanpractical.models.api_implementors.TaskVMImplementor
import com.example.darshanpractical.models.networking.ApiClient
import com.example.darshanpractical.models.pojo.task_list_response.TaskListResponse
import com.example.darshanpractical.models.pojo.task_list_response.TasksItem
import com.example.darshanpractical.models.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskVMRepository : TaskVMImplementor {

    private var taskListApicall: Call<TaskListResponse?>? = null

    interface ApiCallBack<T> {
        fun onSuccess(responseData: TaskListResponse?)
        fun onError(message: String?)
    }

    override fun mesiterData(
        token: String,
        filter: String,
        responseFormat: String,
        callback: ApiCallBack<TaskListResponse?>
    ) {
        taskListApicall = ApiClient.build()?.doSearch(token, filter, responseFormat)

        taskListApicall?.enqueue(object : Callback<TaskListResponse?>{

            override fun onFailure(call: Call<TaskListResponse?>, t: Throwable?) {
                Log.d("meister_log", "Error "+t?.message)
                callback.onError(t?.message)

            }

            override fun onResponse(
                call: Call<TaskListResponse?>,
                response: Response<TaskListResponse?>
            ) {
                if(response.code() == 400){
                    Log.d("meister_log", "Catched")
                }

                Log.d("meister_log", "Repository code "+response.code())
                if(response.isSuccessful){
                    callback.onSuccess(response.body())
                    Log.d("meister_log", "success2 "+response.message())
                }else{
                    try {
                        assert(response.errorBody() != null)
                        val jObjError =
                            JSONObject(response.errorBody()!!.string())
                        callback.onError( jObjError.getString("message"))
                        Log.d("meister_log","Error "+jObjError.getString("message"))
                    } catch (ignored: Exception) {
                        Log.d("meister_log","API Failed here "+ignored.toString())
                    }

                    Log.d("meister_log", "Err2 "+response.message())
                }
            }
        })
    }

    companion object {

        var appDatabase: AppDatabase? = null
        var taskTableModel: LiveData<List<TasksItem>>? = null

        fun initializeDB(context: Context): AppDatabase {
            return AppDatabase.getDataseClient(context)
        }

        fun insertData(context: Context, taskList: List<TasksItem>) {
            Log.d("db_log", "1")
            appDatabase = initializeDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("db_log", "2")
                appDatabase!!.TaskDao().insertAll(taskList)
            }

        }



        fun getLiveData(context: Context, username: String) : LiveData<List<TasksItem>>? {
            Log.d("local_search","2")
            appDatabase = initializeDB(context)

            taskTableModel = appDatabase!!.TaskDao().findTaskByName(username)

            //taskTableModel = appDatabase!!.TaskDao().getAllTasks

            Log.d("local_search","3")
            return taskTableModel
        }
    }


    override fun cancel() {
        taskListApicall?.cancel()
    }

}