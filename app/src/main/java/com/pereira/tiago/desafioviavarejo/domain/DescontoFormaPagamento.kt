import com.google.gson.annotations.SerializedName

data class DescontoFormaPagamento (

	@SerializedName("preco") val preco : Int,
	@SerializedName("possuiDesconto") val possuiDesconto : Boolean,
	@SerializedName("descricao") val descricao : String,
	@SerializedName("porcentagemDesconto") val porcentagemDesconto : Int
)