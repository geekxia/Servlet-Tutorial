package com.geekxia;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;

public class TestCookie extends HttpServlet {
	public TestCookie() {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ��HTTP�ж�ȡCookie
		Cookie[] cookies = null;		
		cookies = req.getCookies();
		
		if (cookies == null) {
			// ����Cookie������Cookie��Ч�ڡ����Cookie��HTTP��
			Cookie name = new Cookie("name", "geekxia");
			name.setMaxAge(60*60*24);
			res.addCookie(name);
		} else {
			if ((cookies[0].getName()).compareTo("name") != 0) {
				PrintWriter out = res.getWriter();
				out.println("<p>" + cookies[0].getName() + " : " + cookies[0].getValue() + "</p>");
			}
			// ɾ��cookieʱ��ֻ���cookie����Ч������Ϊ0����ʵ��
			// cookies[0].setMaxAge(0);
			// res.addCookie(cookies[0]);
		}
	}
}
