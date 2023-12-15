package com.example.databaseapplication.personalinfodb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData




class PersonalInfoViewModel( application: Application) : AndroidViewModel(application) {
       private var repository =  PersonalRepository(application)
       val allUserInfo=repository.getAll()




    // below line is to create a variable for live
    // data where all the courses are present.
    private val allCourses: LiveData<List<PersonalInfo>>? = null

    // below method is use to insert the data to our repository.
    fun insert(model: PersonalInfo?) {
       /* repository =  PersonalRepository()*/
        repository!!.insert(model)
    }
    fun delete(model: PersonalInfo?){
        repository!!.delete(model)
    }
    fun update(model: PersonalInfo?){
        repository!!.update(model)

    }

    fun getAllInfo():LiveData<List<PersonalInfo>> {

       return allUserInfo
    }


}