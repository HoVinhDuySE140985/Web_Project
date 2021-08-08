/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.servlet;

import duy.dao.Cart_DAO;
import duy.dao.Order_DAO;
import duy.dao.Orderdetail_DAO;
import duy.dao.Product_DAO;
import duy.dto.Order_DTO;
import duy.dto.Orderdetail_DTO;
import duy.dto.ProductCart;
import duy.dto.User_DTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
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
@WebServlet(name = "Confirm_Controller", urlPatterns = {"/Confirm_Controller"})
public class Confirm_Controller extends HttpServlet {

    private final static String SUCCESS = "sucessconfirm.jsp";
    private final static String FAIL = "error.jsp";

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
            // khai bao
            Order_DAO dao = new Order_DAO();
            Orderdetail_DAO odDao = new Orderdetail_DAO();
            HttpSession session = request.getSession();
            ArrayList<Orderdetail_DTO> listo = new ArrayList<>();
            Cart_DAO cart = (Cart_DAO) session.getAttribute("CART");
            Product_DAO pDao = new Product_DAO();
            Set<String> key = (Set<String>) cart.keySet();
            //lay bien ve
            String name = request.getParameter("txtName");
            String phonenumbers = request.getParameter("txtSDT");
            String address = request.getParameter("txtAdd");
            String payment = request.getParameter("txtP");
            String totalPrice = request.getParameter("txtTPrice");
            double tPrice = 0;
            try {
                tPrice = Double.parseDouble(totalPrice);
            } catch (Exception e) {
            }
            String oderID = (dao.getOrderId() + 1) + "";
            User_DTO uID = (User_DTO) session.getAttribute("LOGIN_USER");
            String userID = uID.getUsername();
            // add vao order
            Order_DTO odDto = new Order_DTO(oderID, userID, name, "", address, payment, tPrice, phonenumbers);
            if (dao.addOrder(odDto)) {
                // add oderdetail
                for (String proID : key) {
                    ProductCart pc = (ProductCart) cart.get(proID);
                    listo.add(new Orderdetail_DTO((odDao.getOrderId()+ 1) + "", oderID, proID.trim(), pc.quantity * pc.prodto.getPrice(), pc.quantity));
                    pDao.updateProductQuantity(proID,pDao.getproID(proID).getQuantity()- pc.quantity);
                }

                for (Orderdetail_DTO od : listo) {
                    odDao.addOrderDetail(od);
                }
                session.removeAttribute("CART");
                url = SUCCESS;
            }
        } catch (Exception e) {
        } finally {
            response.sendRedirect(url);
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
