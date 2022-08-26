package sample.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

@Stateless
public class RemoteABean implements RemoteA {

    private static final String INSERT_SQL = "INSERT INTO book (id, insertedBy, title) VALUES (?, ?, ?)";

//    @Resource(lookup="java:jboss/datasources/PostgresDS")
    @Resource(lookup="java:jboss/datasources/PostgresXADS")
    private DataSource ds;

    private RemoteB remoteB;

    @PostConstruct
    public void init() {
        try {
            Context context = new InitialContext();
            this.remoteB = (RemoteB) context.lookup("ejb:/remote-ejb-2/RemoteBBean!" + RemoteB.class.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAndCommit(int id, String bookTitle) {
        remoteB.addAndCommit(id, bookTitle);

        try (Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            ps.setInt(1, id);
            ps.setString(2, "RemoteA");
            ps.setString(3, bookTitle);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("### RemoteABean.addAndCommit done");
    }
}
