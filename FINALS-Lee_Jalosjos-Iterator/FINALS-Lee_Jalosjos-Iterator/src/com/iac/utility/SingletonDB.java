package com.iac.utility;

import java.sql.*;
import java.util.ArrayList;






import com.iac.model.professor.*;
import com.iac.model.subject.*;

public class SingletonDB {

	//this is defaulted to null
	private static Connection connection; 

	
	private SingletonDB() {
	}
	
	private static Connection getDBConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/despatt", 
					"root", "");
		} catch (ClassNotFoundException cfne) {
			System.err.println(cfne.getMessage());
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return connection;
	}
	
	//now this is the global method that can be accessed statically by
	//other classes when creating a Connection object
	public static Connection getConnection() {
		return (( connection !=null )
			? connection
			: getDBConnection());		
	}
	
	public static void createTable()throws Exception{
		
		String sql= "CREATE TABLE despatt.`iac_subjects` ( `id` INT NOT NULL AUTO_INCREMENT , "
				+ "`subjectName` VARCHAR(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , "
				+ "`subjectDescription` VARCHAR(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , "
				+ "`professorName` VARCHAR(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,"
				+ " `professorExperience` VARCHAR(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,"
				+ " PRIMARY KEY (`id`)) ENGINE = InnoDB;";
				
		String sql1 ="CREATE TABLE `despatt`.`transaction_table` ( `transaction_id` INT NOT NULL AUTO_INCREMENT ,"
				+ " `subjectName` VARCHAR(500) NOT NULL , `subjectDescription` VARCHAR(500) NOT NULL , `purchaseDate`"
				+ " DATETIME NOT NULL , `quantity` INT NOT NULL , PRIMARY KEY (`transaction_id`)) ENGINE = InnoDB;";
				
				
		try{
			connection = getConnection();
			PreparedStatement prep = connection.prepareStatement(sql);
			prep = connection.prepareStatement(sql1);
			prep.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			System.out.println(" Table Has Been Successfully Created ");
		}
	}
	
	public static void insertRecord(StudentSubject subject, Professor professor)throws Exception {
		
		String sql = "insert into " +
			"iac_subjects(subjectName, subjectDescription," +
			"	professorName, 	professorExperience) " +
			"values (?,?,?,?)";
		try {
			connection =  getConnection();
			
			if (connection != null) {
				//create a PreparedStatement object
				PreparedStatement prep = 
					connection.prepareStatement(sql);
				prep.setString(1, subject.viewSubject());
				prep.setString(2, subject.viewDescription());
				prep.setString(3, professor.viewProfessor());
				prep.setString(4, professor.viewExperience());
				prep.executeUpdate();
				
				
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}		
	}
	
	public static ArrayList<String> showRecord()throws Exception{
		String sql = "SELECT subjectName,subjectDescription,professorName,professorExperience FROM iac_subjects"; 
		try{
			connection = getConnection();
			PreparedStatement prep = connection.prepareStatement(sql);
			
			ResultSet result = prep.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()){
				System.out.println(result.getString("subjectName"));
				System.out.println(result.getString("subjectDescription"));
				System.out.println(result.getString("professorName"));
				System.out.println(result.getString("professorExperience"));
				System.out.println("\n ");
			}
			System.out.println("All Records Have Been Selected");
			return array;
			
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	public static ArrayList<String> searchSubject(String search_id)throws Exception{
		String id = search_id;
		String sql = "SELECT * FROM iac_subjects WHERE subjectName like '%"+id+"%'";
		try{
			connection = getConnection();
			PreparedStatement prep = connection.prepareStatement(sql);
			
			ResultSet result = prep.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()){
				System.out.println("\nSearched Record Has Been Found");
				System.out.println("\n ");
				System.out.println(result.getString("subjectName"));
				System.out.println(result.getString("subjectDescription"));
				System.out.println(result.getString("professorName"));
				System.out.println(result.getString("professorExperience"));
				System.out.println("\n ");
			}
			
			return array;
			
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	public static ArrayList<String> searchProfessor(String search_id)throws Exception{
		String id = search_id;
		String sql = "SELECT * FROM iac_subjects WHERE professorName like '%"+id+"%'";
		try{
			connection = getConnection();
			PreparedStatement prep = connection.prepareStatement(sql);
			
			ResultSet result = prep.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()){
				System.out.println("\nSearched Record Has Been Found");
				System.out.println("\n ");
				System.out.println(result.getString("subjectName"));
				System.out.println(result.getString("subjectDescription"));
				System.out.println(result.getString("professorName"));
				System.out.println(result.getString("professorExperience"));
				System.out.println("\n ");
			}
			return array;
			
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	public static void truncate(){
		String sql = "TRUNCATE TABLE iac_subjects";
		try{
			connection = getConnection();
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.executeUpdate();
			System.out.println("All data has been cleared from the database");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static ResultSet searchRecord(String search){
		String search_item = search;
		ResultSet rs = null;
		String sql = "SELECT * FROM iac_subjects WHERE subjectName like '%"+search_item+"%'";
		try{
			connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			rs.next();
			
			
		}catch(SQLException sqle){
			System.err.println(sqle.getMessage());
		}
		
		return rs;
	}
	public static void insertTransactionRecord(StudentSubject subject) {
		try {
			connection =  getConnection();
			String sql = "insert into " +
					"transaction_table(subjectName, subjectDescription," +
					"purchaseDate, quantity)" +
					"values (?,?,?,?)";
			
			if (connection != null) {
				
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					
					//create a PreparedStatement object
					PreparedStatement prep = 
					connection.prepareStatement(sql);
					prep.setString(1, subject.viewSubject());
					prep.setString(2, subject.viewDescription());
					prep.setTimestamp(3, date);
					prep.setInt(4, 1);
					//now commit this to the database table
					prep.executeUpdate();
					
					
					
			}
				
			
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}		
		
	}
	
	
}
