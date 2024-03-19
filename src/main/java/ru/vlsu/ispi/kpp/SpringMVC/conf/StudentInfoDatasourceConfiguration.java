package ru.vlsu.ispi.kpp.SpringMVC.conf;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.vlsu.ispi.kpp.SpringMVC.model.info.StudentDetails;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "infoEntityManagerFactory",
        transactionManagerRef = "infoTransactionManager",
        basePackages = { "ru.vlsu.ispi.kpp.SpringMVC.repo.info", },
        basePackageClasses = StudentDetails.class)
public class StudentInfoDatasourceConfiguration {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl_auto;

    @Value("${spring.datasource.info.data}")
    private String data_file;

    @Bean(name="infoProperties")
    @ConfigurationProperties("spring.datasource.info")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="infoDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.info")
    public DataSource datasource(@Qualifier("infoProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder()
                .build();
    }

    @Bean(name="infoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("infoDatasource") DataSource dataSource){
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", ddl_auto);
        return builder.dataSource(dataSource)
                .packages(StudentDetails.class)
                .properties(properties)
                .persistenceUnit("info")
                .build();
    }

    @Bean(name = "infoTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("infoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(@Qualifier("infoDatasource") DataSource datasource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        //resourceDatabasePopulator.addScript(new ClassPathResource("schema-h21.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource(data_file));

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(datasource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }
}
