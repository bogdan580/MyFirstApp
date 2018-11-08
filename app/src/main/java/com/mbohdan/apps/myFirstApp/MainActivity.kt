package com.mbohdan.apps.myFirstApp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mapFragment: SupportMapFragment
    private var btn: Button? = null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        result = findViewById(R.id.tvresult) as TextView

        btn = findViewById(R.id.btn) as Button

        btn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, ScanActivity::class.java)
            startActivity(intent)
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                this.setTitle(R.string.title_home)
                    mapFragment.onResume()
                    mapView.visibility = View.VISIBLE
                    scanner.visibility = View.INVISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                this.setTitle(R.string.title_scanner)
                    mapFragment.onPause()
                    mapView.visibility = View.INVISIBLE
                    scanner.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                this.setTitle(R.string.title_notifications)
                    mapFragment.onPause()
                    mapView.visibility = View.INVISIBLE
                    scanner.visibility = View.INVISIBLE
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

    companion object {
        var result: TextView? = null
    }

}
