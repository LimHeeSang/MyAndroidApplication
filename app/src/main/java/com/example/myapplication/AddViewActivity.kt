package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        // 아이템 리스트 준비 완료
        val carList = ArrayList<CarForList>()
        for(i in 0 until 10){
            carList.add(CarForList(""+ i + " 번째 자동차", "" + i + " 순위 엔진"))
        }

        val container = findViewById<LinearLayout>(R.id.addview_container)
        val inflater = layoutInflater
        //val inflater = this.layoutInflater 강의에서는 이렇게 사용했는데 똑같은거 같음
        for(i in 0 until carList.size){
            val item_view = inflater.inflate(R.layout.item_view, null)
            val carNameView = item_view.findViewById<TextView>(R.id.car_name)
            val carEngineCiew = item_view.findViewById<TextView>(R.id.car_engine)

            carNameView.setText(carList.get(i).name)
            carEngineCiew.setText(carList.get(i).engine)
            container.addView(item_view)
        }
    }
}

class CarForList(val name: String, val engine: String){

}