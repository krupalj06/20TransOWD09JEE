package com.xworkz.jdbcconnectivity.preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcconnectivity.insertstmt.Hotel;

public class InsertUsingPreparedStmt {
	
	public static void main(String[] args) {
		
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(12, "MTR", 0, 4, true));
		hotels.add(new Hotel(13, "Leela palace", 60, 5, true ));
		hotels.add(new Hotel(14, "Heritage", 45, 3, false));

		String insertQuery = "insert into Hotels values(?, ?, ?, ? ,?)";
		try( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/20transowd08",
				"root", "root123"); 
			PreparedStatement prepstmt = conn.prepareStatement(insertQuery);
				){
			
			for(Hotel hotel : hotels) {  
				prepstmt.setInt(1, hotel.getId());
				prepstmt.setString(2, hotel.getHotelname());
				prepstmt.setInt(3, hotel.getNoOfRooms());
				prepstmt.setDouble(4, hotel.getRating());
				prepstmt.setBoolean(5, hotel.isRestautant());
				
				// 1st //insert into hotels values(12, MTR , 0, 4, 1);
				// 2nd //insert into hotels values(13, Leela palace , 60, 5, 1);
				//3rd //insert into hotels values(14, Heritage , 45, 3, 0);
				
				boolean result = prepstmt.execute();
				System.out.println("Result: "+result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
