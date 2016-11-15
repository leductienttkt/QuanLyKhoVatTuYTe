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

    public String getDate(JDateChooser j) {
        int y = j.getDate().getYear();
        y += 1900;
        int m = j.getDate().getMonth() + 1;
        int d = j.getDate().getDate();
        if (m < 10) {
            return String.valueOf(y) + "-0" + String.valueOf(m) + "-" + String.valueOf(d);
        } else {
            return String.valueOf(y) + "-" + String.valueOf(m) + "-" + String.valueOf(d);
        }
    }

    public String doiNgay(String ngay) {
        String nam = ngay.substring(0, 4);
        String thang = ngay.substring(5, 7);
        String ng = ngay.substring(8, 10);
        return ng + "-" + thang + "-" + nam;
    }
}
