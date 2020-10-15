package it.alexs.newsappnews_library.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

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