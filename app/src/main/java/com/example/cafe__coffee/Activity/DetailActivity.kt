package com.example.cafe__coffee.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.cafe__coffee.Domain.itemsModel
import com.example.cafe__coffee.Helper.ManagmentCart
import com.example.cafe__coffee.R
import com.example.cafe__coffee.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private lateinit var itemsModel: itemsModel
    private lateinit var managmentCart: ManagmentCart



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        managmentCart= ManagmentCart(this)

        bundle()
        initSizeList()

    }

    private fun initSizeList() {
        binding.apply {
            smallBtn.setOnClickListener {
                smallBtn.setBackgroundResource(R.drawable.stroke_brown_bg)
                mediumBtn.setBackgroundResource(0)
                largeBtn.setBackgroundResource(0)
            }
            mediumBtn.setOnClickListener {
                smallBtn.setBackgroundResource(0)
                mediumBtn.setBackgroundResource(R.drawable.stroke_brown_bg)
                largeBtn.setBackgroundResource(0)
            }
            largeBtn.setOnClickListener {
                smallBtn.setBackgroundResource(0)
                mediumBtn.setBackgroundResource(0)
                largeBtn.setBackgroundResource(R.drawable.stroke_brown_bg)
            }
        }
    }

    private fun bundle() {
        binding.apply {
            itemsModel=intent.getSerializableExtra("object") as itemsModel

            Glide.with(this@DetailActivity)
                .load(itemsModel.picUrl[0])
                .into(binding.picMain)

            titleTxt.text=itemsModel.title
            descriptionTxt.text=itemsModel.description
            priceTxt.text="$"+itemsModel.price
            ratingTxt.text=itemsModel.rating.toString()

            addToCartBtn.setOnClickListener {
                itemsModel.numberInCart=Integer.valueOf(
                    numberItemTxt.text.toString()
                )
                managmentCart.insertItems(itemsModel)

            }
            backBtn.setOnClickListener {
                startActivity(Intent(this@DetailActivity, MainActivity::class.java))
            }
            plusCart.setOnClickListener {
                numberItemTxt.text=(itemsModel.numberInCart+1).toString()
                itemsModel.numberInCart++
            }

            minusBtn.setOnClickListener {
                if(itemsModel.numberInCart>0){
                    numberItemTxt.text=(itemsModel.numberInCart-1).toString()
                    itemsModel.numberInCart--
                }
            }
        }
    }
}