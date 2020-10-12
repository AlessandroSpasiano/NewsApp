package it.alexs.newsapp.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Parcelize
data class NewsError(
    @Expose
    @SerializedName("code")
    var code: String? = null,
    @Expose
    @SerializedName("message")
    var message: String? = null,
    @Expose
    @SerializedName("status")
    var status: String? = null
) : Parcelable