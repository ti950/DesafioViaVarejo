import com.google.gson.annotations.SerializedName

data class Modelo (

	@SerializedName("skus") val skus : List<String>,
	@SerializedName("padrao") val padrao : Padrao
)