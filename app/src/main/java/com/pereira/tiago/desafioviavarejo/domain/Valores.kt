import com.google.gson.annotations.SerializedName

data class Valores (

	@SerializedName("nome") val nome : String,
	@SerializedName("valor") val valor : String
)