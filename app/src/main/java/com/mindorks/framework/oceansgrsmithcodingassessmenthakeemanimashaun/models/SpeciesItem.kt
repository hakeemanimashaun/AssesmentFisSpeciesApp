package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpeciesItem(
    @SerializedName("Habitat Impacts")
    val HabitatImpacts: String,
//    @SerializedName("Image Gallery")
//    val ImageGallery: List<Any>,
    @SerializedName("Species Illustration Photo")
    val SpeciesIllustrationPhoto: SpeciesIllustrationPhoto,
    @SerializedName("Species Name")
    val SpeciesName: String,

): Serializable