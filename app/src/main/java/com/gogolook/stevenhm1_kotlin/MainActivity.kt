package com.gogolook.stevenhm1_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.gogolook.stevenhm1_kotlin.adapter.ItemAdapter
import com.gogolook.stevenhm1_kotlin.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //呼叫data package載入資料
        val myDataset=Datasource().loadPictures() //List<Picture>

        val recyclerView=findViewById<RecyclerView>(R.id.recycler_View)
        recyclerView.adapter=ItemAdapter(this,myDataset)

    }
}