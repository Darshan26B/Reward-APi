import com.google.gson.annotations.SerializedName

data class GridData(
    @SerializedName("bgColor")
    var bgColor: String = "",
    @SerializedName("fullImage")
    var fullImage: String="",
    @SerializedName("icon")
    var icon: String = "",
    @SerializedName("iconBGColor")
    var iconBGColor: String = "",
    @SerializedName("isActive")
    var isActive: String = "",
    @SerializedName("isBorder")
    var isBorder: String = "",
    @SerializedName("isTodayTaskCompleted")
    var isTodayTaskCompleted: String = "",
    @SerializedName("isViewAll")
    var isViewAll: String = "",
    @SerializedName("note")
    var note: String = "",
    @SerializedName("screenNo")
    var screenNo: String = "",
    @SerializedName("subTitle")
    var subTitle: String = "",
    @SerializedName("taskCount")
    var taskCount: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("type")
    var type: String = ""
)
