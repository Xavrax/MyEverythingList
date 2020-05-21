package com.xavrax.myeverythinglist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.xavrax.myeverythinglist.R
import com.xavrax.myeverythinglist.data.MovieAdapter
import com.xavrax.myeverythinglist.data.model.MovieViewEntity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    var adapter: MovieAdapter? = null
    var MoviesList = ArrayList<MovieViewEntity>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadHomeMovieGrid()
    }

    private fun loadHomeMovieGrid() {
        MoviesList.add(MovieViewEntity("Coffee", R.drawable.coffee_pot))
        MoviesList.add(MovieViewEntity("Espersso", R.drawable.espresso))
        MoviesList.add(MovieViewEntity("French Fires", R.drawable.french_fries))
        MoviesList.add(MovieViewEntity("Honey",R.drawable.honey))
        MoviesList.add(MovieViewEntity("Strawberry", R.drawable.strawberry_ice_cream))
        MoviesList.add(MovieViewEntity("Sugar cubes", R.drawable.sugar_cubes))
        MoviesList.add(MovieViewEntity("Coffee", R.drawable.coffee_pot))
        MoviesList.add(MovieViewEntity("Espersso", R.drawable.espresso))
        MoviesList.add(MovieViewEntity("French Fires", R.drawable.french_fries))
        MoviesList.add(MovieViewEntity("Honey",R.drawable.honey))
        MoviesList.add(MovieViewEntity("Strawberry", R.drawable.strawberry_ice_cream))
        MoviesList.add(MovieViewEntity("Sugar cubes", R.drawable.sugar_cubes))
        adapter = MovieAdapter(this.context!!, MoviesList)

        home_movies.adapter = adapter
    }
}
