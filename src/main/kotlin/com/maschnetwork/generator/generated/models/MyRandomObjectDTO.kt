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
 * @param name The name of the object
 * @param random 
 */
data class MyRandomObjectDTO (

        @JsonProperty("id") val id: kotlin.String? = null,

        @JsonProperty("name") val name: kotlin.String? = null,

        @JsonProperty("random") val random: MyRandomObjectDTO.Random? = null
) {

    /**
    * 
    * Values: SOMETHING,SOMETHING_DIFFERENT,SOMETHING_ELSE
    */
    enum class Random(val value: kotlin.String) {
    
        @JsonProperty("something") SOMETHING("something"),
    
        @JsonProperty("something_different") SOMETHING_DIFFERENT("something_different"),
    
        @JsonProperty("something_else") SOMETHING_ELSE("something_else");
    
    }

}

