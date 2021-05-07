package io.github.syakuis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.syakuis.config.support.SimpleModelMapper
import io.github.syakuis.config.support.SimpleObjectMapper
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BasicBeanConfiguration {
    @Bean
    fun objectMapper(): ObjectMapper {
        return SimpleObjectMapper.of(ObjectMapper())
    }

    @Bean
    fun modelMapper(): ModelMapper {
        return SimpleModelMapper.of()
    }
}
