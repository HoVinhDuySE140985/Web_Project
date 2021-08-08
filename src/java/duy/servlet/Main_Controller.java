/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.servlet;

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
@WebServlet(name = "Main_Controller", urlPatterns = {"/Main_Controller"})
public class Main_Controller extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN_CONTROLLER = "Login_Controller";
    private static final String SEARCH = "Search_Controller";
    private static final String UPDATEPRO = "Update_Controller";
    private static final String DELETEPRO = "Delete_Controller";
    private final static String CREATE = "Create_Controller";
    private final static String CREATEUSER = "CreateUser_Controller";
    private final static String LOGOUT = "Logout_Controller";
    private final static String ADDCART = "AddCart_Controller";
    private final static String REMOVECART = "RemoveCart_Controller";
    private final static String PAYYMENT = "Payment_Controller";
    private final static String CONFIRM = "Confirm_Controller";
    
    
    
    
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
        String url = ERROR;
        try {
            String button = request.getParameter("btaction");
            if("Login".equalsIgnoreCase(button)){
                url = LOGIN_CONTROLLER;
            }
            if("SEARCH".equalsIgnoreCase(button)){
                url = SEARCH;
            }
            if("DELETE".equalsIgnoreCase(button)){
                url = DELETEPRO;
            }
            if("UPDATE".equalsIgnoreCase(button)){
                url = UPDATEPRO;
            }
            if("Create".equalsIgnoreCase(button)){
                url = CREATE;
            }
            if("LOG_OUT".equalsIgnoreCase(button)){
                url = LOGOUT;
            }
            if("Create_Users".equalsIgnoreCase(button)){
                url = CREATEUSER;
            }
            if("ADD TO CART".equalsIgnoreCase(button)){
                url = ADDCART;
            }
            if("Remove".equalsIgnoreCase(button)){
                url = REMOVECART;
            }
            if("PayMent".equalsIgnoreCase(button)){
                url = PAYYMENT;
            }
            if("Confirm".equalsIgnoreCase(button)){
                url = CONFIRM;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
