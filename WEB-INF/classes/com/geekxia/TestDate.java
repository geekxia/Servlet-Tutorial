package com.geekxia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class TestDate extends HttpServlet {
	public TestDate() {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		// ��ȡ��ǰ����
		Date now = new Date();
		// ������ʽ������
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E a");
		out.println("<p>"+ now.toString() +"</p>");
		out.println("<p>"+ ft.format(now) +"</p>");
	}
}
