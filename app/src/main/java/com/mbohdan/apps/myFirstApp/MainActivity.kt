package com.mbohdan.apps.myFirstApp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var fr: SupportMapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fr = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        fr.getMapAsync(this)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                this.setTitle(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                this.setTitle(R.string.title_dashboard)
//                container.visibility = View.INVISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                this.setTitle(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }



    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val psk = LatLng(50.8789284, 20.6401195)
        val echo = LatLng(50.880027, 20.647547)
        mMap.addMarker(MarkerOptions().position(psk).title("Marker in PŚK"))
        mMap.addMarker(MarkerOptions().position(echo).title("Marker in ECHO"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(psk))
    }
}
