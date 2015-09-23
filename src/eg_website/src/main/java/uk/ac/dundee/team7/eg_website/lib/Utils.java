/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.lib;

import java.net.URLDecoder;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andrew
 */
public class Utils {
    
    /**
     * Splits the request url into an array of strings where the first value is the user directory
     * 
     * @param request
     * @return String[] representing the split URL
     */
    public static String[] SplitRequestPath(HttpServletRequest request) {
        StringTokenizer st = new StringTokenizer(request.getRequestURI(), "/");
        String args[] = new String[st.countTokens()];
        int count = st.countTokens();
        
        for (int i=0; i < count; i++)
        {
            String token = st.nextToken();
            try
            {
                args[i] = URLDecoder.decode(token, "UTF-8");
            }
            catch (Exception e)
            {
                System.out.println("Bad URL" + args[i]);
            }
        }
        return args;
    }
}
