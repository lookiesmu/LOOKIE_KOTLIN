package kotlintest.hyoseung.ch4_recyclerview

import android.app.PendingIntent.getActivity
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import kotlintest.hyoseung.ch4_recyclerview.R.id.main_insert
import kotlintest.hyoseung.ch4_recyclerview.R.id.main_userlist
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userAdapter = userAdapter(applicationContext, ArrayList<user>())
        main_userlist.adapter = userAdapter
        main_userlist.layoutManager = LinearLayoutManager(applicationContext)
        main_userlist.setHasFixedSize(true)

        main_insert.setOnClickListener {
            var name:String?
            var age:String?
            var major:String?
            var builder = AlertDialog.Builder(this)

            builder.setTitle("회원 추가")

            var view = layoutInflater.inflate(R.layout.view_dialog_insert,null)
            builder.setView(view)

            var positiveListener = object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int){
                    var alert = dialog as AlertDialog
                    name  = alert.findViewById<EditText>(R.id.view_dialog_insert_name)?.text.toString()
                    age = alert.findViewById<EditText>(R.id.view_dialog_insert_age)?.text.toString()
                    major = alert.findViewById<EditText>(R.id.view_dialog_insert_major)?.text.toString()
                    userAdapter.add(user(name,Integer.parseInt(age),major))
                    userAdapter.notifyDataSetChanged()
                }
            }
            builder.setPositiveButton("추가", positiveListener)
            builder.setNegativeButton("취소",null)
            builder.show()
        }
    }
}
