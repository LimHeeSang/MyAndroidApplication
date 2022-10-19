package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView

.ViewHolder

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // 아이템 리스트 준비 완료
        val carList = ArrayList<CarForList>()
        for(i in 0 until 10){
            carList.add(CarForList(""+ i + " 번째 자동차", "" + i + " 순위 엔진"))
        }

        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this))
        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this) //xml에서도 가능
        //recycler_view.layoutManager = GridLayoutManager(this, 2)
    }
}

class RecyclerViewAdapter(
    val itemList: ArrayList<CarForList>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){  /////<>안의 타입 ViewHolder클래스를 정의하고 넣어줌

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){       //뷰홀더 클래스
        val carName: TextView
        val carEngine: TextView
        init{
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)
            itemView.setOnClickListener {
                val position: Int = adapterPosition     //adapterPosition변수 -> position을 받지 않아도 알수있음
                val engineName = itemList.get(position).engine
            }
        }
    }
    ///////////////////////ViewHolder 클래스를 만들고 implement를 해야함
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }
}