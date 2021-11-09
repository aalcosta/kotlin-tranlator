package codenomads.kotlintranslator.api

import codenomads.kotlintranslator.client.quenya.QuenyaClient
import codenomads.kotlintranslator.client.quenya.dto.QuenyaResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class Test(
    private val quenyaClient: QuenyaClient
) {

    @GetMapping
    fun test(@RequestParam(name = "text") text: String): ResponseEntity<QuenyaResponse> {
        val quenyaResponse = quenyaClient.translateEnglishToQuenya(text).block()

        return ResponseEntity.ok(quenyaResponse)
    }
}