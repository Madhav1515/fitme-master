import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayAll {
	public DisplayAll()
	{
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","ruqayya");
			Statement st=connection.createStatement();
			String sql1 =" select *from Registration";
			ResultSet rs=st.executeQuery(sql1);
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	public static void main(String[] args) {
		DisplayAll obj1=new DisplayAll();

	}

}