package mvs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by quangminh on 27/06/2017.
 */
@Configuration
@ComponentScan(basePackageClasses = SpringApplication.class)
@EnableJpaRepositories(basePackages = "mvs.repository")
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication
public class SpringApplication extends SpringBootServletInitializer {

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringApplication.class);
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

}
