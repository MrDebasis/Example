package com.example.repo;

/*
 * this class contains constants for repo details
 * */
public class RepositoryUtils {
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_NAME = "example";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/example?user=root&password=1234";

	public static String getDriverName() {
		return DRIVER_NAME;
	}

	public static String getDatabaseName() {
		return DATABASE_NAME;
	}

	public static String getDbUrl() {
		return DB_URL;
	}

}