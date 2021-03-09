package com.jproject.demodesa.kategori

import com.jproject.demodesa.epasar.ProdukItem

interface KategoriView {
    fun onGetKategori(data: List<KategoriProdukItem?>?)
    fun onFailedKat(msg:String)
}