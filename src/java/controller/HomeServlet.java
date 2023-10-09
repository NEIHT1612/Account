/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Account;

/**
 *
 * @author PC
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //goi doi tuong dao
        AccountDAO dao = new AccountDAO();
        //goi list trong dao
        List<Account> list = dao.allList();
        //set attribute
        request.setAttribute("list", list);
        //gan jsp
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //goi value
        String value = request.getParameter("value");
        //goi dao
        AccountDAO dao = new AccountDAO();
        switch (value) {
            case "search":
                String tukhoa = request.getParameter("tukhoa");
//                List<Account> listSearch = dao.getListByTuKhoa(tukhoa);
//                request.setAttribute("list", listSearch);
                break;
            case "add":
                addFunction(request, response);
                break;
            case "delete":
                deleteFunction(request, response);
                break;
            case "update":
                updateFunction(request, response);
                break;
        }
//        request.getRequestDispatcher("display.jsp").forward(request, response);
        response.sendRedirect("home");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addFunction(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountDAO dao = new AccountDAO();
//        dao.insert(username, password);
    }

    private void deleteFunction(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        AccountDAO dao = new AccountDAO();
//        dao.delete(id);
    }

    private void updateFunction(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = new Account(id, username, password);
        AccountDAO dao = new AccountDAO();
//        dao.update(account);
    }

}
