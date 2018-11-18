package com.mbohdan.apps.myFirstApp

import io.reactivex.Observable

class SearchRepository(val apiService: GithubApiService) {
    fun searchUsers(language: String): Observable<Result> {
        return apiService.search(query = "language:$language",page = 1, perPage = 50)
    }
}