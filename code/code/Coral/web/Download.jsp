

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

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
        <script type="text/javascript">
            $('.dwn').click(function() {
    $('#dwnlnk').submit();
});
        </script>
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

                <nav>
                     <ul class="sf-menu" id="nav">
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
                      
                        <form id="dwnlnk" action="DownloadFileServlet" method="get">
                         
                    <table border="0">
                        <thead>
                            <tr>
                                <th> Name</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                           
                            <tr>
                              
                                <td><a  href="DownloadFileServlet?filename=fourcountry.rar" > fourcountry.rar</a></td>
                                  
                            </tr>
                           
                        </tbody></table></form></center>


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
