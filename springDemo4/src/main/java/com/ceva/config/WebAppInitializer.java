package com.ceva.config;

import com.ceva.config.root.RootConfig;
import com.ceva.config.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Clase que se utiliza para establecer la configuracion
 *
 * Spring suele crear dos contextos para una web app. el primer contexto es cargado con bean
 * relacionado al manejo de spring, es decir, los controladores, resolvedores de vistas. Estos beans
 * se cargan con la configuracion que se especifica en el metodo getServletConfigClasses()
 * El segundo contexto es creado para contener los bean relacionados a la aplicacion. getRootConfigClasses
 * retorna las respectivas clases de configuracion
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * Metodo que retonar las rutas que seran atendidas por DispatcherServlet que es el servlet de
     * Spring que atiende la peticiones
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        // indicamos que todas las peticiones seran atendidas por spring.
        return new String[]{"/"};
    }
}
