package com.example.myapplication1.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication1.R

class MyAdapter : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return 4
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_row, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
    }
}

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v)
