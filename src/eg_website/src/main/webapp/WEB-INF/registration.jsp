<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>

    </head>
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <div id="big_wrapper">
           
         
            <div id="main_wrapper">
                <section id="main_section">

                        <article>
                        <h3>Register</h3>
                        <form method="POST"  action="Register" id="register">
                            <ul>
                                <br><label class="input">User Name </label> <input type="text" name="username" data-validate="required,divisibleByThree"></br>
                                <br><label class="input">Password</label> <input type="password" name="password" data-validate="required,matching#first"></br>
                                <br><label class="input">Password</label> <input type="password" name="verification" data-validate="required,matching#second"></br>
                                <br><label class="input">email</label> <input type="text" name="email" data-validate="required,email"></br>
                            </ul>
                            <br/>
                            <input type="submit" value="Register" class="button" id="registerButton"> 
                        </form>
                        </article> 
                    </section>    
            </div> 
         
        </div>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>
