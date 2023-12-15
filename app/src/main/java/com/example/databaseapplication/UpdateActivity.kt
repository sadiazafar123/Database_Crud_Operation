package com.example.databaseapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.databaseapplication.personalinfodb.PersonalInfo
import com.example.databaseapplication.personalinfodb.PersonalInfoViewModel
import java.util.Objects

class UpdateActivity : AppCompatActivity() {
    lateinit var viewModel2: PersonalInfoViewModel


    lateinit var updateName:EditText
            lateinit var updateAge:EditText
            lateinit var updateQualification:EditText
            lateinit var updateProfession:EditText
            lateinit var updateButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
         updateName = findViewById(R.id.update_name)
         updateAge =  findViewById(R.id.update_age)
         updateQualification = findViewById(R.id.update_qualification)
         updateProfession = findViewById(R.id.update_profession)
         updateButton = findViewById(R.id.btn_update)
         viewModel2 = ViewModelProvider(this@UpdateActivity)[PersonalInfoViewModel::class.java]

        var personalInfoObject: PersonalInfo?
        if(Build.VERSION.SDK_INT >= 33/*Build.VERSION_CODES.TIRAMISU*/) {
            personalInfoObject = intent.extras?.getParcelable("personal_info_object", PersonalInfo::class.java)
        }
        else {
            personalInfoObject = intent.extras?.getParcelable("personal_info_object")
        }
       /* var personalInfoObject: PersonalInfo?
        if (Build.VERSION.SDK_INT>=33){
            personalInfoObject= intent.extras?.getParcelable("personal_info_object",PersonalInfo::class.java)

        } else{
            personalInfoObject=intent.extras?.getParcelable("personal_info_object")
        }
        personalInfoObject?.let {
            updateName.setText(it.name)
            updateAge.setText(it.age)
            updateQualification.setText(it.qualification)
            updateProfession.setText(it.profession)

        }*/

       Toast.makeText(this,"$personalInfoObject", Toast.LENGTH_SHORT).show()
        personalInfoObject?.let {
             updateName.setText(it.name)
            updateAge.setText(it.age.toString())
            updateQualification.setText(it.qualification)
            updateProfession.setText(it.profession)
        }


//        personalInfoObject?.let {
//            Toast.makeText(this,"let in $it,  ${it.name}", Toast.LENGTH_SHORT).show()
//        } ?: run {
//            Toast.makeText(this,"run in $personalInfoObject,  ${personalInfoObject?.name}", Toast.LENGTH_SHORT).show()
//        }
//        var name=personalInfoObject?.name
//         Toast.makeText(this,"$personalInfoObject,  ${personalInfoObject?.name}", Toast.LENGTH_SHORT).show()


        //var namessss =personalInfoObjects.`class`.name
       // Toast.makeText(this,"$namessss", Toast.LENGTH_SHORT).show()



        //var

      //  personalInfoObject= PersonalInfo(updateName.text.toString(),"","","", personalInfoObject!!.id);
        updateButton.setOnClickListener(){
            personalInfoObject= PersonalInfo(updateName.text.toString(),updateAge.text.toString().toInt(),updateQualification.text.toString(),
                updateProfession.text.toString(),personalInfoObject!!.id)
            viewModel2.update(personalInfoObject)
            finish()




        }
    }
}