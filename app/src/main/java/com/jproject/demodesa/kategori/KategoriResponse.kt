package com.jproject.demodesa.kategori

import com.google.gson.annotations.SerializedName

data class KategoriResponse(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("kategori_produk")
	val kategoriProduk: List<KategoriProdukItem?>? = null,
	@field:SerializedName("status")
	val status: Int? = null
)

data class KategoriProdukItem(

	@field:SerializedName("img")
	val img: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
