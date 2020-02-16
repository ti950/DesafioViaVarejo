import com.google.gson.annotations.SerializedName

data class Marketplace (

	@SerializedName("maiorPreco") val maiorPreco : Int,
	@SerializedName("menorPreco") val menorPreco : Int,
	@SerializedName("lojistaPadrao") val lojistaPadrao : LojistaPadrao,
	@SerializedName("lojistasEmDestaque") val lojistasEmDestaque : List<LojistasEmDestaque>
)