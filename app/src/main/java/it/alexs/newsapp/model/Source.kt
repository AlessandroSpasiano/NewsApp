package it.alexs.newsapp.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Parcelize
data class Source(
    @Expose
    @SerializedName("id")
    var id: String? = null,
    @Expose
    @SerializedName("name")
    var name: String? = null
) : Parcelable