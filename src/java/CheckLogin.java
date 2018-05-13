import Conn.DB;
import DAO.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLogin extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
        String email = request.getParameter("email");
        request.setAttribute("emaill", email);
        String pwd = request.getParameter("pass");
        String remember = request.getParameter("remember-me");
        
        /*Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "root");
        
        PreparedStatement ps = con.prepareStatement("select * from users where email='"+email+"' and pass='"+pwd+"'");
        ResultSet rs = ps.executeQuery();*/
        RequestDispatcher rd;
        
        
        DB db = new DB();
        User user=db.GetUser(email, pwd);
        if(user.ID!=-1){
            if(remember!=null){
                
                Cookie cRemember = new Cookie("remember","true");
                //Cookie cEmail = new Cookie("email", email);
                //Cookie cPass = new Cookie("pass", pwd);
                String i = String.valueOf(user.ID);
                Cookie id = new Cookie("userID",i);
                cRemember.setMaxAge(60*60*24*15);
                id.setMaxAge(60*60*24*15);
                //cEmail.setMaxAge(60*60*24*15);
                //cPass.setMaxAge(60*60*24*15);
                response.addCookie(cRemember);
                //response.addCookie(cEmail);
                //response.addCookie(cPass);
                response.addCookie(id);

                //httpSession.setAttribute("email", rs.getString("email"));
                //httpSession.setAttribute("pass", rs.getString("pass"));
                

                //System.out.println("remember : " + remember+rs.getString("id"));
            }
            /*HttpSession httpSession = request.getSession();
            httpSession.setAttribute("User", user);
            httpSession.setAttribute("sessID", rs.getString("id"));
            httpSession.setAttribute("name", rs.getString("fullName"));
            httpSession.setAttribute("session", "yes");
            System.out.println("sessions");*/
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("User", user);
            httpSession.setAttribute("Id", user.ID);
            httpSession.setAttribute("session", "yes");
            response.sendRedirect("profile.jsp");

            //response.sendRedirect(request.getContextPath() + "/profile.jsp");
        }
        else{
            //redirect
            request.setAttribute("message", "Email or password is wrong.");
            request.setAttribute("check", "wrong");
            
            //System.out.print(email);
            rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
