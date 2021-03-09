package com.jproject.demodesa.berita

import android.annotation.SuppressLint
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jproject.demodesa.R


import kotlinx.android.synthetic.main.item_berita.view.*
import kotlinx.android.synthetic.main.item_berita.view.iv

import org.jetbrains.anko.sdk27.coroutines.onClick

@Suppress("DEPRECATION")
class BeritaAdapter(val data:List<BeritaItem>):
    RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BeritaAdapter.ViewHolder, position: Int) {
        holder.onBind(data[position])

    }

    interface onClickItem {
        fun clicked(item: BeritaItem?)


    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun onBind(get: BeritaItem?) {
            itemView.tvjudul.text = get?.judul
            itemView.tvdesc.text = Html.fromHtml(get?.isi)
            Glide.with(itemView.context)
                .load(get?.hero)
                .error(R.drawable.ic_baseline_image_24)
                .into(itemView.iv)
            itemView.onClick {
//                val intent = Intent(
//                    itemView.context,
//                    DetailBeritaActivity::class.java
//                )
//                intent.putExtra("slug", get?.slug)
//                itemView.context.startActivity(intent)
            }


        }

    }
}

//    @Suppress("DEPRECATION")
//    class BeritaSemuaAdapter(val data: List<BeritaItem>) :
//        RecyclerView.Adapter<BeritaSemuaAdapter.ViewHolder>() {
//        override fun onCreateViewHolder(
//            parent: ViewGroup,
//            viewType: Int
//        ): BeritaSemuaAdapter.ViewHolder {
//            val view =
//                LayoutInflater.from(parent.context).inflate(R.layout.item_berita_lengkap, parent, false)
//            return ViewHolder(view)
//        }
//
//        override fun getItemCount() = data.size
//
//        override fun onBindViewHolder(holder: BeritaSemuaAdapter.ViewHolder, position: Int) {
//            holder.onBind(data[position])
//
//        }
//
//        interface onClickItem {
//            fun clicked(item: BeritaItem?)
//
//
//        }
//
//        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            @SuppressLint("SetTextI18n")
//            fun onBind(get: BeritaItem?) {
//                itemView.onClick {
////                    val intent = Intent(
////                       itemView.context,
////                        DetailBeritaActivity::class.java
////                    )
////                    intent.putExtra("slug", get?.slug)
////                    itemView.context.startActivity(intent)
//                }
//                itemView.tv_judul.text = get?.judul
//                itemView.tv_tgl.text = get?.updated
//                Glide.with(itemView.context)
//                    .load(get?.hero)
//                    .error(R.drawable.ic_no_camera)
//                    .into(itemView.iv)
//
//
//            }
//
//        }
//    }
