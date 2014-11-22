package com.theservice.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * Servlet implementation class MyFirstServelet
 */
@WebServlet("/MyFirstServelet")
public class MyFirstServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		out.println("<HTMAL> <head> Simple Service Website</head>");
		out.println("<body><h1>Contents</h1>");
		out.println("<ul><LI>Name "+request.getParameter("name"));
		out.println("<ul><LI>Nickname"+request.getParameter("nick"));
		out.println("</UI></table></tr>");
		Connect bb = new Connect();
		ArrayList<Book>ll = bb.getAllBooks();
		for (Iterator iterator = (Iterator) ll.iterator(); iterator.hasNext();) {
			Book book = (Book) iterator.next();
			out.println("<td>"+book.toString()+"</td>");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("</body></html>");
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
