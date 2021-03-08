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
import java.util.List;


/**
 * Servlet implementation class
 */

@WebServlet(name="Servlet_BD_Display",
        urlPatterns={"/Servlet_BD_Display"})
public class Servlet_BD_Display extends HttpServlet {

    private UserDaoImpl userDao;
    private TagDaoImpl tagDao;
    private SectionDaoImpl sectionDao;
    private KanbanBoardDaoImpl kanbanBoardDao;
    private CardUserDaoImpl cardUserDao;
    private CardDaoImpl cardDao;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Results";

        out.println("<html>\n" +
                "<head><title>" + title + " </title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + " </h1>\n");


        kanbanBoardDao = new KanbanBoardDaoImpl();
        List<KanbanBoard> kanbanBoards = kanbanBoardDao.findAll();
        for (KanbanBoard user : kanbanBoards) {
            out.println("||KanbanBoard Name:  " + user.getName() +"|| <br>");
        }

        sectionDao = new SectionDaoImpl();
        List<Section> sections = sectionDao.findAll();
        for (Section section : sections) {
            out.println("||Section label:  " + section.getLabel() +"||<br>");
        }

        cardDao= new CardDaoImpl() ;
        List<Card> cards = cardDao.findAll();
        for (Card card : cards) {
            out.println("||Card label :  " + card.getLabel() +"||Card deadline :  "+ card.getDeadline()+
                    "||Card time to do :"+ card.getTimeToDo()+"||Card url :"+card.getUrl()+"||Card note :"+
                    card.getNote()+ "||Card location :"+card.getLocation()+"|| <br>");
        }

        tagDao = new TagDaoImpl();
        List<Tag> tags = tagDao.findAll();
        for (Tag tag : tags) {
            out.println("||Tag level :  " + tag.getLevel() +"||Tag AvailabilityLevel :  "+ tag.getAvailabilityLevel()+
                    "||Tag label :"+ tag.getLabel()+"||tag Boards :"+tag.getBoards()+"|| <br>");
        }


        cardUserDao= new CardUserDaoImpl();
        List<CardUser> cardUsers = cardUserDao.findAll();
        for (CardUser cardUser : cardUsers) {
            out.println("||CardUser attributionDate :  " + cardUser.getAttributionDate() +"||CardUser withdrawalDate :  "+ cardUser.getWithdrawalDate()+
                    "||CardUser beginDate :"+ cardUser.getBeginDate()+"||CardUser endDate :"+cardUser.getEndDate()+"|| <br>");
        }

        userDao = new UserDaoImpl();
        List<User> users = userDao.findAll();
        for (User user : users) {
            out.println("||User Name:  " + user.getName() +"||User Email:  "+ user.getEmail()+"||<br>");
        }

    }
}






