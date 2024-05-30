package vu.librarysystem1;

import java.awt.print.Book;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private Connection connection;

    public void connect() throws SQLException {
        String url = "jdbc:ucanaccess://" + new File("C:/Users/Mtech Eletronics/Documents/NetBeansProjects/LibrarySystem1/src/main/LibraryDB.accdb").getAbsolutePath();
        connection = DriverManager.getConnection(url);
    }

    public void addBook(String bookID, String title, String author, int year) throws SQLException {
        String query = "INSERT INTO tblBooks (BookID, Title, Author, Year) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, bookID);
        statement.setString(2, title);
        statement.setString(3, author);
        statement.setInt(4, year);
        statement.executeUpdate();
    }

    public void deleteBook(String bookID) throws SQLException {
        String query = "DELETE FROM tblBooks WHERE BookID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, bookID);
        statement.executeUpdate();
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM tblBooks";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String id = resultSet.getString("BookID");
            String title = resultSet.getString("Title");
            String author = resultSet.getString("Author");
            int year = resultSet.getInt("Year");
            books.add(new vu.librarysystem1.Book(id, title, author, year));
        }

        return books;
    }
}
