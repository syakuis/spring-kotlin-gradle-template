package io.github.syakuis;

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.MessageSource
import org.springframework.context.support.MessageSourceAccessor

@SpringBootTest
internal class ApplicationTest : BehaviorSpec() {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var messageSource: MessageSource

    @Autowired
    private lateinit var messageSourceAccessor: MessageSourceAccessor

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    init {
        Given("스프링 부트 테스트") {
            Then("스프링 빈 생성됨.") {
                messageSource shouldNotBe null
            }
            When("국제화 메세지를 가져온다.") {
                val name = messageSourceAccessor.getMessage("author.name")

                Then("메세지를 정상적으로 가져왔다.") {
                    "Seokkyun. Choi." shouldBe name
                }

            }

            When("jackson 값을 설정한다.") {
                val json = "[1,2,3,4]"

                Then("값을 비교한다.") {
                    listOf(1, 2, 3, 4) shouldBe objectMapper.readValue(json, ArrayList::class.java)
                }
            }
        }
    }
}
