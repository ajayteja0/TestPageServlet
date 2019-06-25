import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Record {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("class is ok");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
				System.out.println("connected");
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from results ");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t "+rs.getInt(2));
			     }
			}
				catch(Exception ex)
			{
				System.out.println("error:"+ex);
				
			}
		
			
	}
}
