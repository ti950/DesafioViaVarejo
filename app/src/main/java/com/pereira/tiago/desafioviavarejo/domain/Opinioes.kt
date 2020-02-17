import com.google.gson.annotations.SerializedName

data class Opinioes (

	@SerializedName("cliente") val cliente : String,
	@SerializedName("data") val data : String,
	@SerializedName("comentario") val comentario : String,
	@SerializedName("nota") val nota : Int,
	@SerializedName("titulo") val titulo : String,
	@SerializedName("avaliacaoGeral") val avaliacaoGeral : String,
	@SerializedName("avaliadorEstado") val avaliadorEstado : String,
	@SerializedName("like") val like : Int,
	@SerializedName("dislike") val dislike : Int,
	@SerializedName("galeriaMidia") val galeriaMidia : List<GaleriaMidia>,
	@SerializedName("idReview") val idReview : Int,
	@SerializedName("notaDescricao") val notaDescricao : String,
	@SerializedName("avaliadorCidade") val avaliadorCidade : String
)