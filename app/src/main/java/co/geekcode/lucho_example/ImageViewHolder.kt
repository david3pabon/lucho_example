package co.geekcode.lucho_example

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Owner on 6/16/2017.
 */
class ImageViewHolder(itemView: View) : ExampleAdapter.ViewHolder<Data>(itemView) {

    override fun onBindViewHolder(model: Data) {
        val image = itemView.findViewById(R.id.image_img) as ImageView
        Picasso.with(itemView.context).load(model.value).into(image)
    }
}