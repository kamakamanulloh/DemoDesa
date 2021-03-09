package com.jproject.demodesa.epasar

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.jproject.demodesa.R
import kotlinx.android.synthetic.main.activity_produk_detail.*
import kotlinx.android.synthetic.main.fragment_bottom.*
import org.jetbrains.anko.sdk27.coroutines.onClick


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class ProdukDetailActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk_detail)
        val produkResults = intent.getSerializableExtra("dataItem")
        val item = produkResults as ProdukItem?
        Glide.with(applicationContext)
            .load(item?.img)
            .error(R.drawable.ic_baseline_fastfood_24)
            .into(img)
        tv_produk.text = item?.namaProduk
        tv_harga.text = item?.harga
        tv_detail.text = Html.fromHtml(item?.deskripsi)
        tv_nmpenjual.text = item?.nama
        tv_alamat.text = "RT " + item?.rt + " RW " + item?.rw + " Dusun " + item?.dusun
        btn_chat.onClick {
            try {
                val text = " " // Replace with your message.
                val toNumber =
                    item?.nomorHp// Replace with mobile phone number without +Sign or leading zeros, but with country code
                //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        btn_phone.onClick {
            val toDial = "tel:" + item?.nomorHp

            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(toDial)))
        }
    }
}
