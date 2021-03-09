package com.jproject.demodesa.epasar

interface ProdukView {
    fun onGetBumdes(data: List<ProdukItem?>?)
    fun onFailedBumdes(msg:String)
}