package co.geekcode.lucho_example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeActivity : AppCompatActivity() {

    var adapter = ExampleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()
        requestData()
    }

    private fun requestData() {
        requestJSON(URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn { mutableListOf() }
                .subscribe { adapter.setDataList(it) }
    }

    private fun initView() {
        var list: RecyclerView = findViewById(R.id.items_lst) as RecyclerView
        list.adapter = this.adapter
        list.layoutManager = LinearLayoutManager(this)
    }
}
