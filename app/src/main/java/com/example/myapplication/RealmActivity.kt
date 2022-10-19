package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this)
        // config -> Realm을 초기화 할때 이런방식으로 초기화를 해줘!
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded().build()
        //migration -> 데이터베이스 테이블에 속성추가할때 튜플삭제
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        val button_save: Button = findViewById(R.id.button_save)
        button_save.setOnClickListener {
            realm.executeTransaction{
                // A테이블에서 데이터를 가져온다 -> 10
                // B테이블에서 데이터를 가져온다
                // C페이블에서 데이터를 가져온다
                // 조합을 한다
                // D테이블에 저장을 한다
                // => 작업단위를 묶은다
                with(it.createObject(School::class.java)){
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }


        val button_load: Button = findViewById(R.id.button_load)
        button_load.setOnClickListener {
            realm.executeTransaction{
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa", "data : " + data)
            }
        }

        val button_delete: Button = findViewById(R.id.button_delete)
        button_delete.setOnClickListener {
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm()
                //it.where(School::class.java).findFirst().deleteFromRealm()
            }
        }
    }
}