package com.xavrax.myeverythinglist.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.xavrax.myeverythinglist.R
import com.xavrax.myeverythinglist.data.model.MovieEntity
import kotlinx.android.synthetic.main.movie_entry.view.*

class MovieAdapter(context: Context, foodsList: ArrayList<MovieEntity>) : BaseAdapter() {
    var foodsList = foodsList
    var context: Context? = context

    override fun getCount(): Int {
        return foodsList.size
    }

    override fun getItem(position: Int): Any {
        return foodsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = this.foodsList[position]

        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val foodView = inflator.inflate(R.layout.movie_entry, null)
        foodView.imgMovie.setImageResource(food.image!!)
        foodView.movieTitle.text = food.name!!

        return foodView
    }
}
