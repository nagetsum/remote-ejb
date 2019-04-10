package sample.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateful
public class RemoteBBean implements RemoteB {

//    private static final String INSERT_SQL = "INSERT INTO book (id, insertedBy, title) VALUES (?, ?, ?)";

//    @Resource(lookup = "java:jboss/datasources/PostgresDS")
//    private DataSource ds;

    @Override
    public void addAndCommit(int id, String bookTitle) {
        System.out.println("add book id=" + id + ", bookTitle=" + bookTitle);

//        try (Connection conn = ds.getConnection();
//             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
//            ps.setInt(1, id);
//            ps.setString(2, "RemoteB");
//            ps.setString(3, bookTitle);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
