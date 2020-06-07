package com.maschnetwork.generator.generated.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * 
 * @param id Unique identifier
 * @param name The name of the article
 * @param supplier 
 * @param type 
 */
data class ArticleDTO (

        @JsonProperty("id") val id: kotlin.String? = null,

        @JsonProperty("name") val name: kotlin.String? = null,

        @JsonProperty("supplier") val supplier: kotlin.String? = null,

        @JsonProperty("type") val type: ArticleDTO.Type? = null
) {

    /**
    * 
    * Values: CLOTHES,BOOKS,MEDIA
    */
    enum class Type(val value: kotlin.String) {
    
        @JsonProperty("clothes") CLOTHES("clothes"),
    
        @JsonProperty("books") BOOKS("books"),
    
        @JsonProperty("media") MEDIA("media");
    
    }

}

