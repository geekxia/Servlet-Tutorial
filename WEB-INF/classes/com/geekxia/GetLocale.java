package com.geekxia;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;

public class GetLocale extends HttpServlet {
	public GetLocale() {
		super();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ��ȡ�ͻ��˵��������
		Locale loc = req.getLocale();
		
		// ��ȡ��ǰ��������ԡ�����
		String language = loc.getLanguage();
		String country = loc.getCountry();
		
		// �Ե�ǰ�����ʱ����и�ʽ��
		String date = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, loc).format(new Date());
		
		// �Ե�ǰ����Ļ��Ҹ�ʽ�����ٷֱȸ�ʽ��
		NumberFormat nft = NumberFormat.getCurrencyInstance(loc);
		String formattedCurr = nft.format(1000000);
		String formattedPerc = nft.format(0.51);
		
		
		// ��������
		res.setHeader("Content-Language", "es");
		// ������Ӧ��������
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.println("<h1>"+ language +"</h1>");
		out.println("<h1>"+ country +"</h1>");
		out.println("<h1>"+ date +"</h1>");
		out.println("<h1>"+ formattedCurr +"</h1>");
		out.println("<h1>"+ formattedPerc +"</h1>");
	}
}
