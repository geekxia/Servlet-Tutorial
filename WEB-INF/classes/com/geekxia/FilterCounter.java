package com.geekxia;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import java.io.IOException;
import javax.servlet.ServletException;

public class FilterCounter implements Filter {
	private int counter;
	
	// �� init() �����г�ʼ�����������
	public void init(FilterConfig config) throws ServletException {
		counter = 0;
	}
	// �� doFilter() �����У��ۼ����������
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// �������ۼ�
		counter++;
		System.out.print("��վ��������"+counter);
		// ���������Ӧ���ش�����������
		chain.doFilter(req, res);
	}
	public void destroy() {
		// ������Ѽ�������ֵ��д�����ݿ�
	}
}
