<%-- 
    Document   : displayAllNews
    Created on : 22-Sep-2015, 10:43:14
    Author     : williamneal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All News</title>
        <%
            //Get arraylist here
            
            ArrayList<NewsStore> alNews = new ArrayList();
            Iterator i1 =  alNews.iterator();
            
            if(i1.hasNext() == true){
            System.out.println("Size of AL: " + alNews.size());
            System.out.println(/*news headline*/);
            //etc                                   
            i1.next();
            }
            else{
                System.out.println(i1);
            }
            
        }
        %>
    </head>
    <body>
    </body>
</html>
