package it.alexs.newsapp.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Parcelize
data class Article(
    @Expose
    @SerializedName("author")
    var author: String? = null,
    @Expose
    @SerializedName("content")
    var content: String? = null,
    @Expose
    @SerializedName("description")
    var description: String? = null,
    @Expose
    @SerializedName("publishedAt")
    var publishedAt: String? = null,
    @Expose
    @SerializedName("source")
    var source: Source? = null,
    @Expose
    @SerializedName("title")
    var title: String? = null,
    @Expose
    @SerializedName("url")
    var url: String? = null,
    @Expose
    @SerializedName("urlToImage")
    var urlToImage: String? = null
) : Parcelable