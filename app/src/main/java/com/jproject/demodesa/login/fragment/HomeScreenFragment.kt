package com.jproject.demodesa.login.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import com.jproject.demodesa.R
import com.jproject.demodesa.surat.AwalSuratFragment
import kotlinx.android.synthetic.main.fragment_home_screen.*
import org.jetbrains.anko.sdk27.coroutines.onClick

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeScreenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_home_screen, container, false)
        val btnsudah = root.findViewById(R.id.btnsudah) as Button;
        btnsudah.onClick {
            val loginSudahFragment = LoginSudahFragment()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.nav_host_fragment_container, loginSudahFragment)
                ?.addToBackStack(null)
                ?.commit()
        }
        val btnbelum = root.findViewById(R.id.btnbelum) as Button;
        btnbelum.onClick {
            val loginTidakFragment = LoginTidakFragment()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.nav_host_fragment_container, loginTidakFragment)
                ?.addToBackStack(null)
                ?.commit()
        }

        return root}

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeScreenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeScreenFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}