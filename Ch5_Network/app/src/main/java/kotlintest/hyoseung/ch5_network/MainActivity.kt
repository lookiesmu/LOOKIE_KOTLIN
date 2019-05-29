package kotlintest.hyoseung.ch5_network

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlintest.hyoseung.ch5_network.R.string.url
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.*

class MainActivity : AppCompatActivity() {
    var checkid : Boolean = false
    var id : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button_login.setOnClickListener {
            id = main_edit_id.text.toString()
            var pw = main_edit_pw.text.toString()

            Asynclogin().execute("${getString(R.string.url)}json",id, pw)
            //아이디 비번 서버로 보냄, 로그인 결과 0,1로 반환받음
        }

        main_button_signup.setOnClickListener{
            var intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    inner class Asynclogin : AsyncTask<String, Void, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String? {
                var clinet = OkHttpClient()
                try{
                    var okHttpApiCall =  OkHttpApiCall()
                    var response = okHttpApiCall.POST(clinet, params!![0],okHttpApiCall.JsonBody(params[1],params[2]))
                    return response
                } catch (e : IOException ){
                    //Toast.makeText(applicationContext,e.printStackTrace().toString(),Toast.LENGTH_LONG).show()
                }
                return null
        }

        override fun onPostExecute(result: String?) {
            if(result!!.get(0) != '{'){
                Toast.makeText(applicationContext, result,Toast.LENGTH_SHORT).show()
                return
            }

            var jsonObject : JSONObject = JSONObject(result)
            if(jsonObject.getInt("result")!=0){
                Toast.makeText(applicationContext,"환영합니다 ${id}님",Toast.LENGTH_LONG).show()
                var intent = Intent(applicationContext,BaseActivity::class.java)
                intent.putExtra("id",id)
                startActivity(intent)
                finish()
            }
            else
                Toast.makeText(applicationContext,"아이디가 존재하지 않습니다",Toast.LENGTH_LONG).show()
        }
    }
}
