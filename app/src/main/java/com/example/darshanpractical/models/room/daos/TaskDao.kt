package com.example.darshanpractical.models.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.darshanpractical.models.pojo.task_list_response.TasksItem


@Dao
interface TaskDao {

    @get:Query("SELECT * FROM TasksItem")
    val getAllTasks: LiveData<List<TasksItem>>


    @Query("SELECT * FROM TasksItem WHERE name LIKE '%' || :query || '%'")
    fun findTaskByName(query: String): LiveData<List<TasksItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tasks: List<TasksItem>)

}