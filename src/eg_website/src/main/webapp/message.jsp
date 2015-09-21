<%-- 
    Document   : message
    Created on : 09-Oct-2014, 11:30:07
    Author     : Andrew
--%>
<html>
    <body>
     
        <article>
            <br/>
            <p>
            <%
              String message = (String) request.getAttribute("message");
              out.print(message);
            %>
            </p>
            <p>You will be redirected to the index in 5 seconds... or return to the <a href="/Instagrim-arp/">index</a></p>
        </article>
      
    </body>
</html>
