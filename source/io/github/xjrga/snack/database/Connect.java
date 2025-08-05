package io.github.xjrga.snack.database;

/*
 * Copyright (C) 2018 Jorge R Garcia de Alba License: http://www.gnu.org/licenses/gpl.html GPL
 * version 2 or higher
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
import io.github.xjrga.snack.logger.LoggerImpl;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connect {

	private static Connection connection = null;
	private static String DB_PASS = "";
	private static String DB_URL = "";
	private static String DB_USER = "";
	private static InputStream input = null;
	private static final Connect instance = new Connect();
	private static String JDBC_DRIVER = "";
	private static Properties prop = null;

	public static Connect getInstance() {

		return instance;

	}

	private Connect() {

	}

	public Connection getConnection() {

		try {

			if ( connection != null && !connection.isClosed() ) {

				return connection;

			}

			prop = new Properties();
			input = new FileInputStream( "config/connection.properties" );
			prop.load( input );
			JDBC_DRIVER = prop.getProperty( "jdbc.driver" );
			DB_URL = prop.getProperty( "jdbc.url" );
			DB_USER = prop.getProperty( "jdbc.username" );
			DB_PASS = prop.getProperty( "jdbc.password" );
			Class.forName( JDBC_DRIVER );
			connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PASS );

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

		return connection;

	}

	// public Connection getConnection() {
	// USER_HOME = System.getProperty("user.home");
	// StringBuilder sb = new StringBuilder();
	// sb.append("jdbc:hsqldb:file:");
	// sb.append(USER_HOME);
	// sb.append(File.separator);
	// sb.append(".snack");
	// sb.append(File.separator);
	// sb.append("database");
	// sb.append(File.separator);
	// sb.append("instance");
	// sb.append(File.separator);
	// sb.append("snack2;shutdown=true");
	// JDBC_DRIVER = "org.hsqldb.jdbcDriver";
	// DB_URL = sb.toString();
	// DB_USER = "SA";
	// DB_PASS = "";
	// try {
	// Class.forName(JDBC_DRIVER);
	// } catch (ClassNotFoundException e) {
	// }
	// try {
	// connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	// } catch (SQLException e) {
	// }
	// return connection;
	// }
}
