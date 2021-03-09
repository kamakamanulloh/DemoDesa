package com.jproject.demodesa.epasar

import com.google.gson.annotations.SerializedName

import java.io.Serializable
data class ProdukResponse(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("produk")
	val produk: List<ProdukItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

class ProdukItem:Serializable {

	@field:SerializedName("img")
	val img: String? = null

	@field:SerializedName("rt")
	val rt: String? = null

	@field:SerializedName("dusun")
	val dusun: String? = null

	@field:SerializedName("rw")
	val rw: String? = null

	@field:SerializedName("telepon")
	val telepon: Any? = null

	@field:SerializedName("penjual_id")
	val penjualId: String? = null

	@field:SerializedName("penduduk_id")
	val pendudukId: String? = null

	@field:SerializedName("nama_produk")
	val namaProduk: String? = null

	@field:SerializedName("harga")
	val harga: String? = null

	@field:SerializedName("nama")
	val nama: String? = null

	@field:SerializedName("jenis")
	val jenis: String? = null

	@field:SerializedName("id")
	val id: String? = null

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null

	@field:SerializedName("nomor_hp")
	val nomorHp: String? = null

	@field:SerializedName("status")
	val status: String? = null

	@field:SerializedName("foto")
	val foto: String? = null
}
