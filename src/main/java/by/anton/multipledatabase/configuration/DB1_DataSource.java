package by.anton.multipledatabase.configuration;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@NoArgsConstructor
@Configuration
@EnableJpaRepositories(basePackages = {"by.anton.multipledatabase.repository.db1"},
        entityManagerFactoryRef = "db1EntityManager",
        transactionManagerRef = "db1TransactionManager")
public class DB1_DataSource {

    private Environment env;

    @Autowired
    public DB1_DataSource(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean db1EntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(db1Datasource());
        em.setPackagesToScan(new String[]{"by.anton.multipledatabase.entity.db1"});
        em.setPersistenceUnitName("db1EntityManager");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show-sql",
                env.getProperty("jdbc.show-sql"));
        properties.put("hibernate.hbm2ddl.auto", "update");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    public DataSource db1Datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager db1TransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                db1EntityManager().getObject());
        return transactionManager;
    }
}

