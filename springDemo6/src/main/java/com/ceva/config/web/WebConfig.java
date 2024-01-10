package com.ceva.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc // activamos la bibliotea mvc
@ComponentScan // le decimos a spring que busque en este paquete componentes anotados como @Bean
public class WebConfig implements WebMvcConfigurer {

    /**
     * Especificamos quien resuelve las vistas. Por defecto spring resuelve las vistas
     * buscando un bean que tenga el mismo nombre de la vista y que implemente la interface View
     * En nuestro caso las vistas se van a resolver con archivos .jsp
     * viewResover() -> retorna una instancia de la clase InternalResourceViewResolver que
     *                  redirecciona las peticiones a archivos jsp
     * Si la vista se llama prueba entonces se delegara el control a /WEB-INF/views/prueba.jsp
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // indicamos donde estaran ubicados las vistas
        resolver.setPrefix("/WEB-INF/views/");
        // indicamos la extension con la que terminaran las vistas
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    // metodo que le dice a Spring que no trate de manejar los recursos staticos como una imagen
    // y los delege al manejador standard
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
