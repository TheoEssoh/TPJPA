package servlet;

import jpa.business.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


/**
 * Servlet implementation class
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
            //sql = "SELECT data FROM tables";
            sql = "SELECT name,email FROM user";
            String sqlK = "SELECT name FROM kanbanBoard";
            String sqlS = "SELECT label FROM section";
            String sqlC = "SELECT label,deadline,timeToDo,url,note,location FROM card";
            String sqlT = "SELECT level,AvailabilityLevel,label,Boards FROM tag";
            String sqlCU = "SELECT attributionDate,withdrawalDate,beginDate,endDate FROM cardUser";


            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String email = rs.getString("email");
                String name = rs.getString("name");


                //Display values
                out.println(" Email:  " + email + "|");
                out.println(" FirstName:  " + name +"|<br>" );



            }

            out.println(" <br>" );

            ResultSet rsK = stmt.executeQuery(sqlK);

            while (rsK.next()){
                String kanbanBoardName = rsK.getString("name");
                //Display values
                out.println("| KanbanBoard name:  " + kanbanBoardName +"|<br>");
            }

            out.println(" <br>" );

            ResultSet rsS = stmt.executeQuery(sqlS);

            while (rsS.next()){
                String sectionLabel = rsS.getString("label");
                //Display values
                out.println("| Section label:  " + sectionLabel +"|<br>");
            }
            out.println(" <br>" );

            ResultSet rsC = stmt.executeQuery(sqlC);

            while (rsC.next()){
                String cardLabel = rsC.getString("label");
                Date cardDeadline = rsC.getDate("deadline");
                Date cardTimeTodo = rsC.getDate("timeToDo");
                String cardUrl = rsC.getString("url");
                String cardNote = rsC.getString("note");
                String cardLocation = rsC.getString("location");
                //Display values
                out.println("| Card label:  " + cardLabel +"|");
                out.println(" Card deadline:  " + cardDeadline +"|");
                out.println(" Card time to do:  " + cardTimeTodo +"|");
                out.println(" Card url:  " + cardUrl +"|");
                out.println(" Card note:  " + cardNote +"|");
                out.println(" Card location:  " + cardLocation +"|<br>");
            }

            out.println(" <br>" );

            ResultSet rsT = stmt.executeQuery(sqlT);

            while (rsT.next()){
                String tagLevel = rsT.getString("level");
                String tagAvailabilityLevel = rsT.getString("AvailabilityLevel");
                String tagLabel = rsT.getString("label");
                int tagBoards = rsT.getInt("Boards");
                //Display values
                out.println("| Tag level:  " + tagLevel +"|");
                out.println(" Tag Availability Level:  " + tagAvailabilityLevel +"|");
                out.println(" Tag label :  " + tagLabel +"|");
                out.println(" Tag Boards:  " + tagBoards +"|<br>");

            }

            out.println(" <br>" );

            ResultSet rsCU = stmt.executeQuery(sqlCU);

            while (rsCU.next()){
                Date cardUserAttributionDate = rsCU.getDate("attributionDate");
                Date cardUserWithdrawalDate = rsCU.getDate("withdrawalDate");
                Date cardUserBeginDate = rsCU.getDate("beginDate");
                Date cardUserEndDate = rsCU.getDate("endDate");
                //Display values
                out.println("| Date attribution card:  " + cardUserAttributionDate +"|");
                out.println(" Date Withdrawal :  " + cardUserWithdrawalDate +"|");
                out.println(" Date Begin :  " + cardUserBeginDate +"|");
                out.println(" Date End:  " + cardUserEndDate +"|<br>");

            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            /*rsK.close();
            rsS.close();
            rsT.close();
            rsC.close();
            rsCU.close();*/
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
