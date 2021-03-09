package com.jproject.demodesa.epasar

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jproject.demodesa.R
import kotlinx.android.synthetic.main.item_produk.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.text.NumberFormat
import java.util.*

class ProdukAdapter(val data:List<ProdukItem>?, private val click: onClickItem): RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun onBind(get: ProdukItem?) {
            Glide.with(itemView.context)
                    .load(get?.img)
                    .into(itemView.img)
            itemView.title.text=get?.namaProduk+" (Penjual : "+get?.nama+")"



            val localeID = Locale("in", "ID")
            val formatRupiah =
                    NumberFormat.getCurrencyInstance(localeID)
            val nominal: Int = get?.harga!!.toInt()
            itemView.harga.text = formatRupiah.format(nominal.toDouble())



        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: ProdukAdapter.ViewHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.itemView.onClick {

            click.clicked(data?.get(position))
        }


    }
    interface onClickItem{
        fun clicked (item: ProdukItem?)


    }

}