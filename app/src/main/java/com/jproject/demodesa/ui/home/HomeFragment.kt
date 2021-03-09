package com.jproject.demodesa.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jproject.demodesa.R
import com.jproject.demodesa.berita.BeritaAdapter
import com.jproject.demodesa.berita.BeritaItem
import com.jproject.demodesa.berita.BeritaPresenter
import com.jproject.demodesa.berita.BeritaView
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.alert


class HomeFragment : Fragment(),BeritaView {
    private lateinit var beritaPresenter: BeritaPresenter

    private lateinit var homeViewModel: HomeViewModel
    var sampleImages = intArrayOf(
        R.drawable.alamsawah,
        R.drawable.pasardigital
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val carouselView = root.findViewById(R.id.carouselView) as CarouselView;
        carouselView.pageCount=sampleImages.size
        carouselView.setImageListener(imageListener)
        beritaPresenter= BeritaPresenter(this)
        beritaPresenter.getBerita()

        return root
    }
    var imageListener =
        ImageListener {
                position, imageView ->
            imageView.setImageResource(sampleImages[position]) }

    override fun onGetBerita(data: List<BeritaItem?>?) {
        rv_berita.adapter= BeritaAdapter(data as List<BeritaItem>)
    }

    override fun onFailed(mgs: String) {
       alert {
           message="Gagal"
       }.show()
    }
}