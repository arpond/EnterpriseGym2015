<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <%@include file="/WEB-INF/includes/scripts.jsp" %> 

        <title>Register</title>
    </head> 

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Register

                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active">Register</li>
                    </ol>
                </div>
            </div>   
        </div>

        <div class="container" style="border:20px transparent; max-width:600px">

            <form class="registerForm" method="POST"  action="View" >
                <div class="form-group">
                    <ul>
                        <label for="input">Username </label>
                        <input type="text" class="form-control" name="username" data-validate="required">

                        <label for="input">Password </label>
                        <input type="password1" class="form-control" name="password" data-validate="required,matching#first">

                        <label for="input">Password</label>
                        <input type="password2" class="form-control" name="verification" data-validate="required,matching#second">

                        <label for="input">Email</label>
                        <input type="text" class="form-control" name="email" data-validate="required,email">

                    </ul>
                    <button type="submit" id="updateButton" class="btn btn-default" style="display:block;margin: 0 auto;" value="Register" name="action">Register</button> 
                </div>
            </form>
        </div>  
    </body>

    <footer>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %> 
    </footer>
</html>