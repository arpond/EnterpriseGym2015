<%-- 
    Document   : adminIndex
    Created on : 23-Sep-2015, 13:51:29
    Author     : Katerina
--%>
<html lang="en">
<head>
    <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
    <title>Admin Home</title>
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
                            Admin Home
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="/2015-indteam7/Admin">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-desktop"></i> Admin Home
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-sm-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/addContent">Add new content</a></h3>
                            </div>
                            <div class="panel-body">
                                Add new content page.
                            </div>
                        </div>
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/ContentOptions">Manage existing content</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit existing content
                            </div>
                        </div>
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/deleteContent">Delete Content</a></h3>
                            </div>
                            <div class="panel-body">
                                Remove content pages.
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-3 -->
                    <div class="col-sm-3">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/addNews">Add News</a></h3>
                            </div>
                            <div class="panel-body">
                                Add a new piece of news.
                            </div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/NewsOptions">Manage News</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit a piece of news
                            </div>
                        </div>
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/deleteNews">Delete News</a></h3>
                            </div>
                            <div class="panel-body">
                                Delete a piece of News
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-3 -->
                    <div class="col-sm-3">
                        <div class="panel panel-warning">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/addEvent">Add event</a></h3>
                            </div>
                            <div class="panel-body">
                                Add a new event
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/EventOptions">Edit an event</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit an existing event.
                            </div>
                        </div>
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/deleteEvent">Delete Event</a></h3>
                            </div>
                            <div class="panel-body">
                                Delete an event.
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-3 -->
                    <div class="col-sm-3">
                        <div class="panel panel-warning">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/manageUsers">Manage Users</a></h3>
                            </div>
                            <div class="panel-body">
                                Add a new event
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/manageUsers">Manage Users</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit an existing event.
                            </div>
                        </div>
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/2015-indteam7/Admin/manageGroups">Manage Groups</a></h3>
                            </div>
                            <div class="panel-body">
                                Delete an event.
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>

</html>

