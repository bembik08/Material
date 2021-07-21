package geekbrains.material.network

import geekbrains.material.model.Apod
import geekbrains.material.model.Epic
import geekbrains.material.model.MarsList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaAPI {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("date") date: String): Observable<Apod>

    @GET("EPIC/api/natural")
    fun getEpicList(): Observable<List<Epic>>

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000")
    fun getMarsList(): Observable<MarsList>
}