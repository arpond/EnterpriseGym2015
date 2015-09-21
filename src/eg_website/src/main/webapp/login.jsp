<%-- 
    Document   : login.jsp
    Created on : Sep 28, 2014, 12:04:14 PM
    Author     : Kat & Will
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />

    </head>
    <body>
        <div id="big_wrapper">
            <header id="top_header">
          
            </header>
            <nav id="top_menu">
               <ul>            
                   <li><a class="menu_links" href="/Instagrim">Home</a></li>
                    <li><a class="menu_links" href="/Instagrim/upload.jsp">Upload</a></li>
                        <%

                            UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
                            if (ud != null) {
                                String UserName = ud.getUsername();
                        %>
                    <li><a class="menu_links" href="/Instagrim/Images/<%=ud.getUsername()%>">Your Images</a></li>
                    <li><a class="menu_links" href="/Instagrim/logout.jsp">Logout</a></li>
                    <li><a class="menu_links" href="/Instagrim/editprofile.jsp">Edit Profile</a></li>
                    <li><a class="menu_links" href="/Instagrim/search.jsp">Search Profile</a></li>
                        <%
                        } else {
                        %>
                    <li><a class="menu_links" href="/Instagrim/register.jsp">Register</a></li>
                    <li><a class="menu_links" href="/Instagrim/login.jsp">Login</a></li>
                        <%
                    }%>
                </ul>
            </nav>

            <div id="main_wrapper">
                <section id="main_section">

                    <article>
                        <h3>Login</h3>
                        <form method="POST"  action="Login" id="login">
                            <div class="left">
                                <ul>
                                    <li><label class="input">User Name</label> <input type="text" name="username"></li>
                                    <li><label class="input">Password</label> <input type="password" name="password"></li>
                                </ul>
                            </div>
                            <div class="right"><input type="submit" value="Login" class="button" id="loginButton"></div>
                        </form>
                    </article> 


                </section>    
            </div> 
            <footer id="bot_footer">
                <ul>
                    <li class="footer"><a href="/Instagrim">Home</a></li>
                </ul>
            </footer>
        </div>
    </body>
</html>