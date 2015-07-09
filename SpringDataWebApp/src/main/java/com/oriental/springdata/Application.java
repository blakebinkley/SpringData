package com.oriental.springdata;

import com.oriental.springdata.config.CommonDbConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@EnableWebMvc
@Import({CommonDbConfig.class})
@ComponentScan(basePackages = {"com.oriental.springdata.controller", "com.oriental.springdata.service"})
@Configuration
public class Application extends WebMvcConfigurerAdapter {

  private static final Integer RESOURCE_CACHE_PERIOD_SECONDS = Integer.valueOf(10);

  @Override
  public Validator getValidator() {
    return new LocalValidatorFactoryBean();
  }

  @Bean
  public ViewResolver getViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setViewClass(JstlView.class);
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");

    return resolver;
  }

  /**
   * Add JSON and StringHttpMessageConverters by Default.
   *
   * @param converters The List of Converters to add to.
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new StringHttpMessageConverter());
    converters.add(new MappingJackson2HttpMessageConverter());
  }

  /**
   * Set up mapping of resource requests to resource locations with a cache setting as defined by
   * {@code RESOURCE_CACHE_PERIOD}. During development, if using Javascript actively, you might want to prevent caching
   * of javascript as well.
   *
   * @param registry ResourceHandlerRegistry
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/img/**", "/js/**", "/css/**").addResourceLocations("/img/*", "/js/*", "/css/*")
        .setCachePeriod(RESOURCE_CACHE_PERIOD_SECONDS);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // Add an interceptor to prevent caching of all responses except those white listed
    // below
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    // Send calls to default servlet that Spring MVC does not handle
    configurer.enable();
  }

  /**
   * @return Messages are handled via an external message bundle. Some message properties are easier handled via
   * resource bundles. The War overlay uses some of the properties so if you remove the message source, then
   * note that the Overlay will not work correctly.
   */
  @Bean(name = "messageSource")
  public MessageSource getMessageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("messages");
    return messageSource;
  }

}