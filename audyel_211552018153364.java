package praktikum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class audyel_211552018153364 {
private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/pembelian";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			insertTable();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void insertTable() throws SQLException{
		Connection connection = null;
		Statement statement = null;
		int count = 0;
		
		String insertTableSQL = "INSERT INTO pembelian"+"(nomor, nama_barang, harga, jumlah)"+"VALUES"
								+ "(null,'3','piring','Rp.30.000'"+")";
		
		try {
			connection = getDatabaseConnection();
			statement = connection.createStatement();
			System.out.println(insertTableSQL);
			
			statement.executeUpdate(insertTableSQL);
			count = statement.getUpdateCount();
			System.out.println(count +"Record telah berhasil dimasukkan ke tabel PROFIL!");	
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (connection !=null) {
				connection.close();
			}
			}
		}
	
	public static Connection getDatabaseConnection() {
		Connection connection=null;
		
		try {
		Class.forName(DB_DRIVER);
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return connection;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
		}
	}