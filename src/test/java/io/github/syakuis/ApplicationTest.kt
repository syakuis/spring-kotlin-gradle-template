package io.github.syakuis;

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.support.MessageSourceAccessor
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
class ApplicationTest {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var i18n: MessageSourceAccessor;

    @Autowired
    private lateinit var objectMapper: ObjectMapper;

    @Test
    fun `국제화 메세지`() {
        val name = i18n.getMessage("author.name");
        Assertions.assertEquals("Seokkyun. Choi.", name);
        log.debug(name);
    }

    @Test
    fun `jackson`() {
        val json = "[1,2,3,4]";
        Assertions.assertEquals(listOf(1, 2, 3, 4), objectMapper.readValue(json, ArrayList::class.java));
    }
}
