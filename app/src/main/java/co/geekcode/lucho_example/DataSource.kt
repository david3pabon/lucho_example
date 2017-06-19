package co.geekcode.lucho_example

import okhttp3.OkHttpClient
import okhttp3.Request
import io.reactivex.Observable
import org.json.JSONObject

/**
 * Created by Owner on 6/15/2017.
 */
//JSON URL Address
val URL = "https://api.myjson.com/bins/1fdwhn"

// Make the request
fun requestJSON(url: String) : Observable<MutableList<Data>> {
    return Observable.create({
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        val response  = client.newCall(request).execute()
        val body = response.body()
        it.onNext(jsonToObject(if (body != null) body.string() else ""))
        it.onComplete()
    })
}

//Parse response
fun jsonToObject(json: String) : MutableList<Data> {
    var result = mutableListOf<Data>()
    try {
        val jsonResponse = JSONObject(json)
        val jsonArray = jsonResponse.getJSONArray("data")
        (0 .. (jsonArray.length() - 1))
                .forEach {
                    val jsonObject = jsonArray.getJSONObject(it)

                    if (jsonObject.getInt("type") == Data.TYPE_TEXT) {
                        result.add(DataText(jsonObject.getInt("type"), jsonObject.getString("value")))
                    } else {
                        result.add(DataImage(jsonObject.getInt("type"), jsonObject.getString("value")))
                    }
                }
    } catch (e: Exception) {
        //Handle error
        e.printStackTrace()
    }
    return result
}