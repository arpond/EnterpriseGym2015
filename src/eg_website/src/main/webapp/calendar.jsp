<%-- 
    Document   : displayProfile
    Created on : 21-Sep-2015, 15:55:36
    Author     : Katerina
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <script src="/eg_website/js/ZabutoCalendar/zabuto_calendar.js"></script>
        <title>Profile</title>

    </head>
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
       <link rel="stylesheet" type="text/css" href="css/zabuto_calendar.min.css">

<div id="my-calendar"></div>

<script type="application/javascript">
    var params = getUrlVars('date=2015-12-31&badge=true&title=Tonight&body=<p>hi</p>&footer=ok');
console.log(params);

function getUrlVars(url) {
    var hash;
    var myJson = {};
    var hashes = url.slice(url.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        myJson[hash[0]] = hash[1];
    }
    return myJson;
}
</script>

<script type="application/javascript">
  $(document).ready(function () {
    $("#my-calendar").zabuto_calendar({
      ajax: {
          url: "myJson",
          modal: true
      }
    });
  });
</script>

        
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>
