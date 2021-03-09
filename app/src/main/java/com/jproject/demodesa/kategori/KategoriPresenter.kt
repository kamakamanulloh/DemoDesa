package com.jproject.demodesa.kategori

import com.jproject.demodesa.API.NetWorkConfig
import com.jproject.demodesa.epasar.ProdukResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KategoriPresenter(val kategoriView: KategoriView) {
    fun getKat(){
        NetWorkConfig.getServicee()
                .getKat()
                .enqueue(object : Callback<KategoriResponse> {
                    override fun onFailure(call: Call<KategoriResponse>, t: Throwable) {
                        kategoriView.onFailedKat(t.localizedMessage)
                    }

                    override fun onResponse(
                            call: Call<KategoriResponse>,
                            response: Response<KategoriResponse>
                    ) {
                        if (response.isSuccessful){
                            val status=response.body()?.status
                            if (status==200){
                                kategoriView.onGetKategori(response.body()!!.kategoriProduk)
                            }
                            else{
                                kategoriView.onFailedKat("Cek Koneksi Internet")
                            }
                        }
                    }

                })
    }
}