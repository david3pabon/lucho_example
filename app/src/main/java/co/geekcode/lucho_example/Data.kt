package co.geekcode.lucho_example

/**
 * Created by Owner on 6/15/2017.
 */

class Data(val type: Int = TYPE_NAME,
           val value: String = "NO DATA") : Model {
    companion object {
        val TYPE_NAME = 1
        val TYPE_IMAGE = 2
    }
}
