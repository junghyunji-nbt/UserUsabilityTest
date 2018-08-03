package com.cashslide.userusability.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class HorizontalAdapter(val context: Context, itemView: View):  RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        val HUMIDITY_IMAGE_VUEW = 0
        val HUMIDITY_CONTENT_VIEw = 1
        val VERTICAL_VIEW = 2
        val TIME_DEAL_VIEW = 3
        val HORIZONTAL_VIEW = 4

    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}