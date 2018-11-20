package com.mbohdan.apps.myFirstApp

import io.reactivex.Observable
import retrofit2.Call

class SearchRepository(val apiService: GithubApiService) {
    fun searchUsers(language: String): Observable<Result> {
        return apiService.search(query = "language:$language",page = 1, perPage = 50)
    }
}
class LoginRepository(val apiService: ServerApiService) {
    fun getProfile(authHeader: String): Call<Profile> {
        return apiService.getProfile(authHeader)
    }
}
