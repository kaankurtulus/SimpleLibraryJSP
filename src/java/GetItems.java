/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Conn.DB;
import DAO.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class GetItems extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        int offset;
	int length;
	List list;
        String category;
        String search;
        HttpSession httpSession;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        httpSession = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        if(httpSession.getAttribute("User")==null){
            request.setAttribute("message", "Your session has ended");
            request.setAttribute("check", "wrong");

            rd = getServletContext().getRequestDispatcher("/login.jsp");
            //rd.forward(request, response);
        }
        int maxEntriesPerPage = 6;
        int page = 1;
        String pageNumberValue = request.getParameter("p");
        category = request.getParameter("c");
        search = request.getParameter("q");
        if (pageNumberValue != null) {
                try {
                        page = Integer.parseInt(pageNumberValue);
                        System.out.println("Page Number:" + page);
                } catch (NumberFormatException e) {
                        e.printStackTrace();
                }
        }
        int offset = maxEntriesPerPage * (page - 1);
        TestList(offset, maxEntriesPerPage);

        httpSession.setAttribute("pages", getPages());
        httpSession.setAttribute("bookDetail", getListByOffsetAndLength());
        rd.forward(request, response);
    }
    	public void fillList() {
            System.out.print("fill list");
                DB db = new DB();
                if(search!=null){
                    System.out.print(search);
                    list=db.GetBookList(search);
                }else{
                    if(category!=null)
                        list=db.GetBookList(Integer.parseInt(category));
                    else
                        list = db.GetBookList();
                }
	}
	/**
	 * @param offset
	 * @param length
	 */
	public void TestList(int offset, int length) {
            
		this.offset = offset;
		this.length = length;
		fillList();
	}
	/**
	 * @return List
	 */
	public ArrayList getListByOffsetAndLength() {
            
		ArrayList arrayList = new ArrayList();
		int to = this.offset + this.length;
		if (this.offset > list.size())
			this.offset = list.size();
		if (to > list.size())
			to = list.size();
		for (int i = this.offset; i < to; i++) {
			arrayList.add(list.get(i));
		}
		return arrayList;
	}
	/**
	 * @return List with page numbers
	 */
	public List getPages() {
            
		List pageNumbers = new ArrayList();
		int pages = list.size() / this.length;
		if (list.size() % this.length != 0) {
			pages = pages + 1;
		}

		for (int i = 1; i <= pages; i++) {
			pageNumbers.add(new Integer(i));
		}
		return pageNumbers;
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
