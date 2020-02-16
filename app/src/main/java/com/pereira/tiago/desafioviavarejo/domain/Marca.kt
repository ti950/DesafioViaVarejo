import com.google.gson.annotations.SerializedName

data class Marca (

	@SerializedName("id") val id : Int,
	@SerializedName("nome") val nome : String
)