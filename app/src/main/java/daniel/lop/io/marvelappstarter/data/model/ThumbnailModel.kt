package daniel.lop.io.marvelappstarter.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ThumbnailModel(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
) : Serializable
