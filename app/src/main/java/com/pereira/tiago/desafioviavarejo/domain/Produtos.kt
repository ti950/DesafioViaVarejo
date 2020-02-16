import com.google.gson.annotations.SerializedName

data class Produtos (

	@SerializedName("id") val id : Int,
	@SerializedName("sku") val sku : Int,
	@SerializedName("nome") val nome : String,
	@SerializedName("disponivel") val disponivel : Boolean,
	@SerializedName("descricao") val descricao : String,
	@SerializedName("imagemUrl") val imagemUrl : String,
	@SerializedName("classificacao") val classificacao : Int,
	@SerializedName("preco") val preco : Preco
)