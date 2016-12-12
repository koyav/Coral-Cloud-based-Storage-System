import com.sun.xml.registry.common.tools.bindings_v3.Command;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
@WebServlet(name = "upload", urlPatterns = {"/upload"})
public class upload extends HttpServlet {

    private String ip1, ip2, Enc_fil, Key_Fil;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List fileItemsList = null;
        float filesize = 0;
        String _fileLink;
        String _fileName = null;
        String _uploadDir = getServletContext().getRealPath("//images/");
        HttpSession session = request.getSession(true);
        System.out.println("attv:" + session.getAttribute("mail"));
        String direc = (String) session.getAttribute("des");
        String ques = (String) session.getAttribute("ques");
        String ans = (String) session.getAttribute("ans");//email
        String email = (String) session.getAttribute("email");
        String locip = InetAddress.getLocalHost().getHostAddress().toString();
          double st=System.currentTimeMillis();
        try {
            if (ServletFileUpload.isMultipartContent(request)) {
                ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
                try {
                    fileItemsList = servletFileUpload.parseRequest(request);
                } catch (FileUploadException ex) {
                    Logger.getLogger(upload.class.getName()).log(Level.SEVERE, null, ex);
                    //Change above line replace FileUploadExample with your file name
                }
                String optionalFileName = "", des = "", tags = "",mail="",storage="",uname="",mode="";
                FileItem fileItem = null;
                int bytesRead, current = 0;
                Iterator it = fileItemsList.iterator();
                while (it.hasNext()) {
                    FileItem fileItemTemp = (FileItem) it.next();
                    if (fileItemTemp.isFormField()) {
                        if (fileItemTemp.getFieldName().equals("myFile")) {
                            optionalFileName = fileItemTemp.getString();
                        }
                        if (fileItemTemp.getFieldName().equals("des")) {
                            des = fileItemTemp.getString();
                        }
                        if (fileItemTemp.getFieldName().equals("tag")) {
                            tags = fileItemTemp.getString();
                        }
                          if (fileItemTemp.getFieldName().equals("mail")) {
                            mail = fileItemTemp.getString();
                        }
                          
                          if (fileItemTemp.getFieldName().equals("stor")) {
                            storage = fileItemTemp.getString();
                        }
                           if (fileItemTemp.getFieldName().equals("uname")) {
                            uname = fileItemTemp.getString();
                        }
                             if (fileItemTemp.getFieldName().equals("mode")) {
                            mode = fileItemTemp.getString();
                        }

                    } else {
                        fileItem = fileItemTemp;
                    }
                }
                out.println("fn==>" + fileItem.getName());

                if (fileItem != null) {
                    long size_long = fileItem.getSize();
                    filesize = size_long / 1024;
                    filesize = filesize / 1000;
                    System.out.println("size:" + fileItem.getSize());

                    if (filesize > 3000.0) {
                    } else {
                        _fileName = fileItem.getName();
                        if (fileItem.getSize() > 0) {
                            if (optionalFileName.trim().equals("")) {
                                _fileName = FilenameUtils.getName(_fileName);
                            } else {
                                _fileName = optionalFileName;
                            }
                            _fileLink = "//images//" + _fileName;
                            try {

                                String relativePath = getServletContext().getRealPath("");
                                System.out.println("relativePath = " + relativePath);
                                relativePath = relativePath.replace("build", "");
                                String path = relativePath.trim() + "\\server\\";
                                File file = new File(path + fileItem.getName());
                                //out.println(path + "===>fnz:" + fileItem.getName() + filesize + "==deec==>" + des);
                                if(mode.equalsIgnoreCase("read"))
                                {
                                 file.setReadOnly();
                                }else if(mode.equalsIgnoreCase("write"))
                                {
                                 file.setWritable(true);
                                }
                                    
                                fileItem.write(file);
                       
                               double end=System.currentTimeMillis();
                               double cpu=(end-st);
                           double mtime= Runtime.getRuntime().freeMemory(); 
                           double atime= Runtime.getRuntime().totalMemory()/mtime;
                           mtime=mtime/24.0;
                        
                           double size = (double) filesize;
                                double fz=(size/(1024*1024));
                                  String data=file.getName()+","+mode+","+fz+"MB,"+cpu+","+mtime+","+atime+"\n";
                                int res = DOA_Service.insertLink(uname, mail, file.getName(), fz, storage, des, tags);
                                DOA_Service.addUserInCloud(file.getAbsolutePath());
                                  DOA_Service.addMettaDB(data);
                request.setAttribute("uname", uname);
                request.setAttribute("mail", mail);
                request.setAttribute("storage", storage);
                   String ippaddr = InetAddress.getLocalHost().getHostAddress().toString();
             int port=request.getServerPort();
                 Commanmsg cm=new Commanmsg();
                 String dat="upload:"+file.getName()+"#"+fz+"#"+uname;
                  cm.msgtoserverAuth(dat, ippaddr,port);
                                RequestDispatcher dispatcher1 = request.getRequestDispatcher("LoadDataLink.jsp");
                                dispatcher1.forward(request, response);
                                

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
//               setNotification _sN = new setNotification();
//               _sN.setError("File Uploaded to : " + _fileLink + "");
//               session.setAttribute("error", _sN);
                        }
                    }
                }
                // String referer = request.getHeader("Referer");
//           RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
//              session.setAttribute("usermail", email);
//           dispatcher.forward(request, response);
            }
            /* TODO output your page here
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Servlet upload</title>");  
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Servlet upload at " + request.getContextPath () + "</h1>");
             out.println("</body>");
             out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
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
    }// </editor-fold>
}
