<%-- 
    Document   : displayProfile
    Created on : 21-Sep-2015, 15:55:36
    Author     : Katerina
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.UserProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%  UserProfile userp = (UserProfile) request.getAttribute("profile");
        String firstName = userp.getFirstName();
        String lastName = userp.getLastName();
        String mobile = userp.getMobile();
        String contactNumber = userp.getContactNumber();
        String studyYear = userp.getYearOfStudy();
        String matricNo = userp.getMatricNumber();
        String country = userp.getCountry();
        String institution = userp.getInstitution();
        String status = userp.getStatus();
        String college = userp.getCollege();
        String degree = userp.getDegree();

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <title>Profile</title>
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

    </head>
    <body>

        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>

        <% HashMap points = ud.getPoints();

        %>

        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Your Profile

                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active">View Profile</li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class ="col-md-5">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title"><%=firstName%> <%=lastName%></h3>
                    </div>
                    <div class="panel-body">


                        <table class=" table table-user-information">
                            <tr>
                                <td>First Name</td>
                                <td><%=firstName%></td>
                            </tr>
                            <tr>
                                <td>Last Name</td>
                                <td><%=lastName%></td>
                            </tr>
                            <tr>
                                <td>Mobile</td>
                                <td><%=mobile%></td>
                            </tr>
                            <tr>
                                <td>Contact Number</td>
                                <td><%=contactNumber%></td>
                            </tr>
                            <tr>
                                <td>Year of Study</td>
                                <td><%=studyYear%></td>
                            </tr>
                            <tr>
                                <td>Matriculation Number</td>
                                <td><%=matricNo%></td>
                            </tr>
                            <tr>
                                <td>Country</td>
                                <td><%=country%></td>
                            </tr>
                            <tr>
                                <td>Status</td>
                                <td><%=status%></td>
                            </tr>

                            <tr>
                                <td>Institution</td>
                                <td><%=institution%></td>
                            </tr>
                            <tr>
                                <td>School</td>
                                <td><%=college%></td>
                            </tr>
                            <tr>
                                <td>Degree</td>
                                <td><%=degree%></td>
                            </tr>
                        </table>



                    </div>
                </div>
                </div>
                <div class="col-md-7">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">Your Points</h3>
                    </div>
                    <div class="panel-body">

                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <tr>
                                    <th>
                                        Points Type
                                    </th>
                                    <th>
                                        Points Earned
                                    </th>
                                    <th>
                                        Progress
                                    </th>
                                </tr>

                                <%
                                    Set set = points.entrySet();
                                    Iterator i = set.iterator();
                                    int numOfSilvers = 0;
                                    int totalPoints = 0;
                                    while (i.hasNext()) {
                                        Map.Entry me = (Map.Entry) i.next();

                                %>
                                <tr>
                                    <td><b><h5><%out.println(me.getKey());%>   </h5></b></td>
                                    <td>
                                        <h5> 
                                            <%out.println(me.getValue());%>
                                            <%
                                                float percentComplete = 0.0f;
                                                percentComplete = ((int) me.getValue() / 70.0f) * 100;
                                                if (percentComplete > 100) {
                                                    percentComplete = 100;
                                                }
                                                totalPoints += (int) me.getValue();
                                                if ((int) me.getValue() >= 70) {
                                                    numOfSilvers++;
                                            %>
                                            Silver Awarded
                                            <%
                                                }
                                            %>
                                        </h5>
                                    </td>
                                    <td width="40%">
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" aria-valuenow="<%=percentComplete%>"
                                                 aria-valuemin="0" aria-valuemax="100" style="width:<%=percentComplete%>%">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                <tr>
                                    <td>
                                        <h5>Total Points</h5>
                                    </td>
                                    <td>
                                        <h5>
                                            <%=totalPoints%>
                                            <%
                                                if (numOfSilvers >= 2) {
                                            %>
                                            Gold awarded
                                            <%
                                                }
                                            %>
                                        </h5>
                                    </td>
                                </tr>
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
