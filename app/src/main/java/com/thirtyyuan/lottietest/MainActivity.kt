package com.thirtyyuan.lottietest

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.LottieCompositionFactory
import com.thirtyyuan.lottietest.anim.DefaultAnimatorListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindListener()
    }

    private fun bindListener() {
        button.setOnClickListener { loadAnimation() }
        match_degree_title.addAnimatorListener(object : DefaultAnimatorListener() {
            override fun onAnimationEnd(animation: Animator) {
                match_degree_decade_bit.playAnimation()
                match_degree_decade_bit.visibility = View.VISIBLE
            }
        })
        match_degree_decade_bit.addAnimatorListener(object : DefaultAnimatorListener() {
            override fun onAnimationEnd(animation: Animator) {
                match_degree_unit_bit.playAnimation()
                match_degree_unit_bit.visibility = View.VISIBLE
            }
        })
        match_degree_unit_bit.addAnimatorListener(object : DefaultAnimatorListener() {
            override fun onAnimationEnd(animation: Animator) {
                match_degree_sign.playAnimation()
                match_degree_sign.visibility = View.VISIBLE
            }
        })
    }

    override fun onStart() {
        super.onStart()
        loadAnimation()
    }

    private fun loadAnimation() {
        match_degree_title.visibility = View.INVISIBLE
        match_degree_decade_bit.visibility = View.INVISIBLE
        match_degree_unit_bit.visibility = View.INVISIBLE
        match_degree_sign.visibility = View.INVISIBLE


        LottieCompositionFactory.fromAsset(this, "home_page_normal_number_%25_white.json")
            .addListener { result: LottieComposition? ->
                result?.let {
                    match_degree_sign.setComposition(it)
                    match_degree_sign.repeatCount = 0
                }
            }
        LottieCompositionFactory.fromAsset(this, "home_page_normal_number_1_white.json")
            .addListener { result: LottieComposition? ->
                result?.let {
                    match_degree_decade_bit.setComposition(it)
                    match_degree_decade_bit.repeatCount = 0
                }
            }
        LottieCompositionFactory.fromAsset(this, "home_page_normal_number_7_white.json")
            .addListener { result: LottieComposition? ->
                result?.let {
                    match_degree_unit_bit.setComposition(it)
                    match_degree_unit_bit.repeatCount = 0
                }
            }
        LottieCompositionFactory.fromAsset(this, "home_page_normal_match_match_write.json")
            .addListener { result: LottieComposition? ->
                result?.let {
                    match_degree_title.setComposition(it)
                    match_degree_title.repeatCount = 0
                    match_degree_title.visibility = View.VISIBLE
                    match_degree_title.playAnimation()
                }
            }
    }
}
