package com.theservice.servelets;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Connect {
	public Connection getConnection()
	{
		try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trail","root","password");
			return connection;
			}
			catch (Exception ex)
				{   
				ex.printStackTrace();
				}
		
				return null;
			}
	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> blist = new ArrayList<Book>();
		try{
			Connection conn = getConnection();
			Statement statement =conn.createStatement();
			ResultSet rs = statement.executeQuery("Select * from trail.books;");
			while(rs.next())
			{
				Book bk =new Book();
				bk.setTitle(rs.getString(1));
				bk.setAuthor(rs.getString(2));
				bk.setPublisher(rs.getString(3));
				bk.setTopic(rs.getString(4));
				bk.setComment(rs.getString(5));
				bk.setPrice(rs.getDouble(6));
				System.out.println("RECORD IS " + bk.toString()+ "\n");
				blist.add(bk);
					
			}
			statement.close();
			conn.close();
		}catch (Exception ex)
		{ex.printStackTrace();}
		return blist;
		
	}
	}


