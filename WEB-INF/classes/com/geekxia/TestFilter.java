package com.geekxia;

import javax.servlet.*;
import java.util.*;

public class TestFilter implements Filter {
	// ��������ʼ��
	public void init(FilterConfig config) throws ServletException {
		String site = config.getInitParameter("Site");
		System.out.println("��վ���ƣ�" + site);
	}
	// ������ִ�н׶�
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws java.io.IOException, ServletException {
		System.out.println("geekxia");
		chain.doFilter(req, res);
	}
	// ���������ٽ׶�
	public void destroy() {}
}
