package com.example.databaseapplication.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseapplication.R
import com.example.databaseapplication.personalinfodb.PersonalInfo

class PersonalInfoAdapter(val infoAdapter: List<PersonalInfo>, var mListener: OnItemClickListener)
    :RecyclerView.Adapter
<PersonalInfoAdapter.MyPersonalInfoAdapter>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPersonalInfoAdapter {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.adapter_layout,parent,false)
        return MyPersonalInfoAdapter(view)

    }

    override fun getItemCount(): Int {
         return infoAdapter.size
    }

    override fun onBindViewHolder(holder: MyPersonalInfoAdapter, position: Int) {
        holder.tvName.text = infoAdapter[position].name
        holder.tvAge.text =  infoAdapter[position].age.toString()
        holder.tvProfession.text=infoAdapter[position].profession
        holder.tvQualification.text=infoAdapter[position].qualification
       holder.delRecord.setOnClickListener(){
            mListener.onDeleteIconClick(position)
        }
       holder.itemClick.setOnClickListener(){
            mListener.onItemlick(position)
        }





    }
    class MyPersonalInfoAdapter(itemview: View):RecyclerView.ViewHolder(itemview){
        var tvName:TextView=itemview.findViewById(R.id.tv_name)
        var tvAge:TextView=itemview.findViewById(R.id.tv_age)
        var tvQualification:TextView=itemview.findViewById(R.id.tv_qualification)
        var tvProfession:TextView=itemview.findViewById(R.id.tv_profession)
        var delRecord:ImageView=itemview.findViewById(R.id.delRecord)
        var itemClick:LinearLayout=itemview.findViewById(R.id.itemClick)






    }


    interface OnItemClickListener {
        fun onDeleteIconClick(position: Int)
        fun onItemlick(position: Int)
    }

}