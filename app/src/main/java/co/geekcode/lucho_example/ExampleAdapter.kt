package co.geekcode.lucho_example

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.squareup.picasso.Picasso

/**
 * Created by Owner on 6/15/2017.
 */

class ExampleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList: MutableList<Data> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder: RecyclerView.ViewHolder

        when (viewType) {
            Data.TYPE_IMAGE -> holder = getImageView(viewGroup)
            else -> holder = getTextView(viewGroup)
        }

        return holder
    }

    override fun getItemViewType(i: Int): Int {
        return dataList[i].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, i: Int) {
        val data = dataList[i]

        when (holder) {
            is TextViewHolder -> holder.name.text = data.value
            is ImageViewHolder -> Picasso.with(holder.image.context).load(data.value).into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setDataList(dataList: MutableList<Data>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    private fun getTextView(viewGroup: ViewGroup) : TextViewHolder {
        val root = LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.row_text, viewGroup, false)
        return TextViewHolder(root)
    }

    private fun getImageView(viewGroup: ViewGroup) : ImageViewHolder {
        val root = LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.row_image, viewGroup, false)
        return ImageViewHolder(root)
    }

    internal inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name_txt) as TextView
    }

    internal inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image_img) as ImageView
    }
}
