package com.example.databaseapplication.personalinfodb

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.databaseapplication.subscribeOnBackground


class PersonalRepository(application: Application) {
   var dao: PersonalInfoDao? =null
    var allInfo: LiveData<List<PersonalInfo>>
    val database=PersonalInfoDatabase.getInstance(application)


    init {
        dao=database.personalInfoDao()
        allInfo = dao!!.getAllInfo()
    }




    fun insert(model: PersonalInfo?) {
        subscribeOnBackground {
            dao!!.insert(model!!)
        }

    }
    fun delete(model: PersonalInfo?){
        subscribeOnBackground {
            dao!!.delete(model!!)
        }
    }
    fun update(model: PersonalInfo?){
        subscribeOnBackground {
            dao!!.update(model!!)
        }
    }



    fun getAll():LiveData<List<PersonalInfo>> {
        return allInfo

    }

}