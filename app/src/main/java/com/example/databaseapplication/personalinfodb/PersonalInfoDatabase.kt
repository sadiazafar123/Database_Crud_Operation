package com.example.databaseapplication.personalinfodb

import android.content.Context
import android.os.AsyncTask
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.databaseapplication.subscribeOnBackground


@Database(entities = [PersonalInfo::class], version = 1)

abstract class PersonalInfoDatabase: RoomDatabase() {
    abstract fun personalInfoDao(): PersonalInfoDao
    companion object{
        private var instance: PersonalInfoDatabase?=null
        @Synchronized
        fun getInstance(context:Context): PersonalInfoDatabase {
            if (instance ==null)
                instance = Room.databaseBuilder(context.applicationContext, PersonalInfoDatabase::class.java,
                    "personal_info_database").fallbackToDestructiveMigration().addCallback(
                    roomCallback
                ).build()
            return instance!!


        }
        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                //populateDatabase(instance!!)
                 //PopulateDbAsyncTask(instance!!).execute();
                populateDatabase(instance!!)
            }
        }
        private fun populateDatabase(db:PersonalInfoDatabase){
            val noteDao=db.personalInfoDao()
          /*  subscribeOnBackground {
                noteDao.insert(PersonalInfo("sadia",40,"msc","teaching"))
                noteDao.insert(PersonalInfo("sana",30,"ics","teaching"))
                noteDao.insert(PersonalInfo("asia",20,"b.com","banking"))

            }*/

        }
      /*  private fun populateDatabase(db: PersonalInfoDatabase) {
            val noteDao = db.personalInfoDao()


        }*/

        // we are creating an async task class to perform task in background.

      /*  private class PopulateDbAsyncTask(instance: PersonalInfoDatabase) : AsyncTask<Void?, Void?, Void?>() {
            init {
                val dao: PersonalInfoDao = instance.personalInfoDao()
            }

            override fun doInBackground(vararg params: Void?): Void? {
                return null
            }
        }*/




    }

    }








