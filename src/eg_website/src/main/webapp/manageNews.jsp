<%-- 
    Document   : manageNews
    Created on : 24-Sep-2015, 14:02:22
    Author     : Babak
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.NewsStore"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Manage News</title>

        <%@include file="/includes/scripts.jsp" %>

    </head>

    <body>
        <div id="wrapper">
            <div id="page-wrapper">
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Add, Edit & Delete News</h1>
                            <ol class="breadcrumb">
                                <li>
                                    <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                                </li>
                                <li class="active">
                                    <i class="fa fa-edit"></i> Edit News Pages
                                </li>
                            </ol>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form">
                                <div class="form-group">
                                    
                                    <input type="submit" value="Add News" class="button" id="addNewsButton">
                                    
                                    <label>Current News Pages</label>
                                    <% 
                                        ArrayList<NewsStore> alNews = new ArrayList();
                                        alNews = (ArrayList<NewsStore>) request.getAttribute("news");
                                        Iterator i1 = alNews.iterator();

                                        while (i1.hasNext()) {
                                            NewsStore ns = (NewsStore) i1.next();
                                    %>
                                    <div class="newsItem">
                                        <p><a href="/eg_website/<%=ns.getContent().getContentPath()%>"><%=ns.getContent().getContentTitle()%></a></p>
                                        <div class="newsContent">
                                            <img src=<%=ns.getNewsImage()%> ></img>
                                            <p><%=ns.getContent().getContentSummary()%></p>
                                        </div>
                                        <input type="submit" value="Edit News" class="button" id="editNewsButton">
                                        <input type="submit" value="Delete News" class="button" id="deleteNewsButton">
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </form>
                        </div>                        
                    </div>
                </div>
            </div>
        </div>
        <!-- jQuery -->
        <script src="js/jquery.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
