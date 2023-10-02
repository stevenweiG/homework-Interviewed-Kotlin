package com.gogolook.stevenhm1_kotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.gogolook.stevenhm1_kotlin.adapter.ItemAdapter
import com.gogolook.stevenhm1_kotlin.data.Datasource
import com.gogolook.stevenhm1_kotlin.model.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //呼叫data package載入資料
        val myDataset = Datasource().loadPictures("book store", 1) //List<Picture>

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_View)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        viewModel.list.observe(this) { result ->
            (recyclerView.adapter as ItemAdapter).dataset = result

        }
        viewModel.newSearch()


    }
}