package it.alexs.newsapp.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Parcelize
data class NewsWrapper(
    @Expose
    @SerializedName("articles")
    var articles: List<Article>? = listOf(),
    @Expose
    @SerializedName("status")
    var status: String? = null,
    @Expose
    @SerializedName("totalResults")
    var totalResults: Int? = null
) : Parcelable