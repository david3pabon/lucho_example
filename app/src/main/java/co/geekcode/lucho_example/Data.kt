package co.geekcode.lucho_example

/**
 * Created by Owner on 6/15/2017.
 */
interface Model

open class Data(val type: Int = Data.TYPE_TEXT) : Model {
    companion object {
        val TYPE_TEXT = 1
        val TYPE_IMAGE = 2
    }
}

class DataText(type: Int, val value: String) : Data(type)
class DataImage(type: Int, val imgUrl: String) : Data(type)
