

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DownloadFileServlet", urlPatterns = {"/DownloadFileServlet"})
public class DownloadFileServlet extends HttpServlet {
 public static Date end, start;
    public static int current = 0, fz, i = 0,t=0;
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            
            String relativePath = getServletContext().getRealPath("");
            System.out.println("relativePath = " + relativePath);
            relativePath = relativePath.replace("build", "");
            String path = relativePath.trim() + "\\server\\";
            String fn=request.getParameter("filename");
            String filePath = path + fn;
            File downloadFile = new File(filePath);
            FileInputStream inStream = new FileInputStream(downloadFile);
            System.out.println("relativePath = " + relativePath);
            ServletContext context = getServletContext();
           
            String mimeType = context.getMimeType(filePath);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            System.out.println("MIME type: " + mimeType);
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());
         
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            
            OutputStream outStream = response.getOutputStream();
            start = java.util.Calendar.getInstance().getTime();
            Random r=new Random();
            int pak=r.nextInt(100000);
            byte[] buffer = new byte[pak];
            int bytesRead = -1;
            int c = 0;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
                c++;
            }
            int rate = c * 2;
           
            end = java.util.Calendar.getInstance().getTime();
            String totime = String.valueOf(end.getTime() - start.getTime());
            long totsize = downloadFile.length() / (1024 * 1024);
            String cutdat = dateFormat.format(date);
            int getdwnld=DOA_Service.getid();
            t=t+getdwnld;
            DOA_Service.insertLinkdetails(totime,String.valueOf(t), "/s","$"+rate, totsize, cutdat);
            inStream.close();
            outStream.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DownloadFileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DownloadFileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
