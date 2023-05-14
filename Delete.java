package praktikum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/pembelian";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			updateRecord();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
		
	public static void updateRecord() throws SQLException {
		Connection connection = null;
		Statement statement = null;
		int countRecordDeleted = 0;
			
		String deleteTableQuery = "DELETE FROM pembelian WHERE nama_barang = '1' ";
			
		try {
			connection = getDatabaseConnection();
			statement = connection.createStatement();
			System.out.println(deleteTableQuery);
				
			statement.executeUpdate(deleteTableQuery);
			countRecordDeleted = statement.getUpdateCount();
			System.out.println(countRecordDeleted + " record telah berhasil dihapus pada tabel pembelian!");	
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		}
	}
		
	public static Connection getDatabaseConnection() {
		Connection connection = null;
					
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
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
					
		return connection;
	}

}