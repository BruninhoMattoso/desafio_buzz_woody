package com.dextra.injectit.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dextra.injectit.database.Database;

public class InjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1267446324696819053L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {

			String q = req.getParameter("name");
			
			String query = "SELECT * FROM USER";
			if (q != null) {
			}

			ResultSet rs = Database.execute(query);
			resp.setContentType("text/html");
			ServletOutputStream os = resp.getOutputStream();
			os.print("<table>");
			os.print("<thead><th>Nome</th><th>Senha</th><th>Cart&atilde;o</th></thead>");
			os.print("<tbody>");

			rs.first();
			while (rs.next()) {
				os.print(String.format(
						"<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
						rs.getString(1), rs.getString(2), rs.getString(3)));
			}

			os.print("</tbody>");
			os.print("</table>");

			os.flush();
			os.close();
		} catch (SQLException e1) {
			throw new ServletException(e1.getMessage());
		}
	}
}
