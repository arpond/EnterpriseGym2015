/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Store;

/**
 *
 * @author Andrew
 */
public class DegreeStore {
    private int degreeID;
    private String degreeName;
    private Boolean otherFlag;

    public DegreeStore() {
        degreeID = 0;
    }

    public int getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public Boolean getOtherFlag() {
        return otherFlag;
    }

    public void setOtherFlag(Boolean otherFlag) {
        this.otherFlag = otherFlag;
    }
    
    
    
    
}
