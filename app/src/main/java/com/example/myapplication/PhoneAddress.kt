package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class PhoneAddress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_address)

        val addressList = ArrayList<AddressList>()
        for(i in 0 until 10){
            addressList.add(AddressList(i+1, "" + (i+1) +"번 사람이름", "" + (i+1) + "번의 전화번호"))

        }

        val addressContainer = findViewById<LinearLayout>(R.id.addressContainer)
        val inflater = layoutInflater
        for(i in 0 until addressList.size){
            val item_address = inflater.inflate(R.layout.item_address, null)
            val number = item_address.findViewById<TextView>(R.id.item_number)
            val name = item_address.findViewById<TextView>(R.id.item_name)

            number.setText(addressList.get(i).number.toString())
            name.setText(addressList.get(i).name)

            item_address.setOnClickListener {
                val intent = Intent(this, InfoAddress::class.java)
                intent.apply {
                    this.putExtra("name", addressList.get(i).name)
                    this.putExtra("phone_number", addressList.get(i).phone_number)
                }
                startActivity(intent)
            }

            addressContainer.addView(item_address)
        }



        //회원정보 눌렀을때 상세화면 뜨는 기능 추가 intent복습해서 구현하기
    }
}


class AddressList(val number: Int, val name: String, val phone_number: String){

}