/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Conn.DB;
import DAO.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author k_kur
 */
public class Save extends HttpServlet {

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
        String book = request.getParameter("bookid");
        String type = request.getParameter("type");
        String referer = request.getHeader("Referer");
        HttpSession httpSession = request.getSession();
        System.out.print("ref"+referer);
        RequestDispatcher rd;
        if(book!=null&&type!=null&&httpSession.getAttribute("User")!=null&&referer!=null){
            User usr = (User)httpSession.getAttribute("User");
            int bID = Integer.parseInt(book);
            DB db = new DB();
            book = db.GetBookByID(bID);
            System.out.print("book:"+book);
            if(type.equals("r")){
                //check if user have it
                System.out.print("added R");
                db.SaveBook((int) httpSession.getAttribute("Id"), bID, "u_read");
                request.setAttribute("added", "yes");
                usr.SetReadList(bID, book);
            }else if(type.equals("w")){
                //check if user have it
                System.out.print("added W");
                request.setAttribute("added", "yes");
                db.SaveBook((int) httpSession.getAttribute("Id"), bID, "u_willread");
                usr.SetWillList(bID, book);
            }else{
                response.sendRedirect(request.getHeader("referer"));
            }
            httpSession.setAttribute("User",usr);
        }

        rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
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
