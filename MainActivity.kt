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
        //방법3 익명 클래스를 람다식으로 써보기
        Button3.setOnClickListener{
                textView1.setText("버튼 3을 눌렀습니다.")
        }
    }
//방법1 xml OnClick 속성에 지정한 함수 정의
    fun onButton1Clicked(V: View){
        textView1.setText("버튼 1을 눌렀습니다.")
    }
    
//방법2 View.OnclickListener를 상속받는 class를 활용해보기
    inner class btsListner:View.OnClickListener{
        override fun onClick(v: View?) {
            textView1.setText("버튼 2를 눌렀습니다.")
        }
    }
}
