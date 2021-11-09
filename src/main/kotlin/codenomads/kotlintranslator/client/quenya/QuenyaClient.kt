package codenomads.kotlintranslator.client.quenya

import codenomads.kotlintranslator.client.quenya.dto.QuenyaRequest
import codenomads.kotlintranslator.client.quenya.dto.QuenyaResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class QuenyaClient {

    companion object {
        private const val BASE_URL = "https://api.funtranslations.com"
        private const val ENDPOINT = "/translate/quenya.json"
    }

    private val webClient: WebClient = WebClient.create(BASE_URL)

    fun translateEnglishToQuenya(text: String): Mono<QuenyaResponse> {
        return webClient.post()
            .uri(ENDPOINT)
//            .body(Mono.just(QuenyaRequest(text)), QuenyaRequest::class.java)
            .body(BodyInserters.fromValue(QuenyaRequest(text)))
            .retrieve()
            .bodyToMono(QuenyaResponse::class.java)
    }


}