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
public class CollegeStore {
    private int collegeID;
    private String collegeName;
    private ArrayList<DegreeStore> degrees;

    public CollegeStore() {
        collegeID = 0;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public ArrayList<DegreeStore> getDegrees() {
        return degrees;
    }

    public void setDegrees(ArrayList<DegreeStore> degrees) {
        this.degrees = degrees;
    }
    
    
}
