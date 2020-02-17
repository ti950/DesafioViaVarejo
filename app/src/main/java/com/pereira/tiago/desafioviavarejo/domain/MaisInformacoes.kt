import com.google.gson.annotations.SerializedName

data class MaisInformacoes (

	@SerializedName("descricao") val descricao : String,
	@SerializedName("valores") val valores : List<Valores>
)