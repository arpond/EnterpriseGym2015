/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uk.ac.dundee.team7.eg_website.Store.CollegeStore;
import uk.ac.dundee.team7.eg_website.Store.CountryStore;
import uk.ac.dundee.team7.eg_website.Store.DegreeStore;
import uk.ac.dundee.team7.eg_website.Store.InstitutionStore;
import uk.ac.dundee.team7.eg_website.Store.StatusStore;

/**
 *
 * @author Andrew
 */
public class DemographicModel {

    public ArrayList<InstitutionStore> fetchInstitutions() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;        
        ArrayList<InstitutionStore> instList = new ArrayList<InstitutionStore>(); 
        cs = conn.prepareCall("{call getInstitutionsAll()}");
        cs.execute();
        ResultSet rs = cs.getResultSet();
        rs.first();
        do
        {
            InstitutionStore instStore = new InstitutionStore();
            instStore.setInstitutionID(rs.getInt("institutionID"));
            instStore.setInstitutionName(rs.getString("institutionName"));
            ArrayList<CollegeStore> colleges = new ArrayList<CollegeStore>();
            rs.getInt("collegeID");
            if (!rs.wasNull())
            {
                do
                {
                    if (instStore.getInstitutionID() != rs.getInt("institutionID"))
                    {
                        rs.previous();
                        break;
                    }
                    
                    CollegeStore college = new CollegeStore();
                    college.setCollegeID(rs.getInt("collegeID"));
                    college.setCollegeName(rs.getString("collegeName"));
                    ArrayList<DegreeStore> degrees = new ArrayList<DegreeStore>();
                    rs.getInt("degreeID");
                    if (!rs.wasNull())
                    {
                        do
                        {    
                            if (college.getCollegeID() != rs.getInt("collegeID"))
                            {
                                rs.previous();
                                break;
                            }
                            
                            DegreeStore degree = new DegreeStore();
                            degree.setDegreeID(rs.getInt("degreeID"));
                            degree.setDegreeName(rs.getString("degreeName"));
                            degrees.add(degree);
                        } while (rs.next());
                    }
                    college.setDegrees(degrees);
                    colleges.add(college);
                } while (rs.next());
            }
            instStore.setColleges(colleges);
            instList.add(instStore);
        } while (rs.next());
        
        conn.close();
        return instList;
    }

    public ArrayList<CountryStore> fetchCountries() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;        
        ArrayList<CountryStore> contList = new ArrayList<CountryStore>(); 
        cs = conn.prepareCall("{call getCountries()}");
        cs.execute();
        ResultSet rs = cs.getResultSet();
        //rs.first();
        while(rs.next())
        {
            CountryStore contrStore = new CountryStore();
            contrStore.setCountryID(rs.getInt("countryID"));
            contrStore.setCountryName(rs.getString("countryName"));
            contList.add(contrStore);
        }
        conn.close();
        return contList;
    }

    public ArrayList<StatusStore> fetchStatuses() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;        
        ArrayList<StatusStore> statusList = new ArrayList<StatusStore>(); 
        cs = conn.prepareCall("{call getStatuses()}");
        cs.execute();
        ResultSet rs = cs.getResultSet();
        //rs.first();
        while(rs.next())
        {
            StatusStore statusStore = new StatusStore();
            statusStore.setStatusID(rs.getInt("statusID"));
            statusStore.setStatusName(rs.getString("statusName"));
            statusList.add(statusStore);
        }
        conn.close();
        return statusList;
    }
    
    public ArrayList<DegreeStore> fetchDegrees() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;        
        ArrayList<DegreeStore> degreeList = new ArrayList<DegreeStore>(); 
        cs = conn.prepareCall("{call getDegrees()}");
        cs.execute();
        ResultSet rs = cs.getResultSet();
        //rs.first();
        while(rs.next())
        {
            DegreeStore degreeStore = new DegreeStore();
            degreeStore.setDegreeID(rs.getInt("degreeID"));
            degreeStore.setDegreeName(rs.getString("degreeName"));
            degreeStore.setOtherFlag(rs.getBoolean("other_FLAG"));
            degreeList.add(degreeStore);
        }
        conn.close();
        return degreeList;
    }

    
}
