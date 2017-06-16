package co.geekcode.lucho_example

import android.view.View
import android.widget.TextView
import co.geekcode.lucho_example.ExampleAdapter.ViewHolder

/**
 * Created by Owner on 6/16/2017.
 */
class TextViewHolder(itemView: View) : ViewHolder<Data>(itemView) {

    override fun onBindViewHolder(model: Data) {
        val name = itemView.findViewById(R.id.name_txt) as TextView
        name.text = model.value
    }
}