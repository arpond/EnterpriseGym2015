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
                                <i class="fa fa-dashboard"></i>  <a href="/eg_website/Admin">Dashboard</a>
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
                                <h3 class="panel-title"><a href="/eg_website/Admin/addContent">Add new content</a></h3>
                            </div>
                            <div class="panel-body">
                                Add new content page.
                            </div>
                        </div>
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/eg_website/Admin/ContentOptions">Manage existing content</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit existing content
                            </div>
                        </div>
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/eg_website/Admin/deleteContent">Delete Content</a></h3>
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
                                <h3 class="panel-title"><a href="/eg_website/Admin/addNews">Add News</a></h3>
                            </div>
                            <div class="panel-body">
                                Add a new piece of news.
                            </div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/eg_website/Admin/NewsOptions">Manage News</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit a piece of news
                            </div>
                        </div>
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/eg_website/Admin/deleteNews">Delete News</a></h3>
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
                                <h3 class="panel-title"><a href="/eg_website/Admin/Calendar">Add event</a></h3>
                            </div>
                            <div class="panel-body">
                                Add a new event
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/eg_website/Admin/EventOptions">Edit an event</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit an existing event.
                            </div>
                        </div>
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/eg_website/Admin/deleteEvent">Delete Event</a></h3>
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
                                <h3 class="panel-title"><a href="/eg_website/Admin/manageUsers">Manage Users</a></h3>
                            </div>
                            <div class="panel-body">
                                Add a new event
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/eg_website/Admin/manageUsers">Manage Users</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit an existing event.
                            </div>
                        </div>
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/eg_website/Admin/manageGroups">Manage Groups</a></h3>
                            </div>
                            <div class="panel-body">
                                Delete an event.
                            </div>
                        </div>
                    </div>
                </div>

                <div class="page-header">
                    <h1>Charts</h1>
                </div>
                <div class="row">
                    <!-- /.col-sm-4 -->
                    <div class="col-sm-4">
                        <div class="list-group">
                            <a href="#" class="list-group-item active">
                                <h4 class="list-group-item-heading">Groups</h4>
                                <p class="list-group-item-text">Infomation. Information. Information.Infomation. Information. Information.</p>
                            </a>
                            <a href="#" class="list-group-item">
                                <h4 class="list-group-item-heading">Students</h4>
                                <p class="list-group-item-text">Infomation. Information. Information.Infomation. Information. Information.</p>
                            </a>
                            <a href="#" class="list-group-item">
                                <h4 class="list-group-item-heading">Admin</h4>
                                <p class="list-group-item-text">Infomation. Information. Information.Infomation. Information. Information.</p>
                            </a>
                        </div>
                    </div>
                    <!-- /.col-sm-4 -->
                    <!-- /.col-sm-4 -->
                    <div class="col-sm-4">
                        <div class="list-group">
                            <a href="#" class="list-group-item active">Charts</a>
                            <a href="#" class="list-group-item">View partipants by country</a>
                            <a href="#" class="list-group-item">View partipants by subject</a>
                            <a href="#" class="list-group-item">View partipants by college</a>
                            <a href="#" class="list-group-item">View partipants by age</a>
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

