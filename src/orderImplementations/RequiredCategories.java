package orderImplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import databaseconnectivity.ConnectionProvider;

public class RequiredCategories {
//method to add the values in the oracle database.
	public static void addCategories() {

		try {
			String category = null;
			int qty = 0;
			
			Scanner sc = new Scanner(System.in);

			System.out.println("Please enter Category/Product name.");
			category = sc.nextLine();
			System.out.println("Please enter quantity.");
			qty = sc.nextInt();
		
			System.out.println("Product and Quantity are added successfully!\n Thanks!! ");
			Connection con = ConnectionProvider.getConnection();
			// Statement stmt = con.createStatement()

			PreparedStatement ps = con.prepareStatement(
					"insert into REQUIREMENTS " + "(NAME,QUANTITY)" + "VALUES ( ? " + "," + qty + ")");
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
