/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import com.toedter.calendar.JDateChooser;

/**
 *
 * @author Nara
 */
public class TienIch {
    
    public String getDate(JDateChooser j)
    {
        int y = j.getDate().getYear();
        y+=1900; 
        int m = j.getDate().getMonth() +1;
        int d = j.getDate().getDate();
        
        return String.valueOf(y) + "-" + String.valueOf(m) + "-" +String.valueOf(d);
    }
}
