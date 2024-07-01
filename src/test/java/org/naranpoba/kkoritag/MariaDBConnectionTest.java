package org.naranpoba.kkoritag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class MariaDBConnectionTest {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/kkoritag";
	private static final String USER = "naranpoba";
	private static final String PASSWORD = "P@ssw0rd";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection connection = DriverManager.getConnection(URL,USER, PASSWORD)){
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
