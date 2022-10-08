package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class NewsAdapter(private val context:Context, val article: List<Article>, private val listener:OnItemClickListener):RecyclerView.Adapter<NewsAdapter.NewViewHolder>() {

    inner class NewViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView),View.OnClickListener{
        var newsImage: ImageView=itemView.findViewById<ImageView>(R.id.image_move)
        var newsTitle: TextView=itemView.findViewById<TextView>(R.id.title)
        var newsdiscription : TextView=itemView.findViewById<TextView>(R.id.newsDiscription)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position=adapterPosition
            if(position!=RecyclerView.NO_POSITION) {
                listener.onItemClick(article[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return NewViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        val article=article[position]
        holder.newsTitle.text=article.title
        holder.newsdiscription.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return article.size
    }

    interface OnItemClickListener{
        fun onItemClick(News:Article)
    }
}