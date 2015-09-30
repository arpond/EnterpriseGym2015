<%-- 
    Document   : news
    Created on : 21-Sep-2015, 13:56:22
    Author     : Andrew Pond
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>

<!DOCTYPE html>
<html lang="en">
    <%
        NewsStore ns = (NewsStore) request.getAttribute("news");
        DateTime postedTime = ns.getPostedTime();
        DateTime displayTime = ns.getDisplayTime();
        String newsImage = ns.getNewsImage();
        String newsCategory = ns.getCategoryName();
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <title>News</title>
    </head>

    <style>
        .table-user-information > tbody > tr {
            border-top: 1px solid rgb(221, 221, 221);
        }
        .table-user-information > tbody > tr:first-child {
            border-top: 0;
        }
        .table-user-information > tbody > tr > td {
            border-top: 0;
        }
    </style>

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>

        <div class="container">

            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><%=ns.getContent().getContentTitle()%>
                        <small>by <a href="#">Enterprise Gym</a>
                        </small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active"><%=ns.getContent().getContentTitle()%></li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8">
                    <%
                        out.println(ns.getContent().getContent());
                    %>
                </div>

                <div class="col-md-4">
                    <div class="container" style="max-width:360px; max-height:600px; text-align:center;"> 
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <center><h3 class="panel-title"><%=ns.getContent().getContentTitle()%></h3></center>
                            </div>
                            <div class="panel-body">
                                <table class=" table table-user-information">             
                                    <%
                                        if (newsImage != "") {
                                    %>
                                    <img src="<%=newsImage%>" style="max-height:300px; max-width:300px;">
                                    <%
                                        }
                                    %>

                                </table>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>
        </div>

    </body>

    <footer>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </footer>
</html>
