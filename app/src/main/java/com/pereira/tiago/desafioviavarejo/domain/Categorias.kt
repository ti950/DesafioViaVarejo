import com.google.gson.annotations.SerializedName

data class Categorias (

	@SerializedName("id") val id : Int,
	@SerializedName("descricao") val descricao : String
)