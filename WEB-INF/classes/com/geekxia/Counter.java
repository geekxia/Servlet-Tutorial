package com.geekxia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Counter extends HttpServlet {
	public Counter() {
		super();
	}
	
	private int counter;
	// �� init()�����г�ʼ����������������ߴ����ݱ��в�ѯ�������������ʼ��
	public void init() {
		counter = 0;
	}
	// �� doGet() �� doPost() ���ۼ����������
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		// �ۼӼ�����
		counter++;
		PrintWriter out = res.getWriter();
		out.println("<p>"+ counter +"</p>");
	}
	public void destroy() {
		// ������������洢�����ݱ���
	}
}
