import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStatement {
	
	public DeleteStatement()
	{
		//Scanner input;
		try {
			 
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","ruqayya");
			
			System.out.println("Enter the Name for deleting the record..");
			Scanner input = new Scanner(System.in);
			String inputname = input.next();
			String sql =" delete from Registration where fullName=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,inputname);
			int i = stmt.executeUpdate();
			if(i>0)
			{
				System.out.println("Deleted..");
			}
			else
			{
				System.out.println("Record Not available..");
			}
			
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DeleteStatement obj = new DeleteStatement();
	}

}