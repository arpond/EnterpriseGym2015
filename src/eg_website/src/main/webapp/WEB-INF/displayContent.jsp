<%-- 
    Document   : displayContent.jsp
    Created on : 21-Sep-2015, 12:37:34
    Author     : Katerina
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%  ContentStore cs = (ContentStore) request.getAttribute("content");
        String contentInfo = cs.getContent();
        String contentTitle = cs.getContentTitle();%>
 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <title><%=contentTitle%></title>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
    </head>
    
    <body>
        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header"><%=contentTitle%></h2>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active"><%=contentTitle%></li>
                    </ol>
                </div>
            </div>   
        </div>
      
           <div class="kat" style="margin-left:auto; margin-right:auto; max-width:900px;"> 
               
                  <br><p>The Enterprise Gym, is managed by students for students and supported by our experienced business patrons, 
                  runs free workshops and events to develop your enterprise skills and commercial awareness. Being able to 
                  demonstrate that you have some enterprising attributes is great whether you are applying for jobs 
                  or thinking of starting your own enterprise. Key transferable skills can really help make you stand out.</p>
                  
                  <br><p>The Enterprise Gym was created by the University of Dundee in 2005 in response to government 
                 concern over graduate "business readiness". Its mission is to help students from all disciplines 
                 to improve their enterprise skills, self-reliance and employability through engaging with business 
                 enterprise and developing entrepreneurial skills. Key to this is the deep involvement and support of the business
                 community helping to deliver learning that is fun, interactive and rewarding.</p>
              
                 
                  <br><p><%out.println(contentInfo);%></p>
             </div>     
    </body>
    
    <footer>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </footer>
</html>
