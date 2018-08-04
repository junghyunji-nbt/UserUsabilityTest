package com.cashslide.userusability.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cashslide.userusability.R
import kotlinx.android.synthetic.main.horizontal_list.view.*
import kotlinx.android.synthetic.main.horizontal_list_dummy_item.view.*
import kotlinx.android.synthetic.main.horizontal_list_item.view.*

class HorizontalAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        var DUMMY_VIEW = 0
        var REAL_VIEW =  1
    }

    val imageList = intArrayOf(R.drawable.card01, R.drawable.card02, R.drawable.card03, R.drawable.card04)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return when(viewType) {
            DUMMY_VIEW -> {
                val view = layoutInflater.inflate(R.layout.horizontal_list_dummy_item, parent, false)
                HorizontalDummyViewHolder(view)
            }
            REAL_VIEW -> {
                val view = layoutInflater.inflate(R.layout.horizontal_list_item, parent, false)
                HorizontalCardViewHolder(view)
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.horizontal_list_item, parent, false)
                HorizontalCardViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int = imageList.size +1

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> DUMMY_VIEW
            else -> REAL_VIEW
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is HorizontalDummyViewHolder -> holder.run { bindview() }
            is HorizontalCardViewHolder -> holder?.run {
                imageList[position -1].let {
                    bindView(it)
                }
            }
        }
    }

    inner class HorizontalDummyViewHolder(var view: View): RecyclerView.ViewHolder(view){
        fun bindview(){
            with(view){
                Glide.with(context)
                        .load("")
                        .into(horizontal_dummy_item)

                horizontal_dummy_item.setOnClickListener {adapterPosition + 1}
            }

        }
    }

    inner class HorizontalCardViewHolder(var view: View): RecyclerView.ViewHolder(view){
        fun bindView(imageId : Int){
            with(view){
                Glide.with(context)
                        .load(imageId)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(horizontal_image_item)
            }
        }
    }
}