package laf.reports;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@Configuration
@EnableWebMvc
public class LafMvcConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	protected ServletContext servletContext;
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
	        "classpath:/META-INF/resources/", "classpath:/resources/",
	        "classpath:/static/" };
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/clients").setViewName("clients");
        registry.addViewController("/client").setViewName("client");
        registry.addViewController("/department").setViewName("department");
        registry.addViewController("/equipments").setViewName("equipments");
        registry.addViewController("/technicians").setViewName("technicians");
        registry.addViewController("/instruments").setViewName("instruments");
    }
    
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
	
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		// Simple strategy: only path extension is taken into account
		configurer.favorPathExtension(true).ignoreAcceptHeader(true)
				.useJaf(false).defaultContentType(MediaType.TEXT_HTML)
				.mediaType("html", MediaType.TEXT_HTML)
				.mediaType("pdf", MediaType.valueOf("application/pdf"))
				.mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}
}
