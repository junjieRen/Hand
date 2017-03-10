package com.fit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fit.bean.Users;
import com.fit.dao.ConnectionManager;

public class UsersService {

	public Boolean isExit(Users u){
		Connection conn=ConnectionManager.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from users where u_id=? and u_pwd=?");
			ps.setString(1, u.getU_id());
			ps.setString(2, u.getU_pwd());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConnectionManager.closeConnection(conn);
		}
		return false;
	}
}
