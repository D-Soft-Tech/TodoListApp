package com.example.mvvmtodolistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mvvmtodolistapp.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [TaskDataClass::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun taskDao(): TaskDAO

    class Callback @Inject constructor(
        private val database: Provider<AppDataBase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.addTask(TaskDataClass(0, "Learn Flow", true, completed = false))
                dao.addTask(TaskDataClass(0, "Learn Datastore", true, completed = false))
                dao.addTask(TaskDataClass(0, "Learn Work manager", true, completed = false))
                dao.addTask(
                    TaskDataClass(
                        0,
                        "Learn how to use NetworkBoundResource class",
                        true,
                        completed = false
                    )
                )
            }
        }
    }

//    companion object {
//        @Volatile
//        private var DB_INSTANCE: AppDataBase? = null
//
//        fun getInstance(context: Context): AppDataBase {
//            val tempInstance = DB_INSTANCE
//
//            if (tempInstance != null) {
//                return tempInstance
//            }
//
//            synchronized(this) {
//                val newInstance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDataBase::class.java,
//                    "task_DB"
//                ).build()
//
//                DB_INSTANCE = newInstance
//                return newInstance
//            }
//        }
//    }
}
