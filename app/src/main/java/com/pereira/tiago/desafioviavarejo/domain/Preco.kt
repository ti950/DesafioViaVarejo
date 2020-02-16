import com.google.gson.annotations.SerializedName

data class Preco (
	@SerializedName("planoPagamento") val planoPagamento : String,
	@SerializedName("valorParcela") val valorParcela : Double,
	@SerializedName("quantidadeMaximaParcelas") val quantidadeMaximaParcelas : Int,
	@SerializedName("precoAtual") val precoAtual : Int,
	@SerializedName("precoAnterior") val precoAnterior : Double,
	@SerializedName("porcentagemDesconto") val porcentagemDesconto : Int,
	@SerializedName("descontoFormaPagamento") val descontoFormaPagamento : DescontoFormaPagamento,
	var precoAtualText: String,
	var precoAnteriorText: String
)