package com.sumia.odev6.data

import android.widget.ImageView
import java.io.Serializable

data class Urunler (var id: Int,
                    var urun_resim: String,  //drawable resource ID,
                    var urun_ad: String,
                    var urun_fiyat: String,
                    var urun_puan: Double) : Serializable{}