package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


/**
 * Servlet implementation class DB
 */

@WebServlet(name="Servlet_BD",
        urlPatterns={"/Servlet_BD"})
public class Servlet_BD extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // JDBC driver name and database URL
        final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
        final String DB_URL="jdbc:mysql://localhost/mydatabase?serverTimezone=UTC";
        // Database credentials
        final String USER = "root";
        final String PASS = "";
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Results";

        out.println("<html>\n" +
                "<head><title>" + title + " </title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + " </h1>\n");
        try{
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            //sql = "SELECT id, first, last, age FROM Employees";
            sql = "SELECT email, firstName, lastName FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                /*int id = rs.getInt("id");
                int age = rs.getInt("age");*/
                String email = rs.getString("email");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                //Display values
                //out.println("ID: " + id );
               // out.println(", Age: " + age );
                out.println(" Email:  " + email );
                out.println(", FirstName:  " + firstName );
                out.println(", LastName:  " + lastName + "<br>");
            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
