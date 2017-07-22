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

package de.felix_klauke.prophecy.core;

import de.felix_klauke.prophecy.core.config.ProphecyConfig;
import de.felix_klauke.prophecy.core.connection.ProphecyConnection;
import de.felix_klauke.prophecy.core.datasource.ProphecyDataSource;
import de.felix_klauke.prophecy.core.pool.Pool;
import de.felix_klauke.prophecy.core.pool.ProphecyConnectionPool;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Basic Prophecy implementation.
 *
 * @author Felix 'SasukeKawaii' Klauke
 */
public class SimpleProphecy implements Prophecy {

    /**
     * The underlying pool.
     */
    private final Pool<ProphecyConnection> connectionPool;

    SimpleProphecy(ProphecyConfig config) {
        this.connectionPool = new ProphecyConnectionPool(config);
    }

    @Override
    public Connection getConnection() {
        return this.connectionPool.checkOut();
    }

    @Override
    public void checkInConnection(Connection connection) {
        if (connection instanceof ProphecyConnection) {
            this.connectionPool.checkIn((ProphecyConnection) connection);
        }
    }

    @Override
    public DataSource createDatasource() {
        return new ProphecyDataSource(connectionPool);
    }
}
