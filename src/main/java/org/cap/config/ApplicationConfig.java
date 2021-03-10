package org.cap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"org.cap"})
@EnableTransactionManagement
public class ApplicationConfig implements WebMvcConfigurer{
	
	
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
	}

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver=
				new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		
		LocalEntityManagerFactoryBean factoryBean
			=new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("jpademo");
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager getTranactionManager() {
		JpaTransactionManager transactionManager=
				new JpaTransactionManager();
		transactionManager
			.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		
		return transactionManager;
	}
}
