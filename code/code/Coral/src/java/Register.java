


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Register", urlPatterns={"/Register"})
public class Register extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String uname = request.getParameter("uname");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String pwd = request.getParameter("pwd");
            String storage=request.getParameter("stor");
            String dbnc=request.getParameter("dbcN");
            int res = DOA_Service.insertUser(uname, pwd, email, dob, storage, dbnc);
             String ippaddr = InetAddress.getLocalHost().getHostAddress().toString();
             int port=request.getServerPort();
            if (res > 0) {
                 
                if(storage.equalsIgnoreCase("5")){
                request.setAttribute("msg", "Register Successfully");
                }
                else if(storage.equalsIgnoreCase("10")){
                     request.setAttribute("msg", "Register Successfully and Debited your Account into S30");
                }
                 else if(storage.equalsIgnoreCase("30")){
                     request.setAttribute("msg", "Register Successfully and Debited your Account into S50");
                }
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("Login.jsp");
                dispatcher2.forward(request, response);
            } else {
                request.setAttribute("msg", "TryAgain");
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("Register.jsp");
                dispatcher2.forward(request, response);
            }
            try {
              
            } finally {
                out.close();
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
