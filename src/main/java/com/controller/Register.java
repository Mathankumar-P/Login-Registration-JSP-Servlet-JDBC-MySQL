package com.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbcutil.JdbcUtil;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("username");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password1");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		
		if(user==null || user=="") {
			request.setAttribute("status", "invalidUser");
			dispatcher.forward(request, response);
		}
		if(email==null || email=="") {
			request.setAttribute("status", "invalidEmail");
			dispatcher.forward(request, response);
		}
		if(mobile==null || mobile=="" || mobile.length()!=10) {
			request.setAttribute("status", "invalidMobile");
			dispatcher.forward(request, response);
		}
		if(password==null || password=="") {
			request.setAttribute("status", "invalidPassword");
			dispatcher.forward(request, response);
		}

		Connection connection = null;
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			String create = "Insert into register (username,email,mobile,password) values (?,?,?,?)";
			if (connection != null)
				pstmt = connection.prepareStatement(create);
			if (pstmt != null) {
				pstmt.setString(1, user);
				pstmt.setString(2, email);
				pstmt.setString(3, mobile);
				pstmt.setString(4, password);
				rowsAffected = pstmt.executeUpdate();
			}

			if (rowsAffected > 0) {
				request.setAttribute("status", "sucess");
				// System.out.println("Record Inserted");
			} else {
				request.setAttribute("status", "failure");
			}

			dispatcher.forward(request, response);
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
