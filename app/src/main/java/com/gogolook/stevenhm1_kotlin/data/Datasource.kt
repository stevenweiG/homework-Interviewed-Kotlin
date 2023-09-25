package com.gogolook.stevenhm1_kotlin.data

class Datasource {

    fun loadPictures():List<Picture>{

        var url="https://pixabay.com/api/?key=%s&q=%s"
        val key="38378111-b28747f4843ada3a5a5370de2"

        //todo 向api rq資料並回傳 需要使用retrofit or 2?







        var temp = mutableListOf<Picture>()

        return  temp


    }

}
class Picture{
    public var id=""
    public var downloads=""
    public var views=""
    public var Url=""

}