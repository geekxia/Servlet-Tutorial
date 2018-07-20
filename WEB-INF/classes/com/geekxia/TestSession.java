package com.geekxia;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class TestSession extends HttpServlet {
	public TestSession() {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ���������session�Ự���ʹ���һ��session����
		HttpSession session = req.getSession(true);
		// ʹ��session����
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>"+ session.getId() +"</h1>");
	}
}
