package com.distribuida.config;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;


public class DbConfig {

    @Inject
    @ConfigProperty(name = "quarkus.datasource.username")
    String dbUser;

    @Inject
    @ConfigProperty(name = "quarkus.datasource.password")
    String dbPassword;

    @Inject
    @ConfigProperty(name = "quarkus.datasource.url")
    String dbUrl;

    @Inject
    @ConfigProperty(name = "quarkus.datasource.driver")
    String dbDriver;

//    @Produces
//    @ApplicationScoped
//    public DataSource dataSource() {
//        HikariDataSource ds = new HikariDataSource();
//        ds.setDriverClassName(dbDriver);
//        ds.setJdbcUrl(dbUrl);
//        ds.setUsername(dbUser);
//        ds.setPassword(dbPassword);
//        return ds;
//    }

//    @Produces
//    @ApplicationScoped
//    public Jdbi jdbi(DataSource dataSource){
//        Jdbi ret = Jdbi.create(dataSource);
//        ret.installPlugin(new SqlObjectPlugin());
//        return ret;
//    }
//
//    @Produces
//    @ApplicationScoped
//    public AuthorRepository authorRepository(Jdbi jdbi){
//        return jdbi.onDemand(AuthorRepository.class);
//    }
}
