<%-- 
    Document   : updateProfile.jsp
    Created on : 23-Sep-2015, 09:39:03
    Author     : Andrew
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.StatusStore"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.CountryStore"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.CollegeStore"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.DegreeStore"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.InstitutionStore"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.UserProfile"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%  UserProfile up = (UserProfile) request.getAttribute("profile");
        ArrayList<InstitutionStore> is = (ArrayList<InstitutionStore>) request.getAttribute("institutions");
        ArrayList<CountryStore> cs = (ArrayList<CountryStore>) request.getAttribute("countries");
        ArrayList<StatusStore> sts = (ArrayList<StatusStore>) request.getAttribute("statuses");
        //UserDetails ud = (UserDetails) request.getAttribute("details");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/includes/scripts.jsp" %>

        <title>Update Profile</title>
        <style>
            ul {
                display: table;
            }
            li {
                display: table-row;
            }
            label, input {
                display: table-cell;
            }
            .hidden {display:none;}
        </style>
    </head> 

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %> 
        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Update Profile

                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active">Update Profile</li>
                    </ol>
                </div>
            </div>   
        </div>


        <div class="container" style="border:20px transparent; max-width:600px">

            <form class="updateForm" method="POST"  action="View" >
                <div class="form-group">
                   
                        <label for="input">First Name </label>
                        <input type="text" class="form-control" name="firstname" value="<%=up.getFirstName()%>" data-validate="required">

                        <label for="input">Last Name </label>
                        <input type="text" class="form-control" name="lastname" value="<%=up.getLastName()%>" data-validate="required">

                        <label for="input">Mobile</label>
                        <input type="text" class="form-control" name="mobile" value="<%=up.getMobile()%>" data-validate="required">

                        <label for="input">Contact Number</label>
                        <input type="text" class="form-control" name="contactNumber" value="<%=up.getContactNumber()%>">

                        <label for="input">Matric Number </label>
                        <input type="text" class="form-control" name="matricNumber" value="<%=up.getMatricNumber()%>" data-validate="required">

                        <label for="input">Email  </label>
                        <input type="text" class="form-control" name="email" value="<%=ud.getEmail()%>" data-validate="required,email">

                        <input type="hidden" class="form-control" name="owner" value="<%=ud.getUsername()%>" id="updateButton">
                        
                        <label for="input" class="input">Status</label>
                        <select name="status" class="form-control">
                            <%
                                for (int i = 0; i < sts.size(); i++) {
                                    StatusStore status = sts.get(i);
                            %>
                            <option value="<%=status.getStatusID()%>"><%=status.getStatusName()%></option>
                            <%}%>
                        </select>
                    
                        <label for="input" class="input">Country</label>
                        <select name="country" class="form-control">
                            <%
                                for (int i = 0; i < cs.size(); i++) {
                                    CountryStore country = cs.get(i);
                            %>
                            <option value="<%=country.getCountryID()%>"><%=country.getCountryName()%></option>
                            <%}%>
                        </select>

                        <label for="input" class='input'>Institution</label>
                        <select name='institution' id='instSelect' class="form-control">
                            <%
                                for (int i = 0; i < is.size(); i++) {
                                    InstitutionStore inst = is.get(i);
                            %>
                            <option value='<%=inst.getInstitutionID()%>'><%=inst.getInstitutionName()%></option>
                            <%
                                }
                            %>
                        </select>
                        <div id='colleges' class='hidden '>
                            <label for="input" class='input'>School</label>
                        
                            <select id='collegeSelector' name='collgeSelector' class="form-control">
                            </select>
                        </div>
                        <div id='degrees' class='hidden'>
                            <label for="input" class='input'>Degree</label>
                        
                            <select id='degreeSelector' class="form-control">

                            </select>
                        </div>
                    
                    <button type="submit" class="btn btn-default" style="display:block;margin: 0 auto;" value="update" name="action">Update</button> 
                </div>
                        <div id='collegeStore' class='hidden'>
                        <%
                            for (int i = 0; i < is.size(); i++) {
                                InstitutionStore inst = is.get(i);
                                ArrayList<CollegeStore> colleges = inst.getColleges();
                        %>
                        <select id='inst<%=inst.getInstitutionID()%>' class='collSelect'>

                            <%
                                for (int j = 0; j < colleges.size(); j++) {
                                    CollegeStore coll = colleges.get(j);
                            %>
                            <option value='<%=coll.getCollegeID()%>'><%=coll.getCollegeName()%></option>
                            <%
                                }
                            %>
                        </select>
                        <%
                            }
                        %>
                    </div>
                    <div id='degreeStore' class='hidden'>
                        <% for (int i = 0; i < is.size(); i++) 
                        {
                                InstitutionStore inst = is.get(i);
                                ArrayList<CollegeStore> colleges = inst.getColleges();
                                for (int j = 0; j < colleges.size(); j++) {
                                    CollegeStore coll = colleges.get(j);
                        %>
                        <select  id='coll<%=coll.getCollegeID()%>'>
                                 <%

                                     for (int k = 0; k < coll.getDegrees().size(); k++) {
                                         DegreeStore degree = coll.getDegrees().get(k);
                                 %>
                                 <option value='<%=degree.getDegreeID()%>'><%=degree.getDegreeName()%></option>
                            <%
                                }
                            %>
                        </select>
                        <%
                                }
                            }
                        %>
                    </div>
                    <script src="/eg_website/js/profile.js"></script>
            </form>
        </div>



    </body>

    <footer>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </footer>
</html>
