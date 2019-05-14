package kotlintest.hyoseung.practice2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var map = mapOf(Pair("peach",R.drawable.peach),Pair("blueberry",R.drawable.blueberry),Pair("tomato",R.drawable.tomato))

        main_button.setOnClickListener {
            val id = map.get(main_editText.text.toString())
            if(id != null){
                main_imageView.setImageResource(id)
            }
            else
                Toast.makeText(applicationContext,"찾는 과일이 없습니다",Toast.LENGTH_LONG).show()
        }
    }
}