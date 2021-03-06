package br.com.nerdrapido.themoviedbapp.data.model.favoritemovies

import br.com.nerdrapido.themoviedbapp.data.model.common.MovieListResultObject
import com.google.gson.annotations.SerializedName

/**
 * Created By FELIPE GUSBERTI @ 15/03/2020
 *
 * https://developers.themoviedb.org/3/account/get-favorite-movies
 */
data class FavoriteMoviesResponse(
    @SerializedName("page")
    val page : Int?,
    @SerializedName("results")
    val results : List<MovieListResultObject>?,
    @SerializedName("total_results")
    val totalResults : Int?,
    @SerializedName("total_pages")
    val totalPages : Int?
)