import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Statement;



@WebServlet("/UpdateData1")
public class UpdateData1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateData1() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("id");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String password = request.getParameter("password");
		
		int id = Integer.parseInt(Id);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=Tpg@1234");
			String query = "UPDATE users SET name='"+name+"',department='"+department+"',password='"+password+"' WHERE id="+id;
			PreparedStatement ps = con.prepareStatement(query);
			int count = ps.executeUpdate();
			
			if(count!=0){
				//out.println("<h1>data updated successfully</h1>");
				response.sendRedirect("http://localhost:8080/First/Display4");
			}
			else{
				System.out.println("<h2> Failed </h1>");
			}
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


}
