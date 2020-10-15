package it.alexs.newsappnews_library.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(
    @Expose
    @SerializedName("id")
    var id: String? = null,
    @Expose
    @SerializedName("name")
    var name: String? = null
) : Parcelable