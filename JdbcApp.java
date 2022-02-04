
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");// loading drivers
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"postgres");// create connection
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char choice;
		do {
			System.out.println("1.View Employee Data");
			System.out.println("2.Update Employee Data");
			System.out.println("3.Add Employee ");
			System.out.println("4.Delete Employee Data");
			System.out.println("5.View All Employee's Data");
			System.out.println("6.Exit");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				PreparedStatement st = conn.prepareStatement("select * from employee where emp_id=?");
				System.out.println("Enter employee id to search data: ");
				int ie = sc.nextInt();
				st.setInt(1, ie);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					System.out.println(
							"ID: " + rs.getString(1) + " Name : " + rs.getString(2) + " Salary : " + rs.getString(3));
				}
				break;
			case 2:
				System.out.println("Enter employee id where you want to update his data: ");
				int iu = sc.nextInt();
				System.out.println("Enter name: ");
				String en = sc.next();
				System.out.println("Enter Salary: ");
				int esal = sc.nextInt();
				PreparedStatement st1 = conn
						.prepareStatement("UPDATE employee SET emp_name = ?, emp_salary = ? WHERE emp_id=?");
				st1.setString(1, en);
				st1.setInt(2, esal);
				st1.setInt(3, iu);
				st1.executeUpdate();
				System.out.println("Updated Successfully");
				break;
			case 3:
				PreparedStatement st2 = conn.prepareStatement("insert into employee values(?,?,?)");
				System.out.println("ENTER EMPLOYEE DATA ");
				System.out.println("Employee Id= ");
				int addid = sc.nextInt();
				System.out.println("Employee Name= ");
				String addname = sc.next();
				System.out.println("Employee Salary= ");
				int addsalary = sc.nextInt();
				st2.setInt(1, addid);
				st2.setString(2, addname);
				st2.setInt(3, addsalary);
				st2.executeUpdate();
				System.out.println("Employee Data Added Successfully");
				break;

			case 4:
				PreparedStatement st3 = conn.prepareStatement("Delete from employee where emp_id=?");
				System.out.println("Enter employee id to delete his data: ");
				int dd = sc.nextInt();
				st3.setInt(1, dd);
				st3.executeUpdate();
				System.out.println("Data Deleted Successfully");
				break;
			case 5:
				PreparedStatement st4 = conn.prepareStatement("select * from employee");
				ResultSet rs4 = st4.executeQuery();
				while (rs4.next()) {
					System.out.println(
							"ID: " + rs4.getString(1) + " Name: " + rs4.getString(2) + " Salary: " + rs4.getString(3));
				}
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid Choice!!!");
				break;
			}
			System.out.println("Do you want to continue (Y/N)");
			choice = sc.next().charAt(0);
		} while (choice == 'Y' || choice == 'y');
		System.out.println("Bye");
	}

}