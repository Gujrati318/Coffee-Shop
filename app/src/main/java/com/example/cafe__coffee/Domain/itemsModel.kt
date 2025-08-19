package com.example.cafe__coffee.Domain

import android.accessibilityservice.GestureDescription
import android.icu.text.CaseMap
import android.net.Uri
import java.io.Serializable
import javax.security.auth.Destroyable

data class itemsModel(
    var title: String="",
    var description:String="",
    var picUri: ArrayList<String> = ArrayList(),
    var price: Double=0.0,
    var numberInCart: Int=0,
    var extra:String=""
) : Serializable
