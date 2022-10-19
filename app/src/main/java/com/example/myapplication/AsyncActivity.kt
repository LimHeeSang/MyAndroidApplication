package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        var task: BackgroundAsyncTask? = null
        val ment: TextView = findViewById(R.id.ment)
        val progressbar: ProgressBar = findViewById(R.id.progressbar)


        val start: Button = findViewById(R.id.start)
        start.setOnClickListener {
            task = BackgroundAsyncTask(progressbar, ment)       //클릭을 할때마다 매번 만들어줘야하기 때문에 이부분에 작성
            task?.execute()
        }

        val stop: Button = findViewById(R.id.stop)
        stop.setOnClickListener {
            task?.cancel(true)
        }
    }

    override fun onPause() {
        //task?. cancel(true)    Async를 다른 activitiy로 이동해도 종료하는 방법 (변수범위)
        super.onPause()
    }
}


class BackgroundAsyncTask(
    val progressbar: ProgressBar,
    val progressText: TextView
): AsyncTask<Int, Int, Int>(){
    // params -> doInbackground 에서 사용할 타입
    // progress -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExcute 에서 사용할 타입

    var percent: Int = 0

    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while(isCancelled() == false){
            percent++
            if (percent > 100){
                break
            }else{
                publishProgress(percent)    //중간중간 메인스레드로 데이터 전달목적
            }
            try {
                Thread.sleep(100)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?: 0)
        progressText.setText("퍼센트: " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }
}
