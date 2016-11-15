package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LibraryPropertiesFile {
    public static Properties readFileConfig(String files){
        Properties prop = new Properties();
        File file = new File(files);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            prop.load(fis);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Load file config!");
        }
        return prop;
    }
    
     public static void writeFileConfig(String key, String value) throws FileNotFoundException{
        Properties prop = new Properties();
        File file = new File("login.properties");
        FileOutputStream fos = new FileOutputStream(file);
        
        prop.put(key, value);
        try {
            prop.store(fos, "hihi");
        } catch (IOException ex) {
            Logger.getLogger(LibraryPropertiesFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
