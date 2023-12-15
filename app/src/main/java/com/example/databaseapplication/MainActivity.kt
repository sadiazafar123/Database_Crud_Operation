package com.example.databaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseapplication.R
import com.example.databaseapplication.adapter.PersonalInfoAdapter
import com.example.databaseapplication.personalinfodb.PersonalInfo
import com.example.databaseapplication.personalinfodb.PersonalInfoDatabase
import com.example.databaseapplication.personalinfodb.PersonalInfoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

 class MainActivity : AppCompatActivity() ,PersonalInfoAdapter.OnItemClickListener{
    lateinit var recycler: RecyclerView
   // , PersonalInfoAdapter.OnItemClickListener

    lateinit var allInfo: List<PersonalInfo>
    lateinit var viewModel: PersonalInfoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler= findViewById(R.id.recyclerView)
       // allInfo = ArrayList()
        viewModel= ViewModelProvider(this@MainActivity)[PersonalInfoViewModel::class.java]
       findViewById<FloatingActionButton>(R.id.addButton).setOnClickListener {
           startActivity(Intent(this@MainActivity, AddPersonalInfActivity::class.java))
        }
        Log.v("UserData","onCreate")
        viewModel.getAllInfo().observe(this@MainActivity){
            Log.v("UserData","$it")
           allInfo=it

            setPersonalInfo()


        }
    }

    override fun onResume() {
        super.onResume()
      //  Log.v("UserData","onResume")

    }
    fun setPersonalInfo(){
       // val infoAdapter = PersonalInfoAdapter(allInfo,this@MainActivity)
        val infoAdapter= PersonalInfoAdapter(allInfo,this@MainActivity)
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=infoAdapter


    }




      override fun onDeleteIconClick(position: Int) {
          Log.v("UserData","onDeleteIconClick"+ position)
          Log.v("UserData","onDeleteIconClick"+ allInfo.get(position))
          //position which we click on
          viewModel.delete(allInfo.get(position))

      }

   override fun onItemlick(position: Int) {
        Log.v("UserData","onDeleteIconClick"+ allInfo.get(position))
        val intent=Intent(this,UpdateActivity::class.java)
        intent.putExtra("personal_info_object",allInfo.get(position))
        startActivity(intent)


    }
    }