import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Display3")
public class Display3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Display3() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		
		Statement st;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=Tpg@1234");
		
			ArrayList al=null;
			ArrayList userList =new ArrayList();
			String query = "select id,name,department,password from users";
			
			st = conn.createStatement();
			ResultSet  rs = st.executeQuery(query);


			while(rs.next())
			{
				al  = new ArrayList();
				al.add(rs.getInt(1));
				al.add(rs.getString(2));
				al.add(rs.getString(3));
				al.add(rs.getString(4));
				userList.add(al);
			}

			request.setAttribute("userList",userList);
			
			RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/home1.jsp");
			dispatcher1.forward(request,response);
			
			conn.close();
			
		} catch (Exception e) {
		e.printStackTrace();
		} 
	}
}