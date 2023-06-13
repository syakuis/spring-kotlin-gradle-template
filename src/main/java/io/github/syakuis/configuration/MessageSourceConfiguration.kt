package io.github.syakuis.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.support.AbstractApplicationContext
import org.springframework.context.support.MessageSourceAccessor
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import java.util.*

@ConditionalOnBean(name = [AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME])
@AutoConfiguration(after = [MessageSource::class])
class MessageSourceConfiguration(private val messageSource: MessageSource) {
    @Bean
    fun messageSourceAccessor(): MessageSourceAccessor {
        return MessageSourceAccessor(messageSource, Locale.getDefault())
    }

    @Bean
    fun validator(): LocalValidatorFactoryBean {
        val bean = LocalValidatorFactoryBean()
        bean.setValidationMessageSource(messageSource)
        return bean
    }
}
