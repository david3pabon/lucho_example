package co.geekcode.lucho_example

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

fun onBindHolder(model: Data, itemView: View) {
    when(model) {
        is DataText -> bindViewHolderWithDataText(model, itemView)
        is DataImage -> bindViewHolderWithDataImage(model, itemView)
    }
}

private fun bindViewHolderWithDataText(model: DataText, itemView: View) {
    val name = itemView.findViewById(R.id.name_txt) as TextView
    name.text = model.value
}

private fun bindViewHolderWithDataImage(model: DataImage, itemView: View) {
    val image = itemView.findViewById(R.id.image_img) as ImageView
    Picasso.with(itemView.context).load(model.imgUrl).into(image)
}