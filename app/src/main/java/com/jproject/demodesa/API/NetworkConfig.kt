package com.jproject.demodesa.API


import com.jproject.demodesa.berita.BeritaResponse
import com.jproject.demodesa.epasar.ProdukResponse
import com.jproject.demodesa.kategori.KategoriResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object NetWorkConfig {
    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }


    fun getRetrofitt(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demodesav2api.j-project.id/api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getCorona():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.kawalcorona.com/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getServicee() = getRetrofitt().create(ApiService::class.java)!!
    fun getServiceCorona() = getCorona().create(ApiService::class.java)!!
}
    interface ApiService {
//        @GET("indonesia")
//        fun get_Indonesia():retrofit2.Call<List<IndonesiaResponse>>
//
//
//
//
//        @GET("index.php/cekNik/getWarga")
//        fun getWarga():
//                retrofit2.Call<WargaResponse>
//
//        @GET("index.php//DusunApi/getJumlahKkPerDusun?dusun=")
//        fun getJumlahKkPerDusun(
//            @Query("dusun")dusun:String?
//        ):
//                retrofit2.Call<DetailDusunResponse>
//
//
//        @GET("index.php//DusunApi/getJumlahJenisKelaminPerDusun?dusun=")
//        fun getJumlahJenisKelaminPerDusun(
//            @Query("dusun")dusun:String?
//        ):
//                retrofit2.Call<DetailDusunResponse>
//
//
//        @GET("index.php//DusunApi/getRtDusun?dusun=")
//        fun getRtDusun(
//            @Query("dusun")dusun:String?
//        ):
//                retrofit2.Call<DetailDusunResponse>
//
//
//
//
//        @GET("index.php//DusunApi/getJumlahWargaPerDusun?dusun=")
//        fun getJumlahWargaDusun(
//            @Query("dusun")dusun:String?
//        ):
//                retrofit2.Call<DetailDusunResponse>
//
//
//        @GET("index.php/DesaApi/getJumlahJK")
//        fun getJumlahJK():
//                retrofit2.Call<GetJumlahDetailResponse>
//
//        @GET("index.php/DesaApi/getStatusKawin")
//        fun getJumlahStatusKawin():
//                retrofit2.Call<GetJumlahDetailResponse>
//
//
//        @GET("index.php/DesaApi/getAgama")
//        fun getAgama():
//                retrofit2.Call<GetJumlahDetailResponse>
//
//        @GET("index.php/DesaApi/getPekerjaan")
//        fun getPekerjaan():
//                retrofit2.Call<GetJumlahDetailResponse>
//
//
//        @GET("index.php/DesaApi/getUsia")
//        fun getUsia():
//                retrofit2.Call<GetJumlahDetailResponse>
//
//        @GET("index.php/DesaApi/getRt")
//        fun getRt():
//                retrofit2.Call<GetJumlahDetailResponse>
//
//        @GET("index.php/DesaApi/getPendidikan")
//        fun getPendidikan():
//                retrofit2.Call<GetJumlahDetailResponse>
//
        @GET("index.php/ProdukApi/getKat")
        fun getKat():
        retrofit2.Call<KategoriResponse>
        @GET("index.php/ProdukApi/getAll")
        fun getAll():
        retrofit2.Call<ProdukResponse>
        @GET("index.php/ProdukApi/getUkm")
        fun getUkm():
                retrofit2.Call<ProdukResponse>

        @GET("index.php/ProdukApi/getHiburan")
        fun getHiburan():
                retrofit2.Call<ProdukResponse>
//
        @GET("index.php/ProdukApi/getJasa")
        fun getJasa():
                retrofit2.Call<ProdukResponse>

        //        @FormUrlEncoded
        @POST("index.php/ProdukApi/getProdukKat")
        fun getProdukKat(
            @Field("kategori")kategori:String?
        ):
                retrofit2.Call<ProdukResponse>
//
//
//        @GET("index.php/DesaApi/getDesa")
//        fun getDesa():
//                retrofit2.Call<DesaResponse>
//
//
//        @GET("index.php/DesaApi/getJumlahPend")
//        fun getJumlahPend():
//                retrofit2.Call<JumlahResponse>
//
//        @GET("index.php/DesaApi/getJumlahKK")
//        fun getJumlahKK():
//                retrofit2.Call<JumlahResponse>
//
//        @GET("index.php/PerangkatApi/getPerangkat")
//        fun getPerangkat():
//                retrofit2.Call<PerangkatResponse>
//
//        @GET("index.php/DesaApi/getDusun")
//        fun getDusun():
//                retrofit2.Call<DusunResponse>
//
//        @GET("index.php/PerangkatApi/getbpd")
//        fun getbpd():
//                retrofit2.Call<PerangkatResponse>
//
//
//        @GET("index.php/SuratApi/getSurat")
//        fun getSurat():
//                retrofit2.Call<SuratResponse>
//
//
//        @GET("index.php/LembagaApi/getLembaga")
//        fun getLembaga():
//                retrofit2.Call<LembagaResponse>
//
//        @GET("index.php/PerangkatApi/getStruktur")
//        fun getStruktur():
//                retrofit2.Call<StrukturResponse>
//
//
//        @GET("index.php/LembagaApi/getHospital")
//        fun getHospital():
//                retrofit2.Call<HospitalResponse>

        @GET("index.php/BeritaApi/getBeritaTerbaru")
        fun getBerita():
             Call<BeritaResponse>

        @GET("index.php/BeritaApi/getBerita")
        fun getBeritaLengkap():
             Call<BeritaResponse>

//        @FormUrlEncoded
//        @POST("index.php/CekNik/getnik")
//        fun getNik(
//            @Field("nik")nik:String?,
//            @Field("tl")tl:String?
//        ):
//                retrofit2.Call<CekNikResponse>
//
//        @FormUrlEncoded
//        @POST("index.php/KeuanganApi/getPengeluaran")
//        fun getPengeluaran(
//            @Field("periode")periode:String?
//        ):
//                retrofit2.Call<PengeluaranResponse>
//
//
//        @FormUrlEncoded
//        @POST("index.php/KeuanganApi/getPemasukan")
//        fun getPemasukan(
//            @Field("periode")periode:String?
//        ):
//                retrofit2.Call<PemasukanResponse>
//
//
//        @FormUrlEncoded
//        @POST("index.php/KeuanganApi/getPembiayaan")
//        fun getPembiayaan(
//            @Field("periode")periode:String?
//        ):
//                retrofit2.Call<PembiayaanResponse>
//
//
//        @FormUrlEncoded
//        @POST("index.php/CekNik/getCari")
//        fun getCari(
//            @Field("nik")nik:String?,
//            @Field("tl")tl:String?
//        ):
//                retrofit2.Call<CariResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_suket_ck(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nama_surat") nama_surat: String?
//        ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_suket_ktp_proses(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//
//            @Field("nama_surat") nama_surat: String?
//        ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_tidak_mampu(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("tanggal_lahir") tanggal_lahir: String?,
//            @Field("nama_anak") nama_anak: String?,
//            @Field("sekolah") sekolah: String?,
//            @Field("tempat_lahir") tempat_lahir: String?,
//            @Field("nisn") nisn: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nama_surat") nama_surat: String?,
//            @Field("jk") jk: String?
//        ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_kehilangan(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("suket_kehilagan_tanggal") suket_kehilagan_tanggal: String?,
//            @Field("suket_kehilangan_barang") suket_kehilangan_barang: String?,
//            @Field("suket_kehilangan_tempat") suket_kehilangan_tempat: String?,
//            @Field("nama_surat") nama_surat: String?
//        ): Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_kelahiran(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("tanggal_lahir") tanggal_lahir: String?,
//            @Field("nama_anak") nama_anak: String?,
//            @Field("anak_ke") anak_ke: String?,
//            @Field("tempat_lahir") tempat_lahir: String?,
//            @Field("nama_surat") nama_surat: String?
//        ): Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_ket_kematian(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("tanggal_meninggal") tanggal_meninggal: String?,
//            @Field("tempat_meninggal") tempat_meninggal: String?,
//            @Field("id_penduduk_meninggal") id_penduduk_meninggal: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_ket_wali(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("calonpr_id") calonpr_id: String?,
//            @Field("hubungan_wali") hubungan_wali: String?,
//            @Field("nm_calon") nm_calon: String?,
//            @Field("bin") bin: String?,
//            @Field("mas_kawin") mas_kawin: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_ket_pemilikan_kendaraan(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nama_kendaraan") nama_kendaraan: String?,
//            @Field("no_polisi") no_polisi: String?,
//            @Field("merk") merk: String?,
//            @Field("jenis") jenis: String?,
//            @Field("tahun_perakitan") tahun_perakitan: String?,
//            @Field("isi_silinder") isi_silinder: String?,
//            @Field("warna") warna: String?,
//            @Field("no_bpkb") no_bpkb: String?,
//            @Field("no_rangka") no_rangka: String?,
//            @Field("no_mesin") no_mesin: String?,
//            @Field("atas_nama") atas_nama: String?,
//            @Field("alamat") alamat: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_suket_belum_nikah(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_suket_miskin(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_ket_pemilikan_tanah(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("nomor") nomor: String?,
//            @Field("no_persil") no_persil: String?,
//            @Field("kelas") kelas: String?,
//            @Field("seluas") seluas: String?,
//            @Field("atas_nama") atasnama: String?,
//            @Field("utara") utara: String?,
//            @Field("selatan") selatan: String?,
//            @Field("timur") timur: String?,
//            @Field("barat") barat: String?,
//            @Field("alamat") alamat: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_ket_pemakaian_listrik(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("daya") daya: String?,
//            @Field("nama") nama: String?,
//            @Field("tempat_lahir") tempat_lahir: String?,
//            @Field("tanggal_lahir") tanggal_lahir: String?,
//            @Field("jenis_kelamin") jenis_kelamin: String?,
//            @Field("asal_sekolah") asal_sekolah: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_ket_tidak_pbb(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nama") nama: String?,
//            @Field("tempat_lahir") tempat_lahir: String?,
//            @Field("tanggal_lahir") tanggal_lahir: String?,
//            @Field("jenis_kelamin") jenis_kelamin: String?,
//            @Field("asal_sekolah") asal_sekolah: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_ket_pdam(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nama") nama: String?,
//            @Field("tempat_lahir") tempat_lahir: String?,
//            @Field("tanggal_lahir") tanggal_lahir: String?,
//            @Field("jenis_kelamin") jenis_kelamin: String?,
//            @Field("asal_sekolah") asal_sekolah: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_penghasilan(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("upah") upah: String?,
//            @Field("nama") nama: String?,
//            @Field("tempat_lahir") tempat_lahir: String?,
//            @Field("tanggal_lahir") tanggal_lahir: String?,
//            @Field("jenis_kelamin") jenis_kelamin: String?,
//            @Field("asal_sekolah") asal_sekolah: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_penghasilan_sendiri(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("upah") upah: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_beda_biodata(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("identitas_benar") identitas_benar: String?,
//            @Field("identitas_salah") identitas_salah: String?,
//            @Field("nama") nama: String?,
//            @Field("tanggal_lahir") tanggal_lahir: String?,
//            @Field("tempat_lahir") tempat_lahir: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_izin_cuti(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("tanggal_cuti") tanggal_cuti: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_kuasa_bpkb(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("lokasi_bpkb_asli") lokasi_bpkb_asli: String?,
//            @Field("nomor_kontrak") nomor_kontrak: String?,
//            @Field("nama_penerima") nama: String?,
//            @Field("nik_penerima") nik: String?,
//            @Field("tempat_lahir") tempat_lahir: String?,
//            @Field("tanggal_lahir") tanggal_lahir: String?,
//            @Field("pekerjaan") pekerjaan: String?,
//            @Field("alamat") alamat: String?,
//            @Field("merk_kendaraan") merk_kendaraan: String?,
//            @Field("type_kendaraan") type_kendaraan: String?,
//            @Field("tahun_kendaraan") tahun_kendaraan: String?,
//            @Field("warna_kendaraan") warna_kendaraan: String?,
//            @Field("no_rangka") no_rangka: String?,
//            @Field("no_mesin") no_mesin: String?,
//            @Field("no_bpkb") no_bpkb: String?,
//            @Field("no_polisi") no_polisi: String?,
//            @Field("atas_nama") atas_nama: String?,
//            @Field("alamat_kendaraan") alamat_kendaraan: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_kuasa(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("atas_nama") atas_nama: String?,
//            @Field("nama_penerima") nama: String?,
//            @Field("nik_penerima") nik: String?,
//            @Field("tempat_lahir_penerima") tempat_lahir: String?,
//            @Field("tanggal_lahir_penerima") tanggal_lahir: String?,
//            @Field("pekerjaan_penerima") pekerjaan: String?,
//            @Field("alamat_penerima") alamat: String?,
//            @Field("nama_surat") nama_surat: String?,
//            @Field("agama") agama: String?,
//            @Field("jk") jk: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_domisili_lembaga(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nm_lembaga") nm_lembaga: String?,
//            @Field("alamat_lembaga") alamat_lembaga: String?,
//            @Field("nama_pimpinan") nama_pimpinan: String?,
//            @Field("alamat_pimpinan") alamat_pimpinan: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_tanggungan_keluarga(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_kk_proses(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_persetujuan_tetangga(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("nama_tetangga") nama_tetangga: String?,
//            @Field("umur_tetangga") umur_tetangga: String?,
//            @Field("pekerjaan_tetangga") pekerjaan_tetangga: String?,
//            @Field("tempat_tetangga") tempat_tetangga: String?,
//            @Field("acara") acara: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_penutupan_jalan(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("acara") acara: String?,
//            @Field("jam") jam: String?,
//            @Field("tanggal") tanggal: String?,
//            @Field("lokasi") lokasi: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_bepergian(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("nama_surat") nama_surat: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("tujuan") tujuan: String?
//         ): retrofit2.Call<SuratResponse>
//
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_usaha(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("tempat") nama: String?,
//            @Field("keperluan") keperluan: String?,
//            @Field("jenis") jenis: String?,
//            @Field("nama_surat") nama_surat: String?
//         ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_suket_kkbaru(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("alasan") alasan: String?,
//            @Field("pemohon") pemohon: String?,
//            @Field("jumlah") jumlah: String?,
//            @Field("nik") nik: String?,
//            @Field("nama") nama: String?,
//            @Field("nama_surat") nama_surat: String?
//        ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_suket_perubahanktp(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("perubahan") perubahan: String?,
//            @Field("lainnya") lain: String?,
//            @Field("pemohon") pemohon: String?,
//            @Field("semula") semula: String?,
//            @Field("menjadi") menjadi: String?,
//            @Field("dasar_perubahan") dasar_perubahan: String?,
//            @Field("nomor") nomor: String?,
//            @Field("tanggal") tanggal: String?,
//            @Field("gelar") gelar: String?,
//            @Field("tipe_gelar") tipe_gelar: String?,
//            @Field("nama_surat") nama_surat: String?
//        ): retrofit2.Call<SuratResponse>
//
//        @FormUrlEncoded
//        @POST("insert_surat.php")
//        fun insert_surat_permohonanktp(
//            @Field("log_surat_tabel") log_surat_tabel: String?,
//            @Field("penduduk_id") penduduk_id: String?,
//            @Field("id_surat") id_surat: String?,
//            @Field("log_surat_nohp") nohp: String?,
//            @Field("permohonan") permohonan: String?,
//            @Field("nama_surat") nama_surat: String?
//        ): retrofit2.Call<SuratResponse>


    }
