/*
 * Copyright (c) 2017 Felix Klauke
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.felix_klauke.prophecy.core.pool;

import de.felix_klauke.prophecy.core.config.ProphecyConfig;
import de.felix_klauke.prophecy.core.connection.ProphecyConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Pool impl to hold some {@link ProphecyConnection}
 *
 * @author Felix Klauke (info@felix-klauke.de)
 */
public class ProphecyConnectionPool extends AbstractPool<ProphecyConnection> {

  /**
   * Config for connections.
   */
  private final ProphecyConfig prophecyConfig;

  /**
   * Create a new connection pool.
   *
   * @param prophecyConfig The config.
   */
  public ProphecyConnectionPool(ProphecyConfig prophecyConfig) {
    this.prophecyConfig = prophecyConfig;
  }

  @Override
  public ProphecyConnection create() {
    try {
      Connection connection = DriverManager
          .getConnection(prophecyConfig.getDatabaseURL(), prophecyConfig.getDatabaseUser(),
              prophecyConfig.getDatabaseUserPassword());
      return new ProphecyConnection(this, connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }
}
