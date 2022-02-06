package com.example.darshanpractical.models.api_implementors

import com.example.darshanpractical.models.api_repositories.TaskVMRepository
import com.example.darshanpractical.models.pojo.task_list_response.TaskListResponse

interface TaskVMImplementor : BaseImplementor {


        fun mesiterData(
            token: String,
            filter: String,
            responseFormat: String,
            callback: TaskVMRepository.ApiCallBack<TaskListResponse?>
        )
    }