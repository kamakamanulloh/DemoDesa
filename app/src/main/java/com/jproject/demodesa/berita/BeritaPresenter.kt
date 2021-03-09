package com.jproject.demodesa.berita

import com.jproject.demodesa.API.NetWorkConfig

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeritaPresenter (val beritaView: BeritaView) {
    fun getBerita(){
        NetWorkConfig.getServicee()
            .getBerita()
            .enqueue(object :Callback<BeritaResponse>{
                override fun onFailure(call: Call<BeritaResponse>, t: Throwable) {
                    beritaView.onFailed(t.localizedMessage)

                }

                override fun onResponse(
                    call: Call<BeritaResponse>,
                    response: Response<BeritaResponse>
                ) {
                   if (response.isSuccessful){
                       val status= response.body()?.status
                       if (status==200){
                           beritaView.onGetBerita(response.body()!!.berita)
                       }
                   }
                }

            })
    }

    fun getBeritaLengkap(){
        NetWorkConfig.getServicee()
            .getBeritaLengkap()
            .enqueue(object :Callback<BeritaResponse>{
                override fun onFailure(call: Call<BeritaResponse>, t: Throwable) {
                    beritaView.onFailed(t.localizedMessage)

                }

                override fun onResponse(
                    call: Call<BeritaResponse>,
                    response: Response<BeritaResponse>
                ) {
                    if (response.isSuccessful){
                        val status= response.body()?.status
                        if (status==200){
                            beritaView.onGetBerita(response.body()!!.berita)
                        }
                    }
                }

            })
    }
}