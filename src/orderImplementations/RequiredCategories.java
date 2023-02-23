package orderImplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import databaseconnectivity.ConnectionProvider;

public class RequiredCategories {

	public static void addCategories() {

		Scanner sc = new Scanner(System.in);
		String category = null;

		System.out.println("Please enter Category/Product name.");
		category = sc.nextLine();

		int qty = 0;
		System.out.println("Please enter quantity.");
		qty = sc.nextInt();
		System.out.println("Product and Quantity are added successfully!\n Thanks!! ");
		try {
			Connection con = ConnectionProvider.getConnection();
			// Statement stmt = con.createStatement()

			PreparedStatement ps = con.prepareStatement(
					"insert into REQUIREMENTS " + "(NAME,QUANTITY)" + "VALUES ( ? " + "," + qty + ")");
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
