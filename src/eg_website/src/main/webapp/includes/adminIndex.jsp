<%-- 
    Document   : adminIndex
    Created on : 23-Sep-2015, 13:51:29
    Author     : Katerina
--%>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
  <%@include file="/includes/adminHeader.jsp" %>
  
    <title>Admin Home</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
 

</head>

<body>

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
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-desktop"></i> Admin Home
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-sm-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">Add new pages</a></h3>
                            </div>
                            <div class="panel-body">
                                Add pages and content.
                            </div>
                        </div>
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">Manage an event</a></h3>
                            </div>
                            <div class="panel-body">
                                Add, edit or delete an event and its content.
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-4 -->
                    <div class="col-sm-4">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">View users</a></h3>
                            </div>
                            <div class="panel-body">
                                Select users and see their details.
                            </div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">Manage Users</a></h3>
                            </div>
                            <div class="panel-body">
                                Add, Edit & Delete Users
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-4 -->
                    <div class="col-sm-4">
                        <div class="panel panel-warning">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">Manage Groups</a></h3>
                            </div>
                            <div class="panel-body">
                                Add, Edit & Delete Groups
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">Edit or delete a page</a></h3>
                            </div>
                            <div class="panel-body">
                                Edit or delete a page content.
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-4 -->
                    <div class="col-sm-4">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">Manage points</a></h3>
                            </div>
                            <div class="panel-body">
                                Add, edit or delete points.
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-4 -->
                    <div class="col-sm-4">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">View & sort partipants</a></h3>
                            </div>
                            <div class="panel-body">
                                View partipants by degree, college or country.
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-4 -->
                    <div class="col-sm-4">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="index.html">Add new pages</a></h3>
                            </div>
                            <div class="panel-body">
                                Charts on blah blah.
                            </div>
                        </div>
                    </div>
                    <!-- /.col-sm-4 -->
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

