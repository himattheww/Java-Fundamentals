package com.project.apitask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
	public static void main(String []args) throws ClassNotFoundException, SQLException {
		
		ConnectionDB conn = new ConnectionDB();
		
		Class.forName(conn.jdbc);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Kode Mahasiswa");
		String kd_mhs = scanner.nextLine();
		
		System.out.println("Nama Mahasiswa");
		String nm_mhs = scanner.nextLine();
		
		System.out.println("Usia");
		String usia = scanner.nextLine();
		
		System.out.println("SPP");
		String spp = scanner.nextLine();
		
		Connection con = DriverManager.getConnection(conn.url,conn.user, conn.password);
		String sql = "Insert into mahasiswa (kd_mhs, nm_mhs, usia, spp) values (?,?,?,?)"; // tanda tanya dia menanyakan values
		
		PreparedStatement state = con.prepareStatement(sql);
		//set values
		state.setString(1,kd_mhs);
		state.setString(2, nm_mhs);
		state.setInt(3, Integer.valueOf(usia));
		state.setInt(4, Integer.valueOf(spp));
		
		state.executeUpdate();
		System.out.println("Insert Complete");
		
		
		
	}
		
	
}
