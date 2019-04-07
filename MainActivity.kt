package org.yscheon.button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listener1 = btsListner()
        Button2.setOnClickListener(listener1)

        Button3.setOnClickListener{
                textView1.setText("버튼 3을 눌렀습니다.")
        }
    }

    fun onButton1Clicked(V: View){
        textView1.setText("버튼 1을 눌렀습니다.")
    }

    inner class btsListner:View.OnClickListener{
        override fun onClick(v: View?) {
            textView1.setText("버튼 2를 눌렀습니다.")
        }
    }
}