package com.ceva.config.root;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
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

    // configuramos el factory de hibernate
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(dataSource);
        lsfb.setPackagesToScan(new String[] {"com.ceva.data"});
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
        props.setProperty("hibernate.show_sql", "true");
        lsfb.setHibernateProperties(props);
        return lsfb;
    }

    // bean para el manejo de transacciones con hibernate
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    @Qualifier("jdbc")
    public DataRepository dataRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcRepository(jdbcTemplate);
    }

    @Bean
    @Qualifier("hibernate")
    public DataRepository hibernateRepository(SessionFactory sessionFactory) {
        return new HibernateRepository(sessionFactory);
    }
}
