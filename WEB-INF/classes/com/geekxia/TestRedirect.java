package com.geekxia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class TestRedirect extends HttpServlet {
	public TestRedirect() {
		super();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		String site = new String("http://evatsai.com");
		// ʵ���ض����ض�����һ������ http://evatsai.com
		res.setStatus(res.SC_MOVED_TEMPORARILY);
		res.setHeader("Location", site);
	}
}
