import com.google.gson.annotations.SerializedName

data class Padrao (

	@SerializedName("sku") val sku : Int,
	@SerializedName("nome") val nome : String,
	@SerializedName("disponivel") val disponivel : Boolean,
	@SerializedName("marketplace") val marketplace : Marketplace,
	@SerializedName("preco") val preco : Preco,
	@SerializedName("imagens") val imagens : List<Imagens>,
	@SerializedName("servicos") val servicos : List<Servicos>
)