package com.distribuida.config;

import com.zaxxer.hikari.HikariDataSource;
import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;
import io.helidon.dbclient.jdbc.ConnectionPool;
import io.helidon.dbclient.jdbc.JdbcDbClientProviderBuilder;
import io.helidon.dbclient.spi.DbClientProvider;
import io.helidon.dbclient.spi.DbClientProviderBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class DbConfig {
    @Inject
    @ConfigProperty(name="db.connection.username")
    private String dbUser;

    @Inject
    @ConfigProperty(name="db.connection.password")
    private String dbPassword;

    @Inject
    @ConfigProperty(name="db.connection.url")
    private String dbUrl;

    @Produces
    @ApplicationScoped
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();

        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl(dbUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPassword);

        //ds.setMinimumIdle(1);
        //ds.setMaximumPoolSize(5);

        return ds;
    }

//    @Produces
//    @ApplicationScoped
//    public DbClient dbClent() {
//
//        var pool = ConnectionPool.builder()
//                .username(dbUser)
//                .password(dbPassword)
//                .url( dbUrl )
//                .build();
//
//        return JdbcDbClientProviderBuilder
//                .create()
//                .connectionPool(pool)
//                .build();
//    }

    @Produces
    @ApplicationScoped
    public EntityManager entityManager(){
        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        Map<String,String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.user",dbUser);
        properties.put("jakarta.persistence.jdbc.password",dbPassword);
        properties.put("jakarta.persistence.jdbc.url",dbUrl);
        properties.put("jakarta.persistence.jdbc.driver","org.postgresql.Driver");
        entityManagerFactory = Persistence.createEntityManagerFactory("book.jpa",properties);
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
