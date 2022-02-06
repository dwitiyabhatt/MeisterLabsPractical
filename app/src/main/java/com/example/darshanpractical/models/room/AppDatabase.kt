package com.example.darshanpractical.models.room

import android.content.Context
import androidx.room.*
import com.example.darshanpractical.models.pojo.task_list_response.TasksItem
import com.example.darshanpractical.models.room.daos.TaskDao

@Database(entities = arrayOf(TasksItem::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun TaskDao() : TaskDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDataseClient(context: Context) : AppDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "DARSHAN_APP_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}