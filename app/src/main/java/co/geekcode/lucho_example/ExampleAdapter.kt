package co.geekcode.lucho_example

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Owner on 6/15/2017.
 */
class ExampleAdapter : RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    private var dataList: MutableList<Data> = mutableListOf()

    val viewByDataType = hashMapOf(
            Data.TYPE_TEXT to R.layout.row_text,
            Data.TYPE_IMAGE to R.layout.row_image)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ExampleAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(viewByDataType[viewType]!!, parent, false)
        return ExampleAdapter.ViewHolder(v)
    }

    override fun getItemViewType(i: Int): Int = dataList[i].type

    override fun onBindViewHolder(vh: ExampleAdapter.ViewHolder, i: Int) {
        onBindHolder(dataList[i], vh.itemView)
    }

    override fun getItemCount(): Int = dataList.size

    fun setDataList(dataList: MutableList<Data>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
