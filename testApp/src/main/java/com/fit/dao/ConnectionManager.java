package com.fit.dao;

import java.sql.*;

public class ConnectionManager {

	
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/user";
	private static final String DATABASE_USRE = "root";
	private static final String DATABASE_PASSWORD = "123456";

	/**
	 * 闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�鐎氱闂佽法鍠愰弸濠氬箯閿燂拷	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(DATABASE_URL,
					DATABASE_USRE, DATABASE_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}
	
	/**
	 * 闂佽法鍠愰崺鍛村箟鐎ｎ偄顏秎闂佽法鍠愰弸濠氬箯閿燂拷	 * 
	 * @param dbConnection
	 *            Connection
	 */
	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection != null && (!dbConnection.isClosed())) {
				dbConnection.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

	/**
	 * 闂佽法鍠愰崺鍛存⒒椤撶喐鐏柟椋庡厴閺佹捇鏁撻敓锟�*/
	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 闂佽法鍠愰崺鍛村箟鐎ｎ偄顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁跨噦鎷� */

	public static void closeStatement(Statement pStatement) {
		try {
			if (pStatement != null) {
				pStatement.close();
				pStatement = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
