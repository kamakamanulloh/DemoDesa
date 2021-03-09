package com.jproject.demodesa.epasar

import com.jproject.demodesa.API.NetWorkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdukPresenter(val produkView: ProdukView) {

    fun getAll(){
        NetWorkConfig.getServicee()
                .getAll()
                .enqueue(object : Callback<ProdukResponse> {
                    override fun onFailure(call: Call<ProdukResponse>, t: Throwable) {
                        produkView.onFailedBumdes(t.localizedMessage)
                    }

                    override fun onResponse(
                            call: Call<ProdukResponse>,
                            response: Response<ProdukResponse>
                    ) {
                        if (response.isSuccessful){
                            val status=response.body()?.status
                            if (status==200){
                                produkView.onGetBumdes(response.body()!!.produk)
                            }
                            else{
                                produkView.onFailedBumdes("Cek Koneksi Internet")
                            }
                        }
                    }

                })
    }

}