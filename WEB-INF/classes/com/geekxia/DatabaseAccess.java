package com.geekxia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class DatabaseAccess extends HttpServlet {
	public DatabaseAccess() {
		super();
	}
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/GEEKXIA";
	private static final String USER = "root";
	private static final String PASS = "123456";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		try {
			// ע��JDBC����
			Class.forName("com.mysql.jdbc.Driver");
			// ����һ�����ݿ�����
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// ִ��SQL���
			stmt = conn.createStatement();
			String sql = "SELECT id, name, url FROM geekxia";
			ResultSet rs = stmt.executeQuery(sql);
			
			// �ӽ�����ж�ȡ����
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				
				out.println("<p>"+ id +"</p>" + "<p>"+ name +"</p>" + "<p>"+ url +"</p>");
			}
			// ��ɺ�ر�
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			// ����JDBC����
			e.printStackTrace();
		} catch(Exception e) {
			// ����Class.forName����
			e.printStackTrace();
		} finally {
			// �ر���Դ 
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
 }
