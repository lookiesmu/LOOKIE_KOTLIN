package kotlintest.hyoseung.ch6_test

import android.content.DialogInterface
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.main_menu_login->{
                var builder = AlertDialog.Builder(this)
                    .setTitle("로그인")
                        .setView(layoutInflater.inflate(R.layout.dialog_view_login,null))

                var listener = object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        var alert = dialog as AlertDialog
                        var id = alert.findViewById<EditText>(R.id.dialog_view_login_id)?.text.toString()
                        var pw = alert.findViewById<EditText>(R.id.dialog_view_login_pw)?.text.toString()

                        Asynctask().execute(getString(R.string.server_url_login),id,pw)
                    }
                }

                builder.setPositiveButton("로그인",listener)
                builder.setNegativeButton("취소",null)

                builder.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    inner class Asynctask : AsyncTask<String?, Void, String?>() {
        var id : String? = null

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String? {
            var client = OkHttpClient()
            var url = params[0]
            id = params[1]
            var pw = params[2]

            var response : String?

            try{
                var okhttpApi = OkhttpApi()
                response = okhttpApi.POST(client,url,okhttpApi.jsonbody(id, pw))
            } catch (e: IOException){
                return e.toString()
            }

            return response
        }

        override fun onPostExecute(result: String?) {
            if (result?.get(0) != '{'){
                Toast.makeText(applicationContext,"통신 에러",Toast.LENGTH_SHORT).show()
                //main_act_textview.text="통신 에러"
            }
            else{
                var jsonObject = JSONObject(result)
                if(jsonObject.getInt("result") != 0){
                    main_act_textview.text = "${id}님 환영합니다"
                }
                else{
                    Toast.makeText(applicationContext,"로그인이 실패하였습니다",Toast.LENGTH_SHORT).show()
                }
                //var check = jsonObject.getInt("result")
            }
        }
    }
}
