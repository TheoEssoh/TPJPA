package servlet;

import dao.*;
import jpa.EntityManagerHelper;
import jpa.business.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Servlet implementation class DB
 */

@WebServlet(name="Servlet_BD_Insert",
        urlPatterns={"/Servlet_BD_Insert"})
public class Servlet_BD_Insert extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Date sqlDate = null;
    final String formatDate = "yyyy-MM-dd";
    private EntityManager em = EntityManagerHelper.getEntityManager();
    private int nb;

    private UserDaoImpl userDao = new UserDaoImpl();
    ;
    private TagDaoImpl tagDao = new TagDaoImpl();
    private SectionDaoImpl sectionDao = new SectionDaoImpl();
    private KanbanBoardDaoImpl kanbanBoardDao = new KanbanBoardDaoImpl();
    private CardUserDaoImpl cardUserDao = new CardUserDaoImpl();
    private CardDaoImpl cardDao = new CardDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Results";

        out.println("<html>\n" +
                "<head><title>" + title + " </title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + " </h1>\n");


        List<KanbanBoard> kanbanBoards = kanbanBoardDao.findAll();
        for (KanbanBoard user : kanbanBoards) {
            out.println("||KanbanBoard Name:  " + user.getName() + "|| <br>");
        }


        List<Section> sections = sectionDao.findAll();
        for (Section section : sections) {
            out.println("||Section label:  " + section.getLabel() + "||<br>");
        }


        List<Card> cards = cardDao.findAll();
        for (Card card : cards) {
            out.println("||Card label :  " + card.getLabel() + "||Card deadline :  " + card.getDeadline() +
                    "||Card time to do :" + card.getTimeToDo() + "||Card url :" + card.getUrl() + "||Card note :" +
                    card.getNote() + "||Card location :" + card.getLocation() + "|| <br>");
        }


        List<Tag> tags = tagDao.findAll();
        for (Tag tag : tags) {
            out.println("||Tag level :  " + tag.getLevel() + "||Tag AvailabilityLevel :  " + tag.getAvailabilityLevel() +
                    "||Tag label :" + tag.getLabel() + "||tag Boards :" + tag.getBoards() + "|| <br>");
        }


        List<CardUser> cardUsers = cardUserDao.findAll();
        for (CardUser cardUser : cardUsers) {
            out.println("||CardUser attributionDate :  " + cardUser.getAttributionDate() + "||CardUser withdrawalDate :  " + cardUser.getWithdrawalDate() +
                    "||CardUser beginDate :" + cardUser.getBeginDate() + "||CardUser endDate :" + cardUser.getEndDate() + "|| <br>");
        }


        List<User> users = userDao.findAll();
        for (User user : users) {
            out.println("||User Name:  " + user.getName() + "||User Email:  " + user.getEmail() + "||<br>");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        kanbanBoardDao.save(new KanbanBoard(request.getParameter("kanbanBoardName")));


        sectionDao.save(new Section(request.getParameter("sectionLabel")));


        cardDao.save(new Card(request.getParameter("cardLabel"), dateParser(request.getParameter("deadline")),
                dateParser(request.getParameter("timeToDo")), request.getParameter("url"), request.getParameter("note"),
                request.getParameter("location")));


        tagDao.save(new Tag(request.getParameter("level"), request.getParameter("AvailabilityLevel"),
                request.getParameter("Taglabel"), intParser(request.getParameter("Boards"))));


        cardUserDao.save(new CardUser(dateParser(request.getParameter("attributionDate")),
                dateParser(request.getParameter("withdrawalDate")), dateParser(request.getParameter("beginDate")),
                dateParser(request.getParameter("endDate"))));


        userDao.save(new User(request.getParameter("userName"), request.getParameter("email")));


        doGet(request, response);


    }

    public Date dateParser(String sql) {

        if (sql.equals("")) {
            sqlDate = new Date(new java.util.Date().getTime());
        } else {

            SimpleDateFormat format = new SimpleDateFormat(formatDate);
            try {

                java.util.Date dat = format.parse(sql);
                sqlDate = new java.sql.Date(dat.getTime());

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }


        return sqlDate;
    }

    private int intParser(String s) {
        if (s.equals("")) {
            nb = 0;
        } else {
            nb = Integer.parseInt(s);
        }

        return nb;


    }
}


