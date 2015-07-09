package com.oriental.springdata.config;

import org.hibernate.ejb.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;

import javax.inject.Inject;
import javax.naming.Context;
import java.util.Properties;

@PropertySource("classpath:hibernate.properties")
public class BaseConfig {

  @Inject
  Environment env;
  
  private final String DB2_DIALECT = "db2.hibernate.dialect";
  
  //private final String MSSQL_DIALECT = "mssql.hibernate.dialect";

  private final String TRANSACTION_MANAGER_LOOKUP_CLASS = "hibernate.transaction.manager_lookup_class";

  private final String TRANSACTION_FACTORY_CLASS = "transaction.factory_class";

  @Bean
  public JndiTemplate jndiTemplate() {
    JndiTemplate jndiTemplate = new JndiTemplate();
    jndiTemplate.setEnvironment(getContextProperties());
    return jndiTemplate;
  }

  private Properties getContextProperties() {
    Properties properties = new Properties();
    properties.put(Context.INITIAL_CONTEXT_FACTORY, getProperty(Context.INITIAL_CONTEXT_FACTORY));
    return properties;
  }

  protected Properties getdb2JpaProperties() {
    Properties jpaProperties = getJpaProperties();
    jpaProperties.setProperty("hibernate.dialect", getProperty(DB2_DIALECT));
    jpaProperties.setProperty(TRANSACTION_MANAGER_LOOKUP_CLASS, getProperty(TRANSACTION_MANAGER_LOOKUP_CLASS));
    jpaProperties.setProperty(TRANSACTION_FACTORY_CLASS, getProperty(TRANSACTION_FACTORY_CLASS));

    return jpaProperties;
  }
  
  //protected Properties getMsSqlJpaProperties() {
  //  Properties jpaProperties = getJpaProperties();
  // jpaProperties.setProperty("hibernate.dialect", getProperty(MSSQL_DIALECT));
  //  return jpaProperties;
  //}

  private Properties getJpaProperties() {
    Properties jpaProperties = new Properties();
    jpaProperties.put(AvailableSettings.SHARED_CACHE_MODE, getProperty(AvailableSettings.SHARED_CACHE_MODE));
    jpaProperties.put(AvailableSettings.VALIDATION_MODE, getProperty(AvailableSettings.VALIDATION_MODE));
    return jpaProperties;
  }

  protected String getProperty(String propertyName) {
    return env.getProperty(propertyName);
  }
}
