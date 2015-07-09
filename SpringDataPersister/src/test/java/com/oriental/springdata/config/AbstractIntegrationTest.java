package com.oriental.springdata.config;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Base class for integration tests.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class AbstractIntegrationTest {

  @Inject
  DataSource dataSource;

  /**
   * Populates the configured {@link DataSource} with data from {@code data.sql}.
   *
   * @throws SQLException
   */
  @Before
  public void populateDatabase() throws SQLException {

  }
}
