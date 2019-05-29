package kotlintest.hyoseung.ch5_network

import kotlintest.hyoseung.ch5_network.R.string.url
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.net.ConnectException

class OkHttpApiCall {

    fun GET(clinet:OkHttpClient, url : HttpUrl): String? {
        var request = Request.Builder()
                .url(url).build()
        var response : Response = clinet.newCall(request).execute()
        return response.body()!!.string()
    }

    fun POST(clinet: OkHttpClient, url:String?, jsonbody : String?): String? {
        var response : Response
        try {
            var request = Request.Builder()
                    .url(url)
                    //.post(body)
                    .post(RequestBody.create(MediaType.parse("application/json"), jsonbody))
                    .build()
            response = clinet.newCall(request).execute()
        } catch (e : IOException){
            return e.toString()
        }
            return response.body()!!.string()
    }

    fun LoginBody(id: String?, pw: String?): RequestBody {
        return FormBody.Builder()
                .add("id",id)
                .add("pw",pw)
                .build()
    }

    fun JsonBody(id: String?, pw: String?): String?{
        var JSONObject = JSONObject()
                .put("id",id)
                .put("pw",pw)

        return JSONObject.toString()
    }
}