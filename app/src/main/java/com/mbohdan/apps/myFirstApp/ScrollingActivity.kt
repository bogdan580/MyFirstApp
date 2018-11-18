package com.mbohdan.apps.myFirstApp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    private var textInScrollView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        textInScrollView = findViewById(R.id.textInScrollView) as TextView

        val repository = SearchRepositoryProvider.provideSearchRepository()
        repository.searchUsers( "Java")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->
                Log.d("Result", "There are ${result.items.size} Java developers in Lagos")

                var text = "############ getResponce ok ############\n"
                result.items.forEach {
                    text += "type: " + it.type + ",\tlogin: " + it.login + "\n"
                 }
                textInScrollView!!.text = text

            }, { error ->
                error.printStackTrace()
            })
    }


    object SearchRepositoryProvider {
        val apiService = GithubApiService.create()

        fun provideSearchRepository(): SearchRepository {
            return SearchRepository(apiService)
        }
    }
}
