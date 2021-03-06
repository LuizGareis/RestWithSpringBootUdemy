package com.luizgareis.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.luizgareis.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		//Via EXTENSION = localhost:8080/api/v1/person.xml ou .json
		/*configurer.favorParameter(false)
		.ignoreAcceptHeader(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);*/
		
		
		//Via Query Param, localhost:8080/api/v1/person?mediaType=xml ou json
		/*
		 * configurer.favorPathExtension(false) .favorParameter(true)
		 .parameterName("mediaType") .ignoreAcceptHeader(false)
		 .useRegisteredExtensionsOnly(false)
		 .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
		 */
		
		// Via HEADER Accept/ Application-json ou xml
		configurer.favorPathExtension(false) 
			.favorParameter(false)
			.ignoreAcceptHeader(false)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON) 
			.mediaType("xml", MediaType.APPLICATION_XML)
			.mediaType("x-yaml", MEDIA_TYPE_YML);
	}

}
