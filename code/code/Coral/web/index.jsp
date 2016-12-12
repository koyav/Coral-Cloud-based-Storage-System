

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
<head>
  <title></title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
   <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
   <link href="website/css/amp-demos.css" rel="stylesheet" type="text/css" />

	<!-- Acorn Media Player specific -->
	<link href="acornmediaplayer/acornmediaplayer.base.css" rel="stylesheet" type="text/css">
	<!-- Themes -->
	<link href="acornmediaplayer/themes/access/acorn.access.css" rel="stylesheet" type="text/css">
	<link href="acornmediaplayer/themes/darkglass/acorn.darkglass.css" rel="stylesheet" type="text/css">
	<link href="acornmediaplayer/themes/barebones/acorn.barebones.css" rel="stylesheet" type="text/css">
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
		 <link href="css/lightbox.css" rel="stylesheet" type="text/css" />
                 <script src="js/lightbox.js"></script>
                 <style type="text/css">
                     fieldset  {
   width: 260px;
   background-color: #BCBCBC;


}
legend
{

    color: #ff0000;
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

      <nav>
     
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

          <div style="padding-left: 250px">      <form action="Login" method="post">
         <fieldset> <legend>Login</legend>  <table >

                  <tr>
                      <td> Email : </td>
                      <td><input type="text" name="uname" value="" /><span style="color: red">*</span> </td>
                  </tr>
                  <tr>
                      <td>Password:</td>
                      <td><input type="password" name="pwd" value="" /><span style="color: red">*</span></td>
                  </tr>
              <tr>
                      <td></td>
                      <td><input type="submit"  value="Login" />&nbsp;&nbsp;<input type="reset"  value="clear" /></td>
                  </tr>
                  
              
                  </table></fieldset>
                  </form>
              <div>  Not a Member? &nbsp;&nbsp;&nbsp;<a href="Register.jsp">Register</a>&nbsp;&nbsp;&nbsp; Here </div>
          </div>

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
  <script src="jquery/jquery.min.js"></script>
	<script src="jquery/jquery-ui-1.10.0.custom.min.js"></script>

	<script src="acornmediaplayer/jquery.acornmediaplayer.js"></script>

	


	<script>var _gaq=[['_setAccount','UA-19824700-1'],['_trackPageview']];(function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];g.src='//www.google-analytics.com/ga.js';s.parentNode.insertBefore(g,s)}(document,'script'))</script>

</body>
</html>

