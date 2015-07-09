package com.oriental.springdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Import({ EnterpriseDbConfig.class})
public class CommonDbConfig extends BaseConfig {

  private final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
  private final String HIBERNATE_GENERATE_DDL = "hibernate.generate_ddl";

  private HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setShowSql(Boolean.valueOf(getProperty(HIBERNATE_SHOW_SQL)));
    hibernateJpaVendorAdapter.setGenerateDdl(Boolean.valueOf(getProperty(HIBERNATE_GENERATE_DDL)));
    return hibernateJpaVendorAdapter;
  }

  @Bean
  public JpaVendorAdapter db2VendorAdapter() {
    hibernateJpaVendorAdapter().setDatabase(Database.DB2);
    return hibernateJpaVendorAdapter();
  }

  //@Bean
  //public JpaVendorAdapter sqlVendorAdapter() {
  //  hibernateJpaVendorAdapter().setDatabase(Database.SQL_SERVER);
  //  return hibernateJpaVendorAdapter();
  //}

  @Bean
  public HibernateExceptionTranslator hibernateExceptionTranslator() {
    return new HibernateExceptionTranslator();
  }

}
