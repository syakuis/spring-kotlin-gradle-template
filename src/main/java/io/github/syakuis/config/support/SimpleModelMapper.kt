package io.github.syakuis.config.support;

import org.modelmapper.ModelMapper;


class SimpleModelMapper {
    companion object {
        @JvmStatic
        fun of(): ModelMapper {
            val modelMapper = ModelMapper()
            modelMapper.configuration
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE).isSkipNullEnabled = true
            return modelMapper
        }
    }
}
