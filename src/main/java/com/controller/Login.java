package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbcutil.JdbcUtil;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//System.out.println(email);
		//System.out.println(password);
		HttpSession session = request.getSession();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RequestDispatcher dispatch = null;
		
		if(email==null || email=="") {
			request.setAttribute("status", "invalidEmail");
			dispatch=request.getRequestDispatcher("login.jsp");
			dispatch.forward(request, response);
		}
		if(password==null || password=="") {
			request.setAttribute("status", "invalidPassword");
			dispatch=request.getRequestDispatcher("login.jsp");
			dispatch.forward(request, response);
		}

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement("select * from register where email=?");
			}
			if (pstmt != null) {
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
			}
			if (rs.next() && (rs.getString("password").equals(password))) {
				//System.out.println(rs.getString("username"));
				session.setAttribute("username", rs.getString("username"));
				session.setAttribute("mail", rs.getString("email"));
				session.setAttribute("mobile", rs.getString("mobile"));
				dispatch = request.getRequestDispatcher("index.jsp");

			} else {
				request.setAttribute("status", "failure");
				dispatch = request.getRequestDispatcher("login.jsp");
				System.out.println("login failed");
			}
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
