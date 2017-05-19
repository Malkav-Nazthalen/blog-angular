package fr.malkav.spring.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

/**
 * Beans configuration to access to database using entityManager. Configuration
 * of database connection in folder 'src/main/resources/database.properties'
 * {@code} : With these beans, simple usage of entityManager in any DAO just
 * using "@PersistenceContext private EntityManager entityManager;"
 * 
 * @author Malkav
 *
 */
@Configuration
@PropertySource({ "classpath:database.properties" })
public class MalkDataSourceConfig {

	@Value("${datasource.driver}")
	private String datasourceDriver;
	@Value("${datasource.url}")
	private String datasourceUrl;
	@Value("${datasource.user}")
	private String datasourceUser;
	@Value("${datasource.password}")
	private String datasourcePassword;

	/**
	 * TransactionManager bean definition.
	 * 
	 * @return
	 */
	@Bean
	public AbstractPlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}

	/**
	 * EntityManagerFactory bean definition Using JPA with Hibernate
	 * implementation. With this, we can easyly inject entityManager in DAO.
	 * 
	 * @return
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	/**
	 * DataSource definition.
	 * 
	 * @value Driver : used to connect to database.
	 * @value URL of the database
	 * @value user && password to access to database.
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(datasourceDriver);
		dataSource.setUrl(datasourceUrl);
		dataSource.setUsername(datasourceUser);
		dataSource.setPassword(datasourcePassword);
		return dataSource;
	}
}
