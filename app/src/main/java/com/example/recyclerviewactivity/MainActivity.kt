package com.example.recyclerviewactivity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var RecyclerView: RecyclerView? = null
    private var btnadd : Button? = null
    private var btndelete : Button? = null
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecyclerView = findViewById(R.id.RecyclerView)
        btnadd = findViewById(R.id.btnadd)
        btndelete = findViewById(R.id.btndelete)

        btnadd?.setOnClickListener {
            adapter.add("Novyi text")
        }

        btndelete?.setOnClickListener {
        adapter.delete(0)
        }

        val list = arrayListOf<String>()
        for (i in 1..100) {
            list.add("text $i")
        }

        RecyclerView?.adapter = adapter
        adapter.update(list)
    }
}