package com.mbohdan.apps.myFirstApp.paging_library

import com.google.gson.annotations.SerializedName

class Models {
    data class Response(
        @SerializedName("articles") val news: List<News>
    )

    data class News(
        val title: String,
        @SerializedName("urlToImage") val image: String
    )
}