package br.com.dhan.configurer;

import feign.Logger;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignConfiguer {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

    @Bean
    @Primary
    public Decoder customDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(messageConverters));
    }

/*    public ErrorDecoder customErrorDecoder() {
        return new ErrorDecoder() {
            @Override
            public Exception decode(String s, Response response) {
                return new RuntimeException(s);
            }
        };
    }*/

    @Bean
    Logger.Level loggerFeign() {
        return Logger.Level.FULL;
    }


}
