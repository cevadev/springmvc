package com.ceva.config.root;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
public class RootConfig {
    /**
     * NOTA IMPORTANTE: La clase SingleConnectionDataSource solo puede manejar una conexion
     *                  por lo tanto no se recomienda utilizarla en produccion.
     *                  Para aplicaciones en produccion se recomienda utilizar un pool de conexiones
     * @return
     */
    @Bean
    public DataSource dataSource() {
        SingleConnectionDataSource ds = new SingleConnectionDataSource("jdbc:derby://localhost:1527/c:/java-development/javaPathDB",
                true);
        ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        return ds;
    }

    // bean que se inyecta en JdbcTemplate. Spring proveera el datasource que necesita este metodo
    // utilizara el metodo datasource() antes definido
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // Bean dataRepository que necesita un JdbcTemplate
    @Bean
    public DataRepository dataRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcRepository(jdbcTemplate);
    }
}
