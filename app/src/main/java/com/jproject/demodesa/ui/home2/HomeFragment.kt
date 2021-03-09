package com.jproject.demodesa.ui.home2

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jproject.demodesa.R
import com.jproject.demodesa.berita.BeritaAdapter
import com.jproject.demodesa.berita.BeritaItem
import com.jproject.demodesa.berita.BeritaPresenter
import com.jproject.demodesa.berita.BeritaView
import com.jproject.demodesa.surat.AwalSuratFragment
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home2.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.alert

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() , BeritaView {
    private lateinit var beritaPresenter: BeritaPresenter


    var sampleImages = intArrayOf(
            R.drawable.alamsawah,
            R.drawable.pasardigital
    )
    private var param1: String? = null
    private var param2: String? = null

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
        val root = inflater.inflate(R.layout.fragment_home2, container, false)
        val carouselView = root.findViewById(R.id.carouselView) as CarouselView;
        carouselView.pageCount=sampleImages.size
        carouselView.setImageListener(imageListener)
        beritaPresenter= BeritaPresenter(this)
        beritaPresenter.getBerita()
        val btn_surat = root.findViewById(R.id.btnsurat) as CardView;
        btn_surat.onClick {
            val awalSuratFragment = AwalSuratFragment()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.nav_host_fragment, awalSuratFragment)
                ?.addToBackStack(null)
                ?.commit()
        }
        val btn_lainnya = root.findViewById(R.id.btn_lainnya) as CardView;
        btn_lainnya.onClick {
            val view: View =
                    layoutInflater.inflate(R.layout.fragment_bottom, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(view)
            dialog.show()
        }
        val toolbar = root.findViewById(R.id.toolbar) as Toolbar;
        toolbar.inflateMenu(R.menu.toolbar_menu)
        setHasOptionsMenu(true)

        return root
    }
    var imageListener =
        ImageListener { position, imageView ->
            imageView.setImageResource(sampleImages[position]) }

    override fun onGetBerita(data: List<BeritaItem?>?) {
        rv_berita.adapter= BeritaAdapter(data as List<BeritaItem>)
    }

    override fun onFailed(mgs: String) {
        alert {
            message="Gagal"
        }.show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.notif -> {
                Log.i("item id ", item.itemId.toString() + "")
                super.onOptionsItemSelected(item)
            }
            R.id.help->{
                Log.i("item id ", item.itemId.toString() + "")
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}