package org.irctc.dataUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public  class GetStationNames {
	public static Map<String ,String> getStations() throws ClassNotFoundException {
		Map<String, String> stations =  new HashMap<String, String>();
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Seena@1021");
	Statement stmt = con.createStatement();
	ResultSet rs =  stmt.executeQuery("Select * from Stations");
	while(rs.next()) {
		stations.put(rs.getString(0), rs.getString(1));
	}
	 stations.put("BZA", "SC");
	}catch(SQLException e) {
	}
	return stations;
	}
}

