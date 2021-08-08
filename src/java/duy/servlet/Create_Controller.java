/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.servlet;

import duy.dao.Product_DAO;
import duy.dto.ProductError_dto;
import duy.dto.Product_DTO;
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
@WebServlet(name = "Create_Controller", urlPatterns = {"/Create_Controller"})
public class Create_Controller extends HttpServlet {

    private final static String FAIL = "createproduct.jsp";
    private final static String SUCCESS = "admin.jsp";

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
            String productID = request.getParameter("txtproductid");
            String productName = request.getParameter("txtproductname");
            String prices = request.getParameter("txtprices");
            String quantity = request.getParameter("txtquantity");
            ProductError_dto error = new ProductError_dto(productID, productName, prices, quantity);
            Product_DAO dao = new Product_DAO();
            
            boolean flag = true;
            if (productID != null && (productID.length() < 2 || productID.length() > 10)) {
                error.setProductID_ERROR("ProductID must be [2-10]");
                flag = false;
            }
            if (productName != null && (productName.length() < 2 || productName.length() > 20)) {
                error.setProductName_ERROR("ProductName must be [2-20]");
                flag = false;
            }
            if (prices != null && (prices.length() <0 || prices.length() > 20)) {
                error.setPrices_ERROR("Prices must be > 3 digit");
                flag = false;
            }
            if (quantity != null && (quantity.length() < 0|| quantity.length() > 20)) {
                error.setQuantity_ERROR("Quantity must be bigger than 1 digit");
                flag = false;
            }
            
            boolean check = dao.checkdupplicate(productID);
            if (check) {
                error.setProductID_ERROR("Dupplicate ProductID!!");
                flag = false;
            }
            request.setAttribute("ERROR", error);
            if (flag) {
                Product_DTO product = new Product_DTO(productID, productName, Integer.parseInt(quantity), Integer.parseInt(prices));
                dao.insertproduct(product);
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
