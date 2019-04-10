package sample.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateless
public class RemoteBBean implements RemoteB {
    @Override
    public void addAndCommit(int id, String bookTitle) {
        System.out.println("add book id=" + id + ", bookTitle=" + bookTitle);
    }
}
