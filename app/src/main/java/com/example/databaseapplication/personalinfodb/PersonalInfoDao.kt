package com.example.databaseapplication.personalinfodb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.databaseapplication.personalinfodb.PersonalInfo



@Dao
interface PersonalInfoDao {
    @Insert
    fun insert(personalInfo: PersonalInfo)
     @Update
     fun update(personalInfo: PersonalInfo)
     @Delete
     fun delete(personalInfo: PersonalInfo)

     @Query("select * from personal_info_table")
     fun getAllInfo():LiveData<List<PersonalInfo>>



          }
