package co.geekcode.lucho_example

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Owner on 6/15/2017.
 */

class ExampleAdapter : RecyclerView.Adapter<ExampleAdapter.ViewHolder<Data>>() {

    private val dataList: MutableList<Data> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ExampleAdapter.ViewHolder<Data>
            = when (viewType) {
                Data.TYPE_IMAGE -> getImageView(viewGroup)
                else -> getTextView(viewGroup)
            }

    override fun getItemViewType(i: Int): Int = dataList[i].type

    override fun onBindViewHolder(holder: ExampleAdapter.ViewHolder<Data>, i: Int) {
        holder.onBindViewHolder(dataList[i])
    }

    override fun getItemCount(): Int = dataList.size

    fun setDataList(dataList: MutableList<Data>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    private fun getTextView(viewGroup: ViewGroup) : TextViewHolder {
        return TextViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.row_text, viewGroup, false))
    }

    private fun getImageView(viewGroup: ViewGroup) : ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.row_image, viewGroup, false))
    }

    abstract class ViewHolder<in T: Model> (itemView: View) :
             RecyclerView.ViewHolder(itemView) {
        abstract fun onBindViewHolder(model: T)
    }
}
