package com.dextra.injectit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		ServletOutputStream os = resp.getOutputStream();
		os.print("[");
		os.print("{\"name\":\"Moretinho\",\"password\":\"eumeamo\",\"creditCardNumber\":\"38386633\"}");
//		os.print(new Gson().toJson(new User("Moretinho", "eumeamo", "38386633")));
		os.print("]");
		os.flush();
		os.close();
//		try {
//			String query = "SELECT * FROM USER";
//			
//			ResultSet rs = Database.execute(query);
//			resp.setContentType("text/html");
//			ServletOutputStream os = resp.getOutputStream();
//			os.print("<table>");
//			os.print("<thead><th>Nome</th><th>Senha</th><th>Cart&atilde;o</th></thead>");
//			os.print("<tbody>");
//
//			rs.first();
//			while (rs.next()) {
//				os.print(String.format(
//						"<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
//						rs.getString(1), rs.getString(2), rs.getString(3)));
//			}
//
//			os.print("</tbody>");
//			os.print("</table>");
//
//			os.flush();
//			os.close();
//		} catch (SQLException e1) {
//			throw new ServletException(e1.getMessage());
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Nome dos usuario pesquisado
		/*String name = req.getParameter("name");
		
		ResultSet users = Database.execute("SELECT * FROM USER WHERE NAME = '" + name + "'");
		ArrayList<User> searchedUsers = new ArrayList<User>();
		try {
			
			while (users.next()){
				String userName = users.getString(1);
				String userPassword = users.getString(2);
				String userCard = users.getString(3);
				User user = new User(userName,userPassword,userCard);
			}
			
			Gson gson = new Gson();
			gson.toJson(src);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		*/
	}
}
