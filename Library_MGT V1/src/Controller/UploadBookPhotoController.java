package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadBookPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;// 40 MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hi");
		// Configure upload setting
		
		HttpSession session= request.getSession(false);

		String message="";
		request.getSession();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		/*
		 * ServletFileUpload upload=new ServletFileUpload(factory);
		 */

		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		// Constructs the directory to store upload file
		String uploadpath=("E:\\J2EE\\Library_MGT V1\\WebContent\\images")+File.separator+UPLOAD_DIRECTORY;
		System.out.println(uploadpath);
		// create the directory if it does not exist
		File uploadDir = new File(uploadpath);
		if (!uploadDir.exists()) 
		{
			uploadDir.mkdir();
		}
		try 
		{
			// parses the requests content to extract the file data
			List formItems = upload.parseRequest(request);
			System.out.println(formItems.size());
			Iterator iter = formItems.iterator();
			// iterates over forms fields
			if (iter.hasNext())// while
			{

				FileItem item = (FileItem) iter.next();
				// processes only fields that are not form fields
				if (!item.isFormField())
				{

					//String FileName = new File(item.getName()).getName();
					String FileName=(String)session.getAttribute("BookName");
					
					System.out.println("updated file name:"+FileName);

					String Filepath = uploadpath + File.separator + FileName+".jpg";//uploadpath+File.seprator+userid+".jpg";

					File storeFile = new File(Filepath);
					System.out.println(FileName);
					// saves the file on disk
					item.write(storeFile);
				} else {
					System.out.println(item.getString());
					System.out.println(item.getString(item.getFieldName()));
				}

				System.out.println("upload done sucessfully");
				message="uploaded sucessfully";
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("error");
			message="error";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("bookphoto.jsp").forward(request, response);
	}

}
