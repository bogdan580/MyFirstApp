package com.mbohdan.apps.myFirstApp.paging_library

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mbohdan.apps.myFirstApp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(news: Models.News?) {
        try {
            if (news != null) {
                itemView.txt_news_name.text = news.title
                Picasso.get().load(news.image).into(itemView.img_news_banner)
            }
        } catch (e: Exception ) {

        }
    }

    companion object {
        fun create(parent: ViewGroup): NewsViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
            return NewsViewHolder(view)
        }
    }
}
