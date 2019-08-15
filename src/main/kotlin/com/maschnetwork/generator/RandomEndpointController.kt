package com.maschnetwork.generator

import com.maschnetwork.generator.generated.apis.RandomEndpointApi
import com.maschnetwork.generator.generated.models.MyRandomObjectDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class RandomEndpointController : RandomEndpointApi {

  override fun get(): ResponseEntity<MyRandomObjectDTO> {
    return ResponseEntity.ok(
      MyRandomObjectDTO(
        id = "id",
        name = "something",
        random = MyRandomObjectDTO.Random.SOMETHING
      )
    )
  }

}