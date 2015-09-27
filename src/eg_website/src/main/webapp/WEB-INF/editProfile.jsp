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
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Profile</title>        
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
    </head>
    <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
    <body>
        <style>ul {
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
        <div id="updateProfile">
            <h3>Update Profile</h3>
            <form id="updateForm" method="POST"  action="View" >
                <ul>
                    <li><label class="input">First Name:</label><input type="text" name="firstname" value=" <%=up.getFirstName()%>" required></li>
                    <li><label class="input">Last Name:</label><input type="text" name="lastname" value=" <%=up.getLastName()%>" required></li>
                    <li><label class="input">Mobile:</label><input type="text" name="mobile" value=" <%=up.getMobile()%>" required></li>
                    <li><label class="input">Contact Number:</label><input type="text" name="contactNumber" value=" <%=up.getContactNumber()%>" required></li>

                    <li><label class="input">Matric Number:</label><input type="text" name="matricNumber" value=" <%=up.getMatricNumber()%>" required></li>
                    <li><label class="input">Email:</label><input type="text" name="email" value=" <%=ud.getEmail()%>" required></li>
                    <li><label class="input">Status:</label><select name="status">
                            <%
                                for (int i = 0; i < sts.size(); i++) {
                                    StatusStore status = sts.get(i);
                            %>
                            <option value="<%=status.getStatusID()%>"><%=status.getStatusName()%></option>
                            <%}%>
                        </select></li>
                    <li><label class="input">Country:</label><select name="country">
                            <%
                                for (int i = 0; i < cs.size(); i++) {
                                    CountryStore country = cs.get(i);
                            %>
                            <option value="<%=country.getCountryID()%>"><%=country.getCountryName()%></option>
                            <%}%>
                        </select> </li>

                    <li><label class='input'>Institution:</label>
                        <select name='institution' id='instSelect'>
                            <%
                                for (int i = 0; i < is.size(); i++) {
                                    InstitutionStore inst = is.get(i);
                            %>
                            <option value='<%=inst.getInstitutionID()%>'><%=inst.getInstitutionName()%></option>
                            <%
                                }
                            %>
                        </select>
                    </li>
                    <li id='colleges' class='hidden'>
                        <label class='input'>College:</label>
                        <select id='collegeSelector' name='collgeSelector'>
                        </select>
                    </li>
                    <li id='degrees' class='hidden'>
                        <label class='input'>Degree:</label>
                        <select id='degreeSelector'>
                            
                        </select>
                    </li>
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
                    <input type="hidden" name="owner" value="<%=ud.getUsername()%>" id="updateButton">
                    <li><input type="submit" value="Update Profile" name="action" class="button"></li>
                </ul>
                    
            </form>
        </div>
    <script src="/eg_website/js/profile.js"></script>
    </body>
    <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
</html>
