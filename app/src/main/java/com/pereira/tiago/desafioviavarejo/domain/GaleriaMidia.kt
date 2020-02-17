import com.google.gson.annotations.SerializedName

data class GaleriaMidia (

	@SerializedName("tipo") val tipo : String,
	@SerializedName("link") val link : String
)