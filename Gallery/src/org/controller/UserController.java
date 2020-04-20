package org.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.dao.PhotosDAO;
import org.dao.UsersDAO;
import org.entity.Photos;
import org.entity.Users;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = "C:\\Users\\Varun Yadav\\eclipse-workspace\\Hibernate\\Gallery\\photos\\";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		switch (action) {
		case "home":
			home(request,response);
			break;
			
		case "upload":
			upload(request,response);
			break;
			
		case "edit":
			edit(request,response);
			break;
			
		case "view":
			view(request,response);
			break;
			
		case "logout":
			request.getSession().invalidate();
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;

		default:
			error(request,response);
			break;
		}
		
	}
	
	public void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String photo = new PhotosDAO().getPhoto(id);
		
		request.getSession().setAttribute("photoPath", path+photo);
		System.out.println(path+photo);
		
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("title", "Edit");
		request.getRequestDispatcher("edit.jsp").forward(request, response);
		
		
		
	}

	public void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("title", "Upload");
		request.getRequestDispatcher("upload.jsp").forward(request, response);
	}

	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}

	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Users user = (Users) request.getSession().getAttribute("user");
		
		List<Photos> photos = new PhotosDAO().getPhotos(user.getUserName());
		
		request.getSession().setAttribute("photos", photos);
		
		request.getRequestDispatcher("memberArea.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		switch (action) {
		case "signUp":
			signUp(request,response);
			break;
			
		case "login":
			login(request,response);
			break;

		case "uploadOperation":
			uploadOperation(request, response);
			break;
			
		case "updateOperation":
			updateOperation(request,response);
			break;
			
		default:
			error(request, response);
			break;
		}
	}
	
	public void updateOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String label = request.getParameter("label");
		String caption = request.getParameter("caption");
		String user = request.getParameter("user");

		
		new PhotosDAO().update(id,label,caption);
		
		List<Photos> photos = new PhotosDAO().getPhotos(user);
		
		request.getSession().setAttribute("photos", photos);
		
		request.getRequestDispatcher("edit.jsp").forward(request, response);
		
	}

	public void uploadOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> images = upload.parseRequest(request);
			String username = request.getParameter("username");
			System.out.println("Size of File Item is "+images.size());
			for(int i=0;i<(images.size());i++)
			{
				String name = images.get(i).getName();
				
				try {
					name = name.substring(name.lastIndexOf("\\") + 1);} catch (Exception e) {}
				System.out.println("File Name is "+name);
				System.out.println("User name is "+username);
				File file = new File(path+name);
				if(!(file.exists()))
				{
					new PhotosDAO().add(new Photos(username, name));
					
					images.get(i).write(file);
					
				}
			}
			
			List<Photos> photos = new PhotosDAO().getPhotos(username);
			request.getSession().setAttribute("photos", photos);
			
			request.getRequestDispatcher("memberArea.jsp").forward(request, response);
			

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		Users user =  new UsersDAO().getUsers(username);
		if(user!=null)
		{
			if(password.equals(user.getPassword()))
			{
				request.getSession().invalidate();
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				session.setAttribute("path", path);
				List<Photos> photos = new PhotosDAO().getPhotos(username);
				System.out.println(photos.size());
				
				
				session.setAttribute("photos", photos);
				
				request.getSession().setAttribute("title", "Home");
				
				request.getRequestDispatcher("memberArea.jsp").forward(request, response);
				//response.sendRedirect("memberArea.jsp");
			}
			
			else
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		else
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	public void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String dob = request.getParameter("dob");
		
		Users user = new Users(username, password, firstName, lastName, dob);
		new UsersDAO().createUser(user);
		
		request.getSession().invalidate();
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("user", user);
		session.setAttribute("path", path);
		List<Photos> photos = new PhotosDAO().getPhotos(username);
		System.out.println(photos.size());
		
		
		session.setAttribute("photos", photos);
		
		request.getSession().setAttribute("title", "Home");
		
		response.sendRedirect("memberArea.jsp");
		
		
		
	}

}
