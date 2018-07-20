package com.geekxia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFile extends HttpServlet {
	public UploadFile() {
		super();
	}
	// ָ���ϴ�Ŀ¼
	private static final String UPLOAD_DIR = "upload";
	
	// �ϴ�����
	private static final int MEMORY_THRESHOLD = 1024*1024*3;
	private static final int MAX_FILE_SIZE = 1024*1024*40;
	private static final int MAX_REQUEST_SIZE = 1024*1024*50;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		// ����ǲ��Ƕ�ý���ϴ�
		if (!ServletFileUpload.isMultipartContent(req)) {			
			out.println("��������� enctype=multipart/form-data");
			out.flush();
			return;
		}
		// �����ϴ�����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		upload.setHeaderEncoding("UTF-8");
		
		String uploadPath = req.getServletContext().getRealPath("./")+File.separator + UPLOAD_DIR;
		
		// ���Ŀ¼�����ڣ��ʹ���Ŀ¼
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			List<FileItem> formItems = upload.parseRequest(req);
			if(formItems != null && formItems.size() > 0) {
				// ����������
				for (FileItem item: formItems) {
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
//						out.println(filePath);
						
						// �����ļ���Ӳ��
						item.write(storeFile);
						req.setAttribute("message", "�ļ��ϴ��ɹ�");
					}
				}
			}
		} catch (Exception e) {
			req.setAttribute("message", "������Ϣ��"+e.getMessage());
		}
//		out.println("<p>�ϴ��ɹ�</p>");
		// ��ת����ҳ��
		req.getServletContext().getRequestDispatcher("./success.html").forward(req, res);
	}
	
}
