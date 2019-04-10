package org.yscheon.button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*
import org.yscheon.button.R.id.*

class CheckBox : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listener1 = btsListner()
        Button1.setOnClickListener(listener1)
        var listener2 = rb1Lister()
        var listener3 = rb2Lister()
        radio1.setOnCheckedChangeListener(listener2)
        radio2.setOnCheckedChangeListener(listener3)
    }

    inner class btsListner:View.OnClickListener{
        override fun onClick(v: View?) {
            if (Check1.isChecked ==true){
                textView1.setText("체크박스를 체크하였습니다.")
            }else {
                textView1.setText("체크박스를 체크하지 않았습니다.")
            }
        }
    }
    inner class rb1Lister : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(c0: CompoundButton?, c1: Boolean) {
            if (c1 == true){
                Check1.setEnabled(true)
            }
        }
    }
    inner class rb2Lister : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(c0: CompoundButton?, c1: Boolean) {
            if (c1 == true){
                Check1.setEnabled(false)
            }
        }
    }
}