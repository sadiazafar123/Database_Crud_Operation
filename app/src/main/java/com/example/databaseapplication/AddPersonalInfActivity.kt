package com.example.databaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.example.databaseapplication.personalinfodb.PersonalInfo
import com.example.databaseapplication.personalinfodb.PersonalInfoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddPersonalInfActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var age:EditText
    lateinit var qualification:EditText
    lateinit var profession:EditText
    lateinit var viewModel: PersonalInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_personal_inf)
         name=findViewById<EditText>(R.id.et_name)
         age=findViewById<EditText>(R.id.et_age)
         qualification=findViewById<EditText>(R.id.et_qualification)
         profession=findViewById<EditText>(R.id.et_profession)
        val btnAdd=findViewById<AppCompatButton>(R.id.btn_add)


        viewModel= ViewModelProvider(this@AddPersonalInfActivity)[PersonalInfoViewModel::class.java]

        btnAdd.setOnClickListener(){
            validation()
        }

    }
    fun validation(){
        if (name.text.toString().isNullOrEmpty()){
            name.setError("must be fill")

        } else if (qualification.text.toString().isNullOrEmpty()){
            qualification.setError("must be fill")
        } else if (age.text.toString().isNullOrEmpty()){
            age.setError("must be fill")
        } else if (profession.text.toString().isNullOrEmpty()){
            profession.setError("must be fill")
        } else{
             saveData()
            }

        }
     fun saveData(){
         var sName =name.text.toString()
         var sAge=age.text.toString()
         var sQualification=qualification.text.toString()
         var sProfession=profession.text.toString()
         var obj=PersonalInfo(sName,sAge.toInt(),sQualification,sProfession)
        // viewModel.insert(obj)


         viewModel.insert(PersonalInfo (sName,sAge.toInt(),sQualification,sProfession))
      //   viewModel.insert(PersonalInfo (sName,1,"abc","xyz"))
         Toast.makeText(this, " saved to Room Database. ", Toast.LENGTH_SHORT).show()
         finish()
     }


}