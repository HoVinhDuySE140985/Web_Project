/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.servlet;

import duy.dao.Product_DAO;
import duy.dto.Product_DTO;
import duy.dto.User_DTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author くろくん
 */
@WebServlet(name = "Search_Controller", urlPatterns = {"/Search_Controller"})
public class Search_Controller extends HttpServlet {

    private static final String SEARCH = "admin.jsp";
    private static final String SEARCHRESULT1 = "admin.jsp";
    private static final String SEARCHRESULT2 = "shopping_user.jsp";

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
        String url = SEARCH;
        try {
            String searchvalues = request.getParameter("txtsearch");
            if (searchvalues != null) {
                Product_DAO pro_Dao = new Product_DAO();
                List<Product_DTO> list = pro_Dao.getListProduct(searchvalues);
                HttpSession session = request.getSession();
                User_DTO dto = (User_DTO) session.getAttribute("LOGIN_USER");

                if (list != null) {
                    request.setAttribute("SEARCHRESULTS", list);
                    if (dto.getRole().equalsIgnoreCase("AD")) {
                        url = SEARCHRESULT1;
                    }
                    else {
                        url = SEARCHRESULT2;
                    }
                }
            }
        } catch (SQLException e) {
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
