package com.cashslide.userusability.adapter

import android.content.Context
import android.os.CountDownTimer
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cashslide.userusability.R
import kotlinx.android.synthetic.main.horizontal_list.view.*
import kotlinx.android.synthetic.main.humidity_content_item.view.*
import kotlinx.android.synthetic.main.vertical_item.view.*
import java.util.concurrent.TimeUnit

class CommonAdapter(val context: Context):  RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val imageList = intArrayOf(R.drawable.dummy_1, R.drawable.dummy_2, R.drawable.dummy_3,
            R.drawable.dummy_4, R.drawable.dummy_5, R.drawable.dummy_6, R.drawable.dummy_7,
            R.drawable.dummy_8, R.drawable.dummy_9, R.drawable.dummy_10, R.drawable.dummy_11,
            R.drawable.dummy_12, R.drawable.dummy_13)

    companion object {
        val HUMIDITY_IMAGE_VUEW = 0
        val HUMIDITY_CONTENT_VIEw = 1
        val VERTICAL_VIEW = 2
        val TIME_DEAL_VIEW = 3
        val HORIZONTAL_VIEW = 4

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        when(viewType){
            HUMIDITY_IMAGE_VUEW -> {
                val view = inflater.inflate(R.layout.vertical_item, parent, false)
                return HumidityImageViewHolder(view)
            }
            HUMIDITY_CONTENT_VIEw -> {
                val view = inflater.inflate(R.layout.humidity_content_item, parent, false)
                return HumidityContentViewHolder(view)
            }
            VERTICAL_VIEW -> {
                val view = inflater.inflate(R.layout.vertical_item, parent, false)
                return CommonViewHolder(view)
            }
            TIME_DEAL_VIEW -> {
                val view = inflater.inflate(R.layout.vertical_item, parent, false)
                return TimeDealViewHolder(view)
            }
            HORIZONTAL_VIEW -> {
                val view = inflater.inflate(R.layout.horizontal_list, parent, false)
                return HorizontalViewHolder(view)
            }
            else -> {
                val view = inflater.inflate(R.layout.vertical_item, parent, false)
                return CommonViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position){
            0 -> HUMIDITY_IMAGE_VUEW
            1 -> HUMIDITY_CONTENT_VIEw
            7 -> TIME_DEAL_VIEW
            14-> HORIZONTAL_VIEW
            else -> VERTICAL_VIEW
        }
    }

    override fun getItemCount(): Int  = 30

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CommonViewHolder -> holder.run {
                imageList[position % 13].let {
                    bindView(it)
                }

            }
            is HumidityImageViewHolder -> holder.run {
                bindView()
            }
            is HumidityContentViewHolder -> holder.run {
                bindView()
            }
            is TimeDealViewHolder -> holder.run { bindView() }
            is HorizontalViewHolder -> holder.run { bindView() }
        }
    }

    inner class CommonViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(imageId: Int) {
            with(view){
                Glide.with(context)
                        .load(imageId)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(image_item)
            }
        }
    }
    inner class HumidityImageViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(){
            with(view){
                Glide.with(context)
                        .load(R.drawable.humidity_image)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(image_item)
            }
        }

    }
    inner class HumidityContentViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(){
            with(view){
                Glide.with(context)
                        .load(R.drawable.humidity)
                        .asGif()
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(humidity_content_image)
            }

        }

    }
    inner class TimeDealViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        var minutes = 60
        var milliseconds = minutes * 60 * 1000
        lateinit var countDownTimer:CountDownTimer
        init {
            view.time_deal_text.apply {
                visibility = View.VISIBLE
                countDownTimer = object : CountDownTimer(milliseconds.toLong(), 1000) {

                    override fun onTick(millisUntilFinished: Long) {
                        view.time_deal_text.text = String.format("%02d:%02d:%02d",
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
                    }
                    override fun onFinish() {
                    }
                }

            }

        }
        fun bindView(){
            with(view){
                Glide.with(context)
                        .load(R.drawable.time_deal)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(image_item)
            }
            countDownTimer.start()
        }

    }
    inner class HorizontalViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(){
            view.horizontal_recyclerview.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = HorizontalAdapter(context)
            }

        }

    }


}