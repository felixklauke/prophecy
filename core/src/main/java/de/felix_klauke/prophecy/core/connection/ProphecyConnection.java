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

package de.felix_klauke.prophecy.core.connection;

import de.felix_klauke.prophecy.core.pool.Pool;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Wrapper around {@link Connection}
 *
 * @author Felix 'SasukeKawaii' Klauke
 */
public class ProphecyConnection implements Connection {

    private final Pool<ProphecyConnection> connectionPool;
    private final Connection handle;

    public ProphecyConnection(Pool<ProphecyConnection> connectionPool, Connection handle) {
        this.connectionPool = connectionPool;
        this.handle = handle;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return handle.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return handle.prepareStatement(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return handle.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return handle.nativeSQL(sql);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return handle.getAutoCommit();
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        handle.setAutoCommit(autoCommit);
    }

    @Override
    public void commit() throws SQLException {
        handle.commit();
    }

    @Override
    public void rollback() throws SQLException {
        handle.rollback();
    }

    @Override
    public void close() throws SQLException {

        this.connectionPool.checkIn(this);
    }

    @Override
    public boolean isClosed() throws SQLException {
        return handle.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return handle.getMetaData();
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return handle.isReadOnly();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        handle.setReadOnly(readOnly);
    }

    @Override
    public String getCatalog() throws SQLException {
        return handle.getCatalog();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        handle.setCatalog(catalog);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return handle.getTransactionIsolation();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        handle.setTransactionIsolation(level);
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return handle.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        handle.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return handle.createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return handle.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return handle.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return handle.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        handle.setTypeMap(map);
    }

    @Override
    public int getHoldability() throws SQLException {
        return handle.getHoldability();
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        handle.setHoldability(holdability);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return handle.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return handle.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        handle.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        handle.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return handle.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return handle.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return handle.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return handle.prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return handle.prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return handle.prepareStatement(sql, columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return handle.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return handle.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return handle.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return handle.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return handle.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        handle.setClientInfo(name, value);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return handle.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return handle.getClientInfo();
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        handle.setClientInfo(properties);
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return handle.createArrayOf(typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return handle.createStruct(typeName, attributes);
    }

    @Override
    public String getSchema() throws SQLException {
        return handle.getSchema();
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        handle.setSchema(schema);
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        handle.abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        handle.setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return handle.getNetworkTimeout();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return handle.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return handle.isWrapperFor(iface);
    }
}
