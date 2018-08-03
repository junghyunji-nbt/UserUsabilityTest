package com.cashslide.userusability.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cashslide.userusability.R
import kotlinx.android.synthetic.main.vertical_item.view.*

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
            /*HUMIDITY_CONTENT_VIEw -> {

            }*/
            VERTICAL_VIEW -> {
                val view = inflater.inflate(R.layout.vertical_item, parent, false)
                return CommonViewHolder(view)
            }
           /* TIME_DEAL_VIEW -> {

            }
            HORIZONTAL_VIEW -> {

            }*/
            else -> {
                val view = inflater.inflate(R.layout.vertical_item, parent, false)
                return CommonViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position){
            0 -> HUMIDITY_IMAGE_VUEW
            1 -> VERTICAL_VIEW
            7 -> VERTICAL_VIEW
            14-> VERTICAL_VIEW
            else -> VERTICAL_VIEW
        }
    }

    override fun getItemCount(): Int  = 30

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CommonViewHolder -> holder?.run {
                imageList[position % 13].let {
                    bindView(it)
                }

            }

            is HumidityImageViewHolder -> holder?.run {
                bindView()
            }
        }
    }

    inner class CommonViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(imageId: Int) {
            with(view){
                Glide.with(context)
                        .load(imageId)
                        .asBitmap()
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
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(image_item)
            }
        }

    }
    inner class HumidityContentViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(){

        }

    }
    inner class TimeDealViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(){

        }

    }
    inner class HorizontalViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(){

        }

    }


}