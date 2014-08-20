import java.io.*;
import java.sql.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteData1")
public class deleteData1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public deleteData1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=Tpg@1234");
			String query = "delete from users where id="+id;
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);
			if(i>0){
				//response.sendRedirect("./home3.jsp");
				response.sendRedirect("http://localhost:8080/First/Display3");
			}
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}