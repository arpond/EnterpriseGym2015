/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Store;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class InstitutionStore {
    private int institutionID;
    private String institutionName;
    private ArrayList<CollegeStore> colleges;

    public InstitutionStore() {
        institutionID = 0;
    }

    public int getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(int institutionID) {
        this.institutionID = institutionID;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public ArrayList<CollegeStore> getColleges() {
        return colleges;
    }

    public void setColleges(ArrayList<CollegeStore> colleges) {
        this.colleges = colleges;
    }
    
    
}
