package com.jproject.demodesa.berita
import com.google.gson.annotations.SerializedName

data class BeritaResponse(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("berita")
	val berita: List<BeritaItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class BeritaItem(

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("admin_id")
	val adminId: String? = null,

	@field:SerializedName("hero")
	val hero: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("updated")
	val updated: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("isi")
	val isi: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
