import com.google.gson.annotations.SerializedName

data class LojistasEmDestaque (

	@SerializedName("id") val id : Int,
	@SerializedName("nome") val nome : String,
	@SerializedName("preco") val preco : Int,
	@SerializedName("retiraRapido") val retiraRapido : Boolean,
	@SerializedName("compraOnline") val compraOnline : Boolean,
	@SerializedName("eleito") val eleito : Boolean
)