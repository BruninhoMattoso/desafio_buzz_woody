package com.dextra.injectit.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dextra.injectit.database.Database;
import com.dextra.injectit.database.MockDatabase;
import com.dextra.injectit.database.User;
import com.google.gson.Gson;

public class InjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1267446324696819053L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf8");
		resp.setStatus(200);
		
		String query = "SELECT * FROM USER";
		ResultSet users = Database.execute(query);
		
		ArrayList<User> searchedUsers = new ArrayList<User>();
		try {
			
			while (users.next()){
				searchedUsers.add(new User(users.getString(1),users.getString(2),users.getString(3)));
			}
			
			Gson gson = new Gson();
			ServletOutputStream os = resp.getOutputStream();
			
			os.print(gson.toJson(searchedUsers));
			os.flush();
			os.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Nome dos usuario pesquisado
		String name = req.getParameter("name");
		String[] names = new String[1];
		names[0] = name;
		
		String query = "SELECT * FROM USER WHERE NAME = ?";
		ResultSet users = Database.execute(query,names);
		
		ArrayList<User> searchedUsers = new ArrayList<User>();
		try {
			
			while (users.next()){
				searchedUsers.add(new User(users.getString(1),users.getString(2),users.getString(3)));
			}
			
			Gson gson = new Gson();
			ServletOutputStream os = resp.getOutputStream();
			
			os.print(gson.toJson(searchedUsers));
			os.flush();
			os.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}