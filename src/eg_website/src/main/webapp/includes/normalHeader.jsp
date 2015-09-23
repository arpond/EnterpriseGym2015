<%-- 
    Document   : newHeader
    Created on : 22-Sep-2015, 11:55:09
    Author     : Katerina
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.UserDetails"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/modern-business.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  
</head>

<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
          
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Home</a>
            </div>
            
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li> <a href="news.html">News</a> </li>
                    <li> <a href="about.html">About</a> </li>
                   
                    <li class="dropdown"> 
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Events <b class="caret"></b></a>
                       <ul class="dropdown-menu">
                          <li> <a href="trainingWorkshops.html">The Enterprise Challenge and Training Workshops</a> </li>
                            <li> <a href="bestSeries.html">Learn from the Best Series </a> </li>
                            <li> <a href="sucessWorkshops.html">Training for Success Workshops</a> </li>
			    <li> <a href="businessSurgeries.html">Business Surgeries</a> </li>
			    <li> <a href="networking.html">Networking</a> </li>
			    <li> <a href="bootCamp.html">Summer Boot Camp</a>  </li>
                       </ul>
                    </li>
                    
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Activity <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li> <a href="events.html">Events</a> </li>
                            <li> <a href="virtualEnterprise.html">Virtual Enterprise</a> </li>
                            <li> <a href="enterpriseTheory.html">Enterprise Theory</a> </li>
			
                            <a href="projects.html">Projects</a> </li>
			<li> <a href="enterpriseModule.html">The Enterprise Module</a> </li>
			      <a href="mentoring.html">Mentoring</a> </li>
                        </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Trainers <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li> <a href="entrepreneurResident.html">Entrepreneur in Resident</a> </li>
                            <li> <a href="bestTrainers.html">Learn from the Best Trainer</a> </li>
                            <li> <a href="sucessMentors.html">Training for Success Mentors</a> </li>
			    <li> <a href="coaches.html">Coaches</a> </li>
                            <li> <a href="sponsors.html">Sponsors</a> </li>
                        </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Connect <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li> <a href="full-width.html">Associate Initiative</a> </li>
                            <li> <a href="sidebar.html">Associate Events</a> </li>
                            <li> <a href="faq.html">Funding for Startups</a> </li>
				 <a href="faq.html">Entrepreneurial Interships</a> </li>
                            <li> <a href="404.html">Information & Website for Startups</a> </li>
                            <li> <a href="404.html">Competitions</a> </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	
    <nav
	      <%
              UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
              if (ud != null) 
	      {
              %>    
		  <h1><a href="editprofile.jsp">Edit Profile</a> or <a href="Logout">Logout</a> </h1>
               
		  <%} 
		  else { %>
                 <h1> <a href="login.jsp">Login</a> or <a href="registration.jsp">Register</a> </h1>
		      <% }%>
    </nav>
	
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

    </body>
</html>