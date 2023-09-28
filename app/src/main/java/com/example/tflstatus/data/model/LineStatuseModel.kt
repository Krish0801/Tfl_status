package com.example.tflstatus.data.model


import com.google.gson.annotations.SerializedName

data class LineStatuseModel(
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("disruption")
    val disruption: DisruptionModel? = DisruptionModel(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("lineId")
    val lineId: String? = "",
    @SerializedName("reason")
    val reason: String? = "",
    @SerializedName("statusSeverity")
    val statusSeverity: Int? = 0,
    @SerializedName("statusSeverityDescription")
    val statusSeverityDescription: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("validityPeriods")
    val validityPeriods: List<ValidityPeriodModel?>? = listOf()
)