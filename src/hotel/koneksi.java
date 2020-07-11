package hotel;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class koneksi {
     public static Connection koneksi;
    
    public static Connection getConnection()throws SQLException {
        if (koneksi == null) {
            new Driver();
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjava","root","");
        }
        return koneksi;
    }
    
}

