package com.example.retrofit

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), NewsAdapter.OnItemClickListener {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news=NewsService.newsInstance.getHeadLine("in",1)
        news.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news =response.body()!!
                adapter= NewsAdapter(this@MainActivity,news.articles,this@MainActivity)
                recycleView.adapter=adapter
                recycleView.layoutManager=LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Suraj","Error",t)
            }
        })
    }

    override fun onItemClick(News: Article) {
        val builder =CustomTabsIntent.Builder()
        val customTabsIntent= builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(News.url))
    }
}


