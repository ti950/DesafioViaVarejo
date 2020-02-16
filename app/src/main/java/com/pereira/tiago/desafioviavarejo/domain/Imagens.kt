import com.google.gson.annotations.SerializedName

data class Imagens (

	@SerializedName("id") val id : Int,
	@SerializedName("nome") val nome : String,
	@SerializedName("altura") val altura : Int,
	@SerializedName("largura") val largura : Int,
	@SerializedName("url") val url : String
)