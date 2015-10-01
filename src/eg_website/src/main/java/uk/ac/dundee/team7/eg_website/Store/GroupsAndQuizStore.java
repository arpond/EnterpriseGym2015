/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Store;

import java.util.HashMap;

/**
 *
 * @author dragomir
 */
public class GroupsAndQuizStore {
    private HashMap quizes;
    private int groupid;
    private String groupName;

    public HashMap getQuizes() {
        return quizes;
    }

    public void setQuizes(HashMap quizes) {
        this.quizes = quizes;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    
    
}
