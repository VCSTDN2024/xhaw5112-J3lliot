package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ContactActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        val textInstagram: TextView = findViewById(R.id.textInstagram)
        textInstagram.text = Html.fromHtml("<a href='https://www.instagram.com/empowering.the.nation24'>Instagram: empowering.the.nation24</a>")
        textInstagram.movementMethod = LinkMovementMethod.getInstance()




        val btnBackToHome = findViewById<Button>(R.id.btnBackToHome)
        btnBackToHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        val vcSandton = LatLng(-26.093361091495385, 28.047734914018157)
        val vcWestville = LatLng(-29.839259497595485, 30.925173639520924)
        val vcCapeTown = LatLng(-33.97257574414553, 18.469510439668195)

        googleMap.addMarker(MarkerOptions().position(vcSandton).title("Sandton Venue"))
        googleMap.addMarker(MarkerOptions().position(vcWestville).title("Durban Venue"))
        googleMap.addMarker(MarkerOptions().position(vcCapeTown).title("Cape Town Venue"))

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vcSandton, 5f))

        // Set a listener for marker clicks
        googleMap.setOnMarkerClickListener { marker ->
            when (marker.title) {
                "Sandton Venue" -> googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vcSandton, 15f))
                "Durban Venue" -> googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vcWestville, 15f))
                "Cape Town Venue" -> googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vcCapeTown, 15f))
            }
            true // Return true to indicate that we have handled the event
        }

    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}