package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)


        // 아이템 리스트 준비 완료
        val carList = ArrayList<CarForList>()
        for(i in 0 until 10){
            carList.add(CarForList(""+ i + " 번째 자동차", "" + i + " 순위 엔진"))
        }

        //val adapter = ListViewAdapter(carList, layoutInflater.from(this@ListViewActivity))
        // 강의에서는 이렇게 사용하는데 리뉴얼 된 것 같음
        val adapter = ListViewAdapter(carList, layoutInflater)
        val listview = findViewById<ListView>(R.id.listview)
        listview.adapter = adapter
        listview.setOnItemClickListener{parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this, carName + " " + carEngine, Toast.LENGTH_SHORT).show()

        }
    }
}

class  ListViewAdapter(val carForList: ArrayList<CarForList>, val layoutInflater: LayoutInflater)
    : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /*val view = layoutInflater.inflate(R.layout.item_view, null)
        val carNameTextView = view.findViewById<TextView>(R.id.car_name)
        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)

        carNameTextView.setText(carForList.get(position).name)
        carEngineTextView.setText(carForList.get(position).engine)
        return view*/
        ////////////////// findViewById -> ViewHolder 함수 개선 전 코딩 ///////////////////

        val view: View
        val holder: ViewHolder
        if(convertView == null){
            view= layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()
            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

        return view
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)
        return carForList.get(position)       //position -> index(순서)
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
        return position.toLong()
    }

    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 전체 개수
        return carForList.size
    }
}

class ViewHolder{       //findViewById 함수는 리소스를 많이 차지하는 함수이므로 매번 찾기보다 ViewHolder에 담아놔서 개선, (컴퓨터가 필요할때마다 일일히 찾는게아니라 주소를 저장?해둔다고 생각하면될듯)
    var carName : TextView? = null
    var carEngine: TextView? = null
}