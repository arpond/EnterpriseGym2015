<%-- 
    Document   : newHeader
    Created on : 22-Sep-2015, 11:55:09
    Author     : Katerina
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.UserDetails"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/eg_website">Enterprise Gym</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li> <a href="/eg_website/News">News</a> </li>
                <li> <a href="/eg_website/Content/About">About</a> </li>

                <li class="dropdown"> 
                    <a href="/eg_website/Event" class="dropdown-toggle" data-toggle="dropdown">Events <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li> <a href="/eg_website/Event/">View All Events</a> </li>
                        <li> <a href="/eg_website/Event/trainingWorkshops">The Enterprise Challenge and Training Workshops</a> </li>
                        <li> <a href="/eg_website/Event/bestSeries">Learn from the Best Series </a> </li>
                        <li> <a href="/eg_website/Event/sucessWorkshops">Training for Success Workshops</a> </li>
                        <li> <a href="/eg_website/Event/businessSurgeries">Business Surgeries</a> </li>
                        <li> <a href="/eg_website/Event/networking">Networking</a> </li>
                        <li> <a href="/eg_website/Event/bootCamp">Summer Boot Camp</a>  </li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Activity <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li> <a href="/eg_website/Event">Events</a> </li>
                        <li> <a href="/eg_website/Content/VirtualEnterprise">Virtual Enterprise</a> </li>
                        <li> <a href="/eg_website/Content/EnterpriseTheory">Enterprise Theory</a> </li>

                        <li> <a href="/eg_website/Content/Projects">Projects</a> </li>
                        <li> <a href="/eg_website/Content/EnterpriseModule">The Enterprise Module</a> </li>
                        <li>  <a href="/eg_website/Content/Mentoring">Mentoring</a> </li>
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
                        <li> <a href="faq.html">Entrepreneurial Interships</a> </li>
                        <li> <a href="404.html">Information & Website for Startups</a> </li>
                        <li> <a href="404.html">Competitions</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<nav>
    <%
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        if (ud != null) {
    %>              

    <div class="bar1" style="display: inline-block; text-align: right; width:100%; background-color:#800020; color:white; font-size:17px;">
        <a style="font-size:16px; color:white;" href="/eg_website/Profile/View">View Profile &nbsp; </a> | &nbsp; <a style="font-size:16px; color:white;" href="/eg_website/Profile/Edit">Edit Profile</a> &nbsp;| &nbsp; <a style="font-size:16px; color:white;" href="Logout">Logout &nbsp;</a> 
    </div>
    <%} else { %>
    <div class="bar1" style="display: inline-block; text-align:center; width:100%; background-color:#800020; color:white; font-size:14px;">
        <a style="font-size:18px; color:white;" href="/eg_website/Login">Login</a> or <a style="font-size:18px; color:white;" href="/eg_website/Register">Join Now</a>
        <% }%>
    </div>
</nav>
<br>   





