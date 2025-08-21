package com.example.cafe__coffee.Domain

import android.accessibilityservice.GestureDescription
import android.icu.text.CaseMap
import android.media.Rating
import android.net.Uri
import com.bumptech.glide.load.model.GlideUrl
import java.io.Serializable
import javax.security.auth.Destroyable

data class itemsModel(
    var title: String="",
    var description:String="",
    var picUrl: ArrayList<String> = ArrayList(),
    var price: Double=0.0,
    var rating: Double=0.0,
    var numberInCart: Int=0,
    var extra:String=""
) : Serializable
