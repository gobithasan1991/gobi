package com.basic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc 
public class WebConfig implements WebMvcConfigurer{
	@Value("${spring.mvc.view.prefix}")
	private String prefix;
	@Value("${spring.mvc.view.suffix}")
	private String suffix; 
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) { 
		registry.addResourceHandler("/plugins/**").addResourceLocations("/WEB-INF/resource/plugins/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resource/js/");  
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resource/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resource/images/");
		registry.addResourceHandler("/assert/**").addResourceLocations("/WEB-INF/views/");
		registry.addResourceHandler("/wj-plugins/**").addResourceLocations("/webjars/"); 
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
	    InternalResourceViewResolver resolver= new InternalResourceViewResolver(); 
	    resolver.setPrefix(prefix);
	    resolver.setSuffix(suffix);
	    return resolver;
	} 
}
