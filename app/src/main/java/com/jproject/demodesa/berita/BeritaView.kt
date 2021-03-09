package com.jproject.demodesa.berita

import com.jproject.demodesa.berita.BeritaItem

interface BeritaView {
    fun onGetBerita(data: List<BeritaItem?>?)
    fun onFailed(mgs:String)
}