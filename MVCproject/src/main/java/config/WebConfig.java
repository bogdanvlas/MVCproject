package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "controller")
public class WebConfig implements WebMvcConfigurer{
	@Bean
	public ViewResolver getViewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//		resolver.setOrder(1);
		//добавляется после имени
		resolver.setSuffix(".ftl");
		return resolver;
	}
	@Bean
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		//тут лежат темплейты
		configurer.setTemplateLoaderPaths("/","WEB-INF/views/");
		return configurer;
	}
}
