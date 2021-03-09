package com.jproject.demodesa.kategori

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jproject.demodesa.R
import kotlinx.android.synthetic.main.item_kategori.view.*

import org.jetbrains.anko.sdk27.coroutines.onClick
import java.text.NumberFormat
import java.util.*

class KategoriAdapter (val data:List<KategoriProdukItem>): RecyclerView.Adapter<KategoriAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun onBind(kategoriProdukItem: KategoriProdukItem) {
            Glide.with(itemView.context)
                    .load(R.drawable.ic_baseline_fastfood_24)
                    .into(itemView.img_kat)
            itemView.tv_kat.text=kategoriProdukItem.nama




            itemView.onClick {
//                val intent = Intent(
//                        itemView.context,
//                        BumdesDetailActivity::class.java
//                )
//                intent.putExtra("id", produkItem.id)
//                intent.putExtra("namaProduk", produkItem.namaProduk)
//                intent.putExtra("harga", produkItem.harga)
//                intent.putExtra("deskripsi", produkItem.deskripsi)
//                intent.putExtra("nama", produkItem.nama)
//                intent.putExtra("img", produkItem.img)
//                intent.putExtra("nomorHp", produkItem.nomorHp)
//                itemView.context.startActivity(intent)
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kategori, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: KategoriAdapter.ViewHolder, position: Int) {
        holder.onBind(data[position])

    }
}