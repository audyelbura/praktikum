package praktikum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDatabase {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		 } 
		 
		 catch(ClassNotFoundException ex) {
			 System.out.println("MySQL JDBC Driver tidak ditemukan");
			 ex.printStackTrace();
		 }
		 	System.out.println("MySQL JDBC Driver berhasil ditemukan");
		 	Connection connection = null;
		
		 try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pembelian","root","");
		    }
		 
		 catch (SQLException ex) {
	        System.out.println("Gagal Membuat Koneksi");
			ex.printStackTrace();
	    }
		 
		 if(connection !=null) {
			 System.out.println("Selamat, Anda telah berhasil membuat koneksi ke database MySQL");
		 }
		 else {
			 System.out.println("Maaf, Anda gagal membuat koneksi");
		 }
	
		 try {
			 connection.close();
		 }
		 catch(SQLException ex) {
			 System.out.println("Gagal membuat koneksi");
			 ex.printStackTrace();
			 
	}	
	
	}
}
