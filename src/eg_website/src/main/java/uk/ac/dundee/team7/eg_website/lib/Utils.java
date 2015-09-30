/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.lib;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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

        for (int i=0; i< count; i++)
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
    
     /**
     * Converts the byte array to a Hex string
     * 
     * @param data The byte array to convert
     * @return String representing the byte array in hex
     */
    public static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    } 
    
    /**
     * Generate an SHA 256 hash from the text passed
     * 
     * @param text String to convert to hash 
     * @return String of the SHA 256 Hash
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException 
     */
    public static String SHA256(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest  md;
        md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes("iso-8859-1"));
        byte[] sha256Hash = new byte[40];
        sha256Hash = md.digest();
        return convertToHex(sha256Hash);
    }
    
        /**
     * Generate salt
     * 
     * @return byte array representing the salt
     */
    public static byte[] generateSalt()
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[40];
        random.nextBytes(salt);
        return salt;
    }
}
