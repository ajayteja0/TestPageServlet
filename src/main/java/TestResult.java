
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestResult extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		int i = Integer.parseInt(req.getParameter("q1"));
		int j = Integer.parseInt(req.getParameter("q2"));
		String s = req.getParameter("q3");
		String nam = req.getParameter("name");
		String clg = req.getParameter("clgname");
		String name = req.getParameter("q4");
		String s2="ram";
		String s1 = s.toLowerCase();
		System.out.println(s1);
		System.out.println(s);
		System.out.println(nam);
		System.out.println(clg);
		int total = 0;
		int marks;
		if(i==99)
		{
			total = total+5;
			
		}
		if(j==7956)
		{
			total = total+5;
		}
		if((s1.compareTo(s2)== 0))
		{
			total = total+5;
		}
		try {
		PrintWriter out = res.getWriter();
		out.println("HERE IS YOUR RESULT  "+total);
		out.println("<a href = 'record.java' > view all records</a>");
	    }
		catch(Exception e)
		{
			System.out.println("exception");
			
		}
		try {
			marks = total;
			System.out.println(marks);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("class is ok");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
			System.out.println("connected");
			Statement st = con.createStatement();
			PreparedStatement pr = con.prepareStatement("INSERT INTO results (name,marks) VALUES (' "+name+" ',' "+marks+" ')");
			pr.executeUpdate();
			System.out.println("succcess");
			
		}
			catch(Exception ex)
		{
			System.out.println("error:"+ex);
			
		}


}

}
