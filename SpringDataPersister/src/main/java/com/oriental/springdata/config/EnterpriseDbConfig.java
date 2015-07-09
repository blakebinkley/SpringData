package com.oriental.springdata.config;

import org.apache.log4j.Logger;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.WebLogicJtaTransactionManager;

@Configuration
@EnableJpaRepositories(transactionManagerRef = "webLogicJtaTransactionManager",
    entityManagerFactoryRef = "erpEntityManagerFactory", basePackages = "com.oriental.springdata.model.repository.db2")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.oriental.springdata.model.entity.db2")
public class EnterpriseDbConfig extends BaseConfig {

private static final Logger LOGGER = Logger.getLogger(EnterpriseDbConfig.class);

private final String DB_ENTITY_PACKAGE = "db2.entity.package";

private final String JNDI_DB2_NAME = "jndi.db2.name";

  @Bean
  DataSource db2DataSource() {
    DataSource dataSource = null;
    try {
      dataSource = jndiTemplate().lookup(getProperty(JNDI_DB2_NAME), DataSource.class);
    } catch (NamingException e) {
      LOGGER.error("NamingException for java:comp/env/jdbc/"+getProperty(JNDI_DB2_NAME), e);
    }
    return dataSource;
  }

  @Bean
  public UserTransaction userTransaction(){
    return new WebLogicJtaTransactionManager().getUserTransaction();
  }

  @Bean
  @Primary
  public WebLogicJtaTransactionManager webLogicJtaTransactionManager(){
    WebLogicJtaTransactionManager webLogicJtaTransactionManager = new WebLogicJtaTransactionManager();
    webLogicJtaTransactionManager.setJndiTemplate(jndiTemplate());
    return webLogicJtaTransactionManager;
  }

  @Bean
  public EntityManagerFactory erpEntityManagerFactory(DataSource db2DataSource,
                                                      @Qualifier("db2VendorAdapter") JpaVendorAdapter db2VendorAdapter) {
    LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
    lef.setJtaDataSource(db2DataSource);
    lef.setJpaVendorAdapter(db2VendorAdapter);
    lef.setJpaProperties(getdb2JpaProperties());
    lef.setPersistenceProviderClass(HibernatePersistence.class);
    lef.setPackagesToScan(getProperty(DB_ENTITY_PACKAGE));
    lef.afterPropertiesSet();
    return lef.getObject();
  }

}