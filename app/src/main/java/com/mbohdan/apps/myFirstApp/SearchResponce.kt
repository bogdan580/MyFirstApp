package com.mbohdan.apps.myFirstApp

data class User(
    val login: String,
    val id: Long,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val starred_url: String,
    val gists_url: String,
    val type: String,
    val score: Int
)

data class UserBean(
    val username: String,
    val password: String,
    val save: Boolean
)

data class Result (
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<User>
)