package com.maschnetwork.generator

import com.maschnetwork.generator.generated.models.MyRandomObjectDTO
import io.restassured.RestAssured.given
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
class RandomEndpointControllerIT {

    @LocalServerPort
    var port: Int = 0

    @Test
    fun `should return valid object when accessing the endpoint`() {
        val expected = MyRandomObjectDTO(id = "id", name = "something", random = MyRandomObjectDTO.Random.SOMETHING)
        val actual = given()
            .port(port)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .get("/api/my-random-endpoint")
            .`as`(MyRandomObjectDTO::class.java)

        assertThat(expected).isEqualTo(actual)
    }
}