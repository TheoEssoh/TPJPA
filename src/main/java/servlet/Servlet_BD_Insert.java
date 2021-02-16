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

@WebServlet(name="Servlet_BD_Insert",
        urlPatterns={"/Servlet_BD_Insert"})
public class Servlet_BD_Insert extends HttpServlet {
    private static final long serialVersionUID = 1L;



    //connexion à la base de données
    Connection connection = null;
    // Execute SQL query
    Statement statement = null;
    // results
    ResultSet result = null;


    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/mydatabase?serverTimezone=UTC";
    // Database credentials
    final String USER = "root";
    final String PASS = "";


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
                "<h1 align=\"center\">" + title + " </h1>\n"
        + "<h3>Voir l'insertion: http://localhost:8080/Servlet_BD_Display</h3>");

        addUser(new User(request.getParameter("lastname"),
                request.getParameter("firstname"),
                request.getParameter("email")));
    }

    public void addUser(User user) {



        try {
            loadDataBase();
            String sql2 = "INSERT INTO user (lastName, firstName, email) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);

            preparedStatement.setString(1, user.getLastName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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


