import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());;
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";
            //Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Ankita");
            preparedStatement.setInt(2, 25);
            preparedStatement.setDouble(3, 84.7);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0)
            {
                System.out.println("Data inserted Successfully!");
            } else
            {
                System.out.println("Data Not inserted");
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}