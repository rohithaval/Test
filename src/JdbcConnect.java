import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
public class JdbcConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean i;
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");					
			
			/*Create Table:
			
			i= st1.executeUpdate("Create table Student(id int(5),name varchar(20),age int(5),address varchar(20))");
			System.out.println("i"+i);*/
			
			/*Insert into table values
			
			PreparedStatement st1=conn.prepareStatement("insert into student values(?,?,?,?)");
			st1.setInt(1, 2);
			st1.setString(2, "Ajit");
			st1.setInt(3, 26);
			st1.setString(4, "Pune");
			st1.execute();*/
			
			
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root","");
			Statement st1= conn.createStatement();
			ResultSet rs=st1.executeQuery("Select * from student");
			Student[] listofstudents= new Student[10];
			while (rs.next())
			{
				
				Student st= new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setAge(rs.getInt(3));
				st.setAddress(rs.getString(4));
				listofstudents[count]=st;
				count++;
			}
			
			while(count!=0)
			{
				count--;
				System.out.println(listofstudents[count].getId()+" "+
								   listofstudents[count].getName()+" "+
								   listofstudents[count].getAge()+" "+
								   listofstudents[count].getAddress());
				
			}
		
			rs.close();
			st1.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
