package servlet;

import jpa.business.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


/**
 * Servlet implementation class DB
 */

@WebServlet(name="Servlet_BD_Display",
        urlPatterns={"/Servlet_BD_Display"})
public class Servlet_BD_Display extends HttpServlet {
    private static final long serialVersionUID = 1L;

    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/mydatabase?serverTimezone=UTC";
    // Database credentials
    final String USER = "root";
    final String PASS = "";

    //connexion à la base de données
    Connection connection = null;
    // Execute SQL query
    Statement statement = null;
    // results
    ResultSet result = null;

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>LastName: "
                + request.getParameter("lastname") + "\n" +
                " <LI>FirstName: "
                + request.getParameter("firstname") + "\n" +
                " <LI>Email: "
                + request.getParameter("email") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");

        String title = "Database Results";

        out.println("<html>\n" +
                "<head><title>" + title + " </title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + " </h1>\n");
/*
        addUser(new User(request.getParameter("lastname"),
                request.getParameter("firstname"),
                request.getParameter("email")));*/
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Results";

        out.println("<html>\n" +
                "<head><title>" + title + " </title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + " </h1>\n");
        try{

            loadDataBase();
            // Execute SQL query
            Statement stmt = connection.createStatement();
            String sql;
            //sql = "SELECT id, first, last, age FROM Employees";
            sql = "SELECT email, name, lastName FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String email = rs.getString("email");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                //Display values
                out.println(" Email:  " + email );
                out.println(", FirstName:  " + firstName );
                out.println(", LastName:  " + lastName + "<br>");
            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            connection.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }


    private void loadDataBase() {
        //chargement du driver
        try {
            Class.forName(JDBC_DRIVER);

        } catch (ClassNotFoundException e) {
        }
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
