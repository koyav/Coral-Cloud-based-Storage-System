
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

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            boolean res = DOA_Service.login(uname, pwd);
            String ippaddr = InetAddress.getLocalHost().getHostAddress().toString();
            int port = request.getServerPort();

            if (res == true) {
                String email = DOA_Service.getEmail(uname, pwd);
                String storage = DOA_Service.getStorage(uname, pwd);
                request.setAttribute("uname", uname);
                request.setAttribute("mail", email);
                request.setAttribute("storage", storage);
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("LoadDataLink.jsp");
                dispatcher1.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid Login");
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("Login.jsp");
                dispatcher2.forward(request, response);
            }
            try {
               
            } finally {
                out.close();
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
