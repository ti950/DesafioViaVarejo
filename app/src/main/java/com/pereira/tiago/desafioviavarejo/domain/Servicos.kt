import com.google.gson.annotations.SerializedName

data class Servicos (

	@SerializedName("nome") val nome : String,
	@SerializedName("sku") val sku : Int,
	@SerializedName("idLojista") val idLojista : Int,
	@SerializedName("preco") val preco : Int,
	@SerializedName("parcelamento") val parcelamento : String,
	@SerializedName("tipo") val tipo : String
)