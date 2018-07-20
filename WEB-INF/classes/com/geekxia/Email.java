package com.geekxia;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email extends HttpServlet {
	public Email() {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �ռ���
		String to = "108508992@qq.com";
		// ������
		String from = "448914712@qq.com";
		// �����ʼ���������ַ
		String host = "localhost";
		// ��ȡϵͳ����
		Properties props = System.getProperties();
		// �����ʼ��������������ʼ��������ṩ�û���֤
		props.setProperty("mail.smtp.host", host);
		props.setProperty("mail.user", "myuser");
		props.setProperty("mail.password", "mypwd");
		// ��ȡĬ�ϵ� session ����
		Session session = Session.getDefaultInstance(props);
		// ������Ӧ��������
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		try {
			// ����һ��Ĭ�ϵ� MimeMessage ����
			MimeMessage msg = new MimeMessage(session);
			// ���� from
			msg.setFrom(new InternetAddress(from));
			// ���� to
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// ���� subject
			msg.setSubject("��������");
			// ������Ϣ�岿��
			BodyPart msgBody = new MimeBodyPart();
			// ����ʼ�����
			msgBody.setText("�����ʼ�����");
			// ����һ���ಿ����Ϣ
			Multipart multi = new MimeMultipart();
			// �����ı���Ϣ����
			multi.addBodyPart(msgBody);
			// ����
			msgBody = new MimeBodyPart();
			String filename = "file.txt";
			DataSource source = new FileDataSource(filename);
			msgBody.setDataHandler(new DataHandler(source));
			msgBody.setFileName(filename);
			multi.addBodyPart(msgBody);
			
			// �����ʼ�
			msg.setContent(multi);
			Transport.send(msg);
			
			out.println("<h1>���͵����ʼ��ɹ�</h1>");
		} catch(MessagingException e) {
			e.printStackTrace();
		}
	}
}
