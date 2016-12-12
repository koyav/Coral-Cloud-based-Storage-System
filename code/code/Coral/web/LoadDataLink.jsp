
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title></title>
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
        <style type="text/css">
            fieldset  {
                width: 260px;
                background-color: #BCBCBC;


            }
            legend
            {

                color: firebrick;
                font-weight: bolder;
                top: auto; left: auto;
            }
        </style>
    </head>

    <body>
        <div id="main">
            <header>
                <div id="logo">
                    <div id="logo_text">
                        <!-- class="logo_colour", allows you to change the colour of the text -->
                        <h3>Coral:<span class="logo_colour"> a cloud based file system</span></h3>
                    </div>
                </div>

                <%
                    try {
                        String email = request.getAttribute("mail").toString();
                        String uname = request.getAttribute("uname").toString();
                        String storage = request.getAttribute("storage").toString();
                %>

                <nav>
                    <ul class="sf-menu" id="nav">

                        <li class="selected"><a href="Downloadlink.jsp?mail=<%=email%>">View</a></li>
                        <li class="selected"><a href="Login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </header>

            <div id="site_content">
                <div class="gallery">
                    <ul class="images">
                        <li class="show"><img width="900" height="300" src="images/1.jpg" alt="photo_one" /></li>
                        <li><img width="900" height="300" src="images/2.jpg" alt="seascape" /></li>
                        <li><img width="900" height="300" src="images/3.jpg" alt="seascape" /></li>

                    </ul>
                </div>

                <div class="content">
                    <center>
                        <%
                       if (storage.equalsIgnoreCase("5")) { %>
                        <p style="color: gold"> You have Total Memory of 5GB Free Storage </p>       
                        <% } else if (storage.equalsIgnoreCase("10")) { %>
                        <p style="color: darkmagenta"> You have Total Memory of 10GB Free Storage </p>       
                        <% } else if (storage.equalsIgnoreCase("30")) { %>
                        <p style="color: #09D4FF"> You have Total Memory of 30GB Free Storage </p>       
                        <% }
                        %>
                        <fieldset> <legend>upload Links</legend>
                            <form method="post" action="upload"   enctype="multipart/form-data">
                                <fieldset style="color: #ffffff;border: none">
                                    <p>File:<input type="file" name="myFile"/></p>
                                    <p>File Description:<input type="text" name="des"/></p>                                   
                                   
                                    <p> Tags:<input type="text" name="tag"/></p>
                                     <p><input type="hidden" name="mail" value="<%=email%>"/></p>
                                    <p><input type="hidden" name="uname" value="<%=uname%>"/></p>
                                    <p><input type="hidden" name="stor" value="<%=storage%>"/></p>
                                            <p><select name="mode">
                                                    <option value="">mode</option>
                                                    <option value="read">Read Only</option>
                                                    <option value="write">Write Only</option>
                                                    <option value="read_write">Read and Write Only</option>
                                        </select></p>
                                    <input type="submit" value="Submit"   class="button" /></fieldset>
                            </form></fieldset></center>
                            <%

                                String error = request.getAttribute("msg").toString();
                                if (error == null || error == "null") {
                                    error = "";
                                }

                            %>
                    <span style="background-color: #FF0000;color: white;"><%=error%></span>
                    <%
                        } catch (Exception ex) {
                        }%>
                </div>
            </div>
            <footer>
                <p> </p>
            </footer>
        </div>
        <p>&nbsp;</p>
        <!-- javascript at the bottom for fast page loading -->
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
        <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
        <script type="text/javascript" src="js/image_fade.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('ul.sf-menu').sooperfish();
            });
        </script>
    </body>
</html>
