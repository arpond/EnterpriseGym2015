<%-- 
    Document   : manageUsers
    Created on : 26-Sep-2015, 10:20:53
    Author     : Andrew
--%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        ArrayList<UserStore> users = (ArrayList<UserStore>) request.getAttribute("users");
        HashMap types = (HashMap) request.getAttribute("pointTypes");
        Object[] typeIDs = types.keySet().toArray();
        HashMap groups = (HashMap) request.getAttribute("groups");
        Object[] groupIDs = groups.keySet().toArray();
    %>
    <head>
        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <script src="/eg_website/js/users.js"></script>
        <script src="/eg_website/js/tables.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
        <style>
            th.sortable {
                 color: #666;
                cursor: pointer;
                text-decoration: underline;
            }
            th.sortable:hover { color: black; }
            th.sorted-asc, th.sorted-desc  { color: black; }
            .hidden {display:none;}
        </style>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        <div id="wrapper">
            <div id="page-wrapper">
                    <div id="managementArea" class="col-md-8">
                        <div class="mangementOption">
                            
                            <h5>Add Points</h5>
                            <form>
                                Type of Points:
                                <select id="ptaType">
                                    <%
                                    for (int j=0; j < typeIDs.length; j++)
                                    {
                                        %>
                                        <option value="<%=typeIDs[j]%>"><%=types.get(typeIDs[j])%></option>
                                        <%
                                    }
                                    %>
                                </select>
                                Number of points: <input type="text" name="pointToAdd" id="pta" data-validate="required,number">
                                <input type="submit" value="Add Points to selected users" id="ap" class="action">
                            </form>
                        </div>
                        <div class="mangementOption">
                            <h5>Remove Points</h5>
                            <form>
                                Type of Points:
                                <select id="ptrType">
                                    <%
                                    for (int j=0; j < types.size(); j++)
                                    {
                                        %>
                                        <option value="<%=typeIDs[j]%>"><%=types.get(typeIDs[j])%></option>
                                        <%
                                    }
                                    %>
                                </select>
                                Number of points: <input types="text" id="ptr" data-validate="required,number">
                                <input type="submit" value="Remove Points from selected users" id="rp" class="action">
                            </form>
                        </div>
                        <div class="mangementOption">
                            <h5>Change Group</h5>
                                Group:
                                <select id="newgroup">
                                    <%
                                    for (int j=0; j < groups.size(); j++)
                                    {
                                        %>
                                        <option value="<%=groupIDs[j]%>"><%=groups.get(groupIDs[j])%></option>
                                        <%
                                    }
                                    %>
                                </select>
                                <input type="submit" value="Change selected users groups" id="chgrp" class="action">
                        </div>
                    </div>
                    <div id="displayManagement" class="form-group col-md-2">
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="grp" checked>User Group</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="un" checked>Username</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="fn" checked>First Name</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="ln" checked>Last Name</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="em" checked>Email</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="mob" checked>Mobile</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="cn" checked>Contact Number</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="cou" checked>Country</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="st" checked>Status</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="inst" checked>Institution</label>
                        </div>
                    </div>
                    <div id="displayManagement2" class="form-group col-md-2">    
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="coll" checked>College</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="deg" checked>Degree</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="yos" checked>Year Of Study</label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="yes" checked>Young ES Member</label>
                        </div>

                        <%
                        for (int i=0; i<typeIDs.length; i++)
                        {
                            %>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="<%=types.get(typeIDs[i])%>" checked><%=types.get(typeIDs[i])%></label>
                        </div>
                           
                            <%
                        }
                        %>
                        <div class="checkbox">
                            <label><input type="checkbox" class="displayCheckBox" value="tot" checked>Total Points</label>
                        </div>
                        

                    </div>
                    <div id="filterArea">
                        <label for="filter">Filter</label>
                        <input type="text" name="filter" value="" id="filter" />
                    </div>
                    <div class="table-responsive">
                        <table cellpadding="1" cellspacing="1" id="resultTable" class="table table-bordered table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>Manage</th>
                                    <th class="grp">User Group</th>
                                    <th class="un">Username</th>
                                    <th class="fn">First Name</th>
                                    <th class="ln">Last Name</th>
                                    <th class="em">Email</th>
                                    <th class="mob">Mobile</th>
                                    <th class="cn">Contact Number</th>
                                    <th class="cou">Country</th>
                                    <th class="st">Status</th>
                                    <th class="inst">Institution</th>
                                    <th class="coll">College</th>
                                    <th class="deg">Degree</th>
                                    <th class="yos">Year Of Study</th>
                                    <th class="yes">Young ES Member</th>
                                    <%
                        for (int i=0; i<typeIDs.length; i++)
                        {
                            %>
                                    <th class="<%=types.get(typeIDs[i])%>"><%=types.get(typeIDs[i])%></th>
                            <%
                        }
                                    %>
                                    <th class="tot">Total Points</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%                                
                                for (int i = 0; i < users.size(); i++) 
                                {
                                    UserDetails ud = users.get(i).getUd();
                                    UserProfile up = users.get(i).getUp();
                                    HashMap points = ud.getPoints();
                                    int total = 0;
                                %>
                                <tr>
                                    <td><input type="checkbox" value="<%=ud.getUserID()%>"></td>
                                    <td class="grp"><%=groups.get(ud.getGroupID())%></td>
                                    <td class="un"><%=ud.getUsername()%></td>
                                    <td class="fn"><%=up.getFirstName()%></td>
                                    <td class="ln"><%=up.getLastName()%></td>
                                    <td class="em"><%=ud.getEmail()%></td>
                                    <td class="mob"><%=up.getMobile()%></td>
                                    <td class="cn"><%=up.getContactNumber()%></td>
                                    <td class="cou"><%=up.getCountry()%></td>
                                    <td class="st"><%=up.getStatus()%></td>
                                    <td class="inst"><%=up.getInstitution()%></td>
                                    <td class="coll"><%=up.getCollege()%></td>
                                    <td class="deg"><%=up.getDegree()%></td>
                                    <td class="yos"><%=up.getYearOfStudy()%></td>
                                    <td class="yes"><%=up.getYoungES_FLAG()%></td>
                                    <%
                                    for (int k=0; k < typeIDs.length; k++)
                                    {
                                        total +=(int) points.get(types.get(typeIDs[k]));
                                    %>
                                    <td class="<%=types.get(typeIDs[k])%>"><%=points.get(types.get(typeIDs[k]))%></td>
                                    <%
                                    }
                                    %>
                                    <td class="tot"><%=total%></td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
            </div>
        </div>
    </body>
</html>
