package com.maschnetwork.generator

import com.maschnetwork.generator.generated.apis.ArticleApi
import com.maschnetwork.generator.generated.models.ArticleDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController : ArticleApi {

  private val articles = listOf(
    ArticleDTO(id = "1", name= "T-Shirt", supplier = "Nike", type = ArticleDTO.Type.CLOTHES),
    ArticleDTO(id = "2", name= "Hat", supplier = "Nike", type = ArticleDTO.Type.CLOTHES),
    ArticleDTO(id = "3", name= "Smart-TV", supplier = "Samsung", type = ArticleDTO.Type.MEDIA)

  )

  override fun get(): ResponseEntity<List<ArticleDTO>> {
    return ResponseEntity.ok(articles)
  }

}