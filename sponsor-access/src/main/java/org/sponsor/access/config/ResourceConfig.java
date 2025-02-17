package org.sponsor.access.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedMethods("*");
	}
	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry) {
	 * registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
	 * registry.addRedirectViewController("/api/swagger-resources/configuration/ui",
	 * "/swagger-resources/configuration/ui"); registry.addRedirectViewController(
	 * "/api/swagger-resources/configuration/security",
	 * "/swagger-resources/configuration/security");
	 * registry.addRedirectViewController("/api/swagger-resources",
	 * "/swagger-resources"); }
	 * 
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations(
	 * "classpath:/META-INF/resources/swagger-ui.html");
	 * registry.addResourceHandler("/api/webjars/**").addResourceLocations(
	 * "classpath:/META-INF/resources/webjars/"); }
	 */
}
