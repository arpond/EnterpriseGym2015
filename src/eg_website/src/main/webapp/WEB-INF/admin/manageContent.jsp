<%-- 
    Document   : manageContent
    Created on : 23-Sep-2015, 15:02:22
    Author     : Katerina
--%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<html lang="en">

      <%  ContentStore con = (ContentStore) request.getAttribute("content");
        String conContent = con.getContent();
        String conTitle = con.getContentTitle();
        String conPath = con.getContentPath();
    %>
         
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Change a page</title>

    <%@include file="/WEB-INF/includes/adminScripts.jsp" %>

</head>

<body>
    <%@include file="/WEB-INF/includes/adminNav.jsp" %>
    <div id="wrapper">

        <div id="page-wrapper">
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Add, Edit & Delete content
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Edit Pages
                            </li>
                        </ol>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-6">

                        <form role="form">

                            <div class="form-group">
                                <label>Page Names</label>
                                <select multiple class="form-control">
                                    <option> <% out.println(conTitle); %> </option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>

                        </form>

                    </div>
                    <div class="col-lg-6">
                        
                            <div class="form-group">
                                <label>Page content</label>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Add
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Edit
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">Delete
                                    </label>
                                </div>
								     <button type="submit" class="btn btn-default">Submit Button</button>
                            </div>

							
							       <div class="form-group">
                                <label>Add content into the box</label>
                                <textarea class="form-control" rows="3"></textarea>
                            </div>

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
