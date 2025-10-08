package com.cillianbird;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import com.cillianbird.interceptors.LogInterceptor;

@Configuration
public class MvcAppConfig implements WebMvcConfigurer {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Sets the base name for your message properties file (e.g., src/main/resources/cillianbird-messages.properties)
        messageSource.setBasename("classpath:cillianbird-messages");
        messageSource.setCacheSeconds(60); // Refresh cache every 60 seconds
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
				.addVersionStrategy(new ContentVersionStrategy(), "/**");
		registry.addResourceHandler("/robots.txt").addResourceLocations("/robots.txt");
		registry.addResourceHandler("/sitemap.xml").addResourceLocations("/sitemap.xml");
		registry.addResourceHandler("/static/css/style*css").addResourceLocations("/static/css/")
				.setCachePeriod(1);
		registry.addResourceHandler("/static/**").addResourceLocations("/static/")
				.setCachePeriod(60 * 60 * 24 * 365)/* one year */
				.resourceChain(true).addResolver(versionResourceResolver);
	}
	
    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Registering your LogInterceptor
        registry.addInterceptor(logInterceptor());
    }
}