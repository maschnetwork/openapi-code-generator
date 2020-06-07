package com.maschnetwork.generator

import com.maschnetwork.generator.generated.models.ArticleDTO
import io.restassured.RestAssured.given
import io.restassured.specification.RequestSpecification
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ActiveProfiles("test")
@SpringBootTest(classes = [OpenApiDemo::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticleControllerIT {

    @LocalServerPort
    var port: Int = 0

    @Test
    fun `should return all articles when called without parameters`() {
        val articles = givenWithContext()
            .get("/api/articles")
            .then().extract().jsonPath().getList(".", ArticleDTO::class.java)

        assertThat(articles).hasSize(3)
        assertThat(articles).containsExactlyInAnyOrder(
            ArticleDTO(id = "1", name= "T-Shirt", supplier = "Nike", type = ArticleDTO.Type.CLOTHES),
            ArticleDTO(id = "2", name= "Hat", supplier = "Nike", type = ArticleDTO.Type.CLOTHES),
            ArticleDTO(id = "3", name= "Smart-TV", supplier = "Samsung", type = ArticleDTO.Type.MEDIA)
        )
    }

    fun givenWithContext() : RequestSpecification {
        return given().port(port).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
    }
}