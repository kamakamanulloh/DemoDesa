package com.jproject.demodesa.epasar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.jproject.demodesa.R
import com.jproject.demodesa.kategori.KategoriAdapter
import com.jproject.demodesa.kategori.KategoriPresenter
import com.jproject.demodesa.kategori.KategoriProdukItem
import com.jproject.demodesa.kategori.KategoriView
import kotlinx.android.synthetic.main.fragment_e_pasar.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.startActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EPasarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("UNCHECKED_CAST")
class EPasarFragment : Fragment(),ProdukView,KategoriView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var fab_open: Animation?=null
    private var fab_close: Animation?=null
    private var fab_clock: Animation?=null
    private var fab_anticlock: Animation?=null
    var isOpen:Boolean?=false
    lateinit var produkPresenter: ProdukPresenter
    lateinit var kategoriPresenter: KategoriPresenter
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
        return inflater.inflate(R.layout.fragment_e_pasar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        produkPresenter= ProdukPresenter(this)
        kategoriPresenter= KategoriPresenter(this)
        fab_close= AnimationUtils.loadAnimation(requireContext(),R.anim.fab_close)
        fab_anticlock= AnimationUtils.loadAnimation(requireContext(),R.anim.fab_rotate_anticlock)
        fab_clock= AnimationUtils.loadAnimation(requireContext(),R.anim.fab_rotate_clock)
        fab_open= AnimationUtils.loadAnimation(requireContext(),R.anim.fab_open)
        fab_main.onClick {
            if (isOpen!!){
                btnupload.startAnimation(fab_close)
                btnproduk.startAnimation(fab_close)
                btnupload.isClickable=false
                btnproduk.isClickable=false
                isOpen = false
            }
            else{
                btnupload.startAnimation(fab_open)
                btnproduk.startAnimation(fab_open)
                btnupload.isClickable=true
                btnproduk.isClickable=true
                isOpen = true
            }

        }
        produkPresenter.getAll()
        kategoriPresenter.getKat()



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EPasarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EPasarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onGetBumdes(data: List<ProdukItem?>?) {
        progress_bar.visibility=View.GONE
        rv_produk.adapter=ProdukAdapter(data as List<ProdukItem>,object :ProdukAdapter.onClickItem{
            override fun clicked(item: ProdukItem?) {
                startActivity<ProdukDetailActivity>("dataItem" to item)
            }

        })
    }

    override fun onFailedBumdes(msg: String) {
        alert {
            message=msg
        }.show()
    }

    override fun onGetKategori(data: List<KategoriProdukItem?>?) {
        rv_kat.adapter=KategoriAdapter(data as List<KategoriProdukItem>)
    }

    override fun onFailedKat(msg: String) {

    }
}