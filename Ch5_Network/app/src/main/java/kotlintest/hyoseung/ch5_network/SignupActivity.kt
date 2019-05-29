package kotlintest.hyoseung.ch5_network

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlintest.hyoseung.ch5_network.R.string.url
import kotlinx.android.synthetic.main.activity_signup.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_button_signup.setOnClickListener{
            var id = signup_edit_id.text.toString()
            var pw = signup_edit_pw.text.toString()

            //서버로 id, pw 전송
            Asyncsignup().execute("${getString(R.string.url)}profile",id, pw)

            //Toast.makeText(applicationContext,"${getString(R.string.url)}json", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    inner class Asyncsignup : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String?): String? {
            var clinet = OkHttpClient()
            try{
                var okHttpApiCall =  OkHttpApiCall()
                var response = okHttpApiCall.POST(clinet, params!![0],okHttpApiCall.JsonBody(params[1],params[2]))
                return response
            } catch (e : IOException ){
                Toast.makeText(applicationContext,e.printStackTrace().toString(),Toast.LENGTH_LONG).show()
            }
            return null
        }

        override fun onPostExecute(result: String?) {
            if(result!!.get(0) != '{'){
                Toast.makeText(applicationContext, "Can't find server",Toast.LENGTH_SHORT).show()
                return
            }
        }
    }
}