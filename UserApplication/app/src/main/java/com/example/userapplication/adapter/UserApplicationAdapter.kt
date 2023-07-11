package com.example.userapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.activity.MainActivity
import com.example.userapplication.R
import com.example.userapplication.data.UserModel
import com.example.userapplication.data.UserModelItem

class UserApplicationAdapter(mainActivity: MainActivity) :
    RecyclerView.Adapter<UserApplicationAdapter.MyViewHolder>() {
    private var userList: UserModel? = null

    fun setuserList(userList: UserModel) {
        this.userList = userList

    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val userimage = view.findViewById<ImageView>(R.id.userimage)

        val tvemail = view.findViewById<TextView>(R.id.tvemail)
        val tvgender = view.findViewById<TextView>(R.id.tvgender)
        val tvid = view.findViewById<TextView>(R.id.tvid)
        val tvname = view.findViewById<TextView>(R.id.tvname)
        val tvstatus = view.findViewById<TextView>(R.id.tvstatus)

        fun bind(data: UserModelItem) {
            tvemail.text = "email: " + data.email
            tvgender.text = "gender: " + data.gender
            tvid.text = "id: " + data.id.toString()
            tvname.text = "name: " + data.name
            tvstatus.text = "status: " + data.status


            if (data.gender == "male")
                userimage.setImageResource(R.drawable.ic_baseline_male_24)
            else {
                userimage.setImageResource(R.drawable.ic_baseline_female_24)

            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (userList == null) return 0
        else return userList?.size!!
    }
}