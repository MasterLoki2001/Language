package com.example.instagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter:Adapter = Adapter()
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleview.adapter = adapter
        setData()
    }
    fun setData(){
        var data:MutableList<PostAds> = mutableListOf()
        for (i in 0 until 100){
            if (i%5==0){
                var reklama=Ads(1,"","")
                data.add(reklama)
            }
            else{
                var post = Post(2,"","","")
                data.add(post)
            }
        }
        adapter.models=data
    }
}