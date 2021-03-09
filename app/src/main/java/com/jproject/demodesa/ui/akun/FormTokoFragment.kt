@file:Suppress("DEPRECATION")

package com.jproject.demodesa.ui.akun

import android.R.attr
import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.Places
import com.google.android.gms.location.places.ui.PlacePicker
import com.jproject.demodesa.R
import kotlinx.android.synthetic.main.fragment_form_toko.*
import kotlinx.android.synthetic.main.fragment_form_toko.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormTokoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormTokoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val MY_PERMISSION_FINE_LOCATION = 101
    private var PLACE_PICKER_REQUEST = 1
    private var alamat_jemput: String? = null
    private  var lat:kotlin.String? = null
    private  var lng:kotlin.String? = null
    private var mGoogleApiClient: GoogleApiClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_form_toko, container, false)
        root.alamat.onClick {
//            val builder = PlacePicker.IntentBuilder()
//            try {
//                val intent = builder.build(requireContext() as Activity?)
//                startActivityForResult(intent, PLACE_PICKER_REQUEST)
//            } catch (e: GooglePlayServicesRepairableException) {
//                e.printStackTrace()
//            } catch (e: GooglePlayServicesNotAvailableException) {
//                e.printStackTrace()
//            }
//            val builder = PlacePicker.IntentBuilder()
//            startActivityForResult(builder.build(requireActivity()), PLACE_PICKER_REQUEST)

            val builder = PlacePicker.IntentBuilder()
            try {
                //menjalankan place picker
                startActivityForResult(builder.build(requireActivity()), PLACE_PICKER_REQUEST)

                // check apabila <a title="Solusi Tidak Bisa Download Google Play Services di Android" href="http://www.twoh.co/2014/11/solusi-tidak-bisa-download-google-play-services-di-android/" target="_blank">Google Play Services tidak terinstall</a> di HP
            } catch (e: GooglePlayServicesRepairableException) {
                e.printStackTrace()
            } catch (e: GooglePlayServicesNotAvailableException) {
                e.printStackTrace()
            }
        }


        return root
    }
    private fun buildGoogleApiClient() {
        mGoogleApiClient = GoogleApiClient.Builder(requireActivity())
            .addApi(Places.GEO_DATA_API)
            .addApi(Places.PLACE_DETECTION_API)
            .enableAutoManage(requireActivity(), null)
            .build()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSION_FINE_LOCATION -> if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    requireContext(),
                    "This app requires location permissions to be granted",
                    Toast.LENGTH_LONG
                ).show()

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                val place: Place = PlacePicker.getPlace(data, requireContext())
                val toastMsg = String.format(
                    """
                  Place: %s 
                  Alamat: %s 
                  Latlng %s 
                  
                  """.trimIndent(),
                    place.name.toString(),
                    place.address.toString(),
                    place.latLng.latitude.toString() + " " + place.latLng.longitude
                )
                tv_hasil_alamat.text = toastMsg
            }
        }
    }


    private fun isLocationEnabled(): Boolean {
        var locationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkGPSEnabled(): Boolean {
        if (!isLocationEnabled())
            showAlert()
        return isLocationEnabled()
    }

    private fun showAlert() {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("Enable Location")
            .setMessage("Locations Settings is set to 'Off'.\nEnable Location to use this app")
            .setPositiveButton("Location Settings") { paramDialogInterface, paramInt ->
                val myIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(myIntent)
            }
            .setNegativeButton("Cancel") { paramDialogInterface, paramInt -> }
        dialog.show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FormTokoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FormTokoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}