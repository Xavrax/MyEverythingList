package com.xavrax.myeverythinglist.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.xavrax.myeverythinglist.R
import com.xavrax.myeverythinglist.data.model.MovieEntity
import com.xavrax.myeverythinglist.data.model.MovieViewEntity
import kotlinx.android.synthetic.main.movie_entry.view.*

class MovieAdapter(context: Context, foodsList: ArrayList<MovieViewEntity>) : BaseAdapter() {
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

        Glide.with(foodView)
            .load("https://image.tmdb.org/t/p/w342${foodsList[position].image}")
            .transform(CenterCrop())
            .into(foodView.imgMovie)

        foodView.movieTitle.text = food.name!!

        return foodView
    }

    fun updateMovies(movies: List<MovieEntity>) {
        val list : MutableList<MovieViewEntity> = mutableListOf()
        movies.forEach{
            list.add(MovieViewEntity(it.title, it.posterPath))
        }
        this.foodsList = ArrayList(list)
        notifyDataSetChanged()
    }
}
