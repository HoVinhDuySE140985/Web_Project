/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.servlet;

import duy.dao.User_DAO;
import duy.dto.UserError_DTO;
import duy.dto.User_DTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author くろくん
 */
@WebServlet(name = "CreateUser_Controller", urlPatterns = {"/CreateUser_Controller"})
public class CreateUser_Controller extends HttpServlet {

    private final static String FAIL = "create_user.jsp";
    private final static String SUCCESS = "login.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAIL;
        try {
            String userName = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");
            String fullName = request.getParameter("txtfullname");
            String role = request.getParameter("txtrole");
            UserError_DTO error1 = new UserError_DTO(userName, password, fullName, role);
            User_DAO dao = new User_DAO();
            boolean flag = true;
            if (userName != null && (userName.length() < 2 || userName.length() > 30)) {
                error1.setUsernameError("UserName must be [2-50]");
                flag = false;
            }
            if (!userName.matches("^[a-zA-Z ]*$")) {
                error1.setUsernameError("UserName sai");
                flag = false;
            }
            if (password != null && (password.length() < 6)) {
                error1.setPasswordError("PassWord must be more than 6 digit");
                flag = false;
            }
            if (fullName != null && (fullName.length() < 2 || fullName.length() > 20)) {
                error1.setFullnameError("FullName must be [2-20]");
                flag = false;
            }
            if (role != null && (role.length() < 2 || role.length() > 6)) {
                error1.setRoleError("Role must be [2-6]");
                flag = false;
            }
            boolean check = dao.checkDupplicateusers(userName);
            if (check) {
                error1.setUsernameError("Dupplicate UserName!!!");
                flag = false;
            }
            request.setAttribute("DARA", error1);

            if (flag) {
                User_DTO user = new User_DTO(userName, password, fullName, role);
                dao.insertUser(user);
                url = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
