package com.springrest.api;

import feign.form.FormEncoder;
import org.springframework.context.annotation.Bean;

public class FeignSimpleEncoderConfig {

    @Bean
    public FormEncoder encoder(){
        return new FormEncoder();
    }
}
