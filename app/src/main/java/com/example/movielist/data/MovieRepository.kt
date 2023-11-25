package com.example.movielist.data

import android.util.Log
import com.example.movielist.data.dataClasses.Movie
import com.example.movielist.data.network.MyListResponse
import com.example.movielist.data.network.MyResponse
import com.example.movielist.data.network.RetrofitInstance
import com.example.movielist.data.network.movie.MovieRequest
import com.example.movielist.data.network.movie.MovieResponse

class MovieRepository {
    suspend fun getMovieList(): List<Movie> {
        val movies = mutableListOf<Movie>()

        try {
            val response: MyListResponse<MovieResponse> =
                RetrofitInstance.movieService.getAllMovies("movie")
            val moviesFromResponse = response.data

            if (moviesFromResponse != null) {

                for (movieFromResponse in moviesFromResponse) {
                    if (movieFromResponse.description != null) {
                        movies.add(
                            Movie(
                                movieFromResponse.name.uppercase(),
                                movieFromResponse.description
                            )
                        )
                    }
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return movies
    }

    suspend fun insertNewMovie(movie: Movie): MyResponse? {
        var response: MyResponse

        try {

            val movieRequest =
                MovieRequest(movie.name, movie.description)

            response = RetrofitInstance.movieService.insertNewMovie(
                "movie",
                movieRequest
            )

            Log.d("Update_response", response.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

        return response
    }
}

