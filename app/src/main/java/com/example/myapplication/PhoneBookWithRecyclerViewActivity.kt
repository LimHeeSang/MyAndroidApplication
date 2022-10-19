package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)


        val phonebookList = ArrayList<PersonForPhoneBook>()
        for(i in 0 until 30){
            phonebookList.add(PersonForPhoneBook(i+1, "" + (i+1) + " 번째 사람이름", "" + (i+1) + "번째 사람 전화번호"))
            Log.d("number", ""+i)
        }

        val adapter = PhoneBookAdapter(phonebookList, LayoutInflater.from(this), this)
        val phonebookrecyclerview = findViewById<RecyclerView>(R.id.phonebook_recycler_view)
        phonebookrecyclerview.adapter = adapter
        phonebookrecyclerview.layoutManager = LinearLayoutManager(this)
        
    }
}


class PhoneBookAdapter(
    val phonebookList: ArrayList<PersonForPhoneBook>,
    val inflater: LayoutInflater,
    val activity: Activity
): RecyclerView.Adapter<PhoneBookAdapter.ViewHolder>(){

    inner class ViewHolder(item_address: View):RecyclerView.ViewHolder(item_address){
        val item_number:TextView
        val item_name: TextView
        init {
            item_number = item_address.findViewById(R.id.item_number)
            item_name = item_address.findViewById(R.id.item_name)
            ////////액션리스너//////////
            item_address.setOnClickListener {
                val position: Int = adapterPosition
                val intent = Intent(activity, InfoAddress::class.java)
                intent.apply {
                    this.putExtra("name", phonebookList.get(position).name)
                    this.putExtra("phone_number", phonebookList.get(position).phone_number)
                }
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_address, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("number", ""+phonebookList.size)
        return phonebookList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item_number.setText(phonebookList.get(position).number.toString())
        holder.item_name.setText(phonebookList.get(position).name)
    }
}





class PersonForPhoneBook(
    val number: Int,
    val name: String,
    val phone_number: String
){
}



