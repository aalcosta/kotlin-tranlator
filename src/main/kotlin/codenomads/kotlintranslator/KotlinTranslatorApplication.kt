package codenomads.kotlintranslator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinTranslatorApplication

fun main(args: Array<String>) {
	runApplication<KotlinTranslatorApplication>(*args)
}
