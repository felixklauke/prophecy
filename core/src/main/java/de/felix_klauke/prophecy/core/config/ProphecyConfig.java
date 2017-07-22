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

package de.felix_klauke.prophecy.core.config;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
public class ProphecyConfig {

    /**
     * URL Of the database.
     */
    private final String databaseURL;

    /**
     * User to login into the db.
     */
    private final String databaseUser;

    /**
     * Password to login.
     */
    private final String databaseUserPassword;

    /**
     * Create a config by all its data.
     *
     * @param databaseURL          The url.
     * @param databaseUser         The user.
     * @param databaseUserPassword The password.
     */
    public ProphecyConfig(String databaseURL, String databaseUser, String databaseUserPassword) {
        this.databaseURL = databaseURL;
        this.databaseUser = databaseUser;
        this.databaseUserPassword = databaseUserPassword;
    }

    /**
     * Create a new builder.
     *
     * @return The builder.
     */
    public static ProphecyConfigBuilder newBuilder() {
        return new ProphecyConfigBuilder();
    }

    /**
     * Get the url of the database.
     *
     * @return The url.
     */
    public String getDatabaseURL() {
        return databaseURL;
    }

    /**
     * Get the user for the database.
     *
     * @return The database user.
     */
    public String getDatabaseUser() {
        return databaseUser;
    }

    /**
     * Get the password for the user.
     *
     * @return The password.
     */
    public String getDatabaseUserPassword() {
        return databaseUserPassword;
    }
}
