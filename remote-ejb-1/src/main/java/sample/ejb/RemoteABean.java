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

    private RemoteB remoteB;

    @PostConstruct
    public void init() {
        Hashtable<String, String> jndiProps = new Hashtable<>();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        try {
            Context context = new InitialContext(jndiProps);
            this.remoteB = (RemoteB) context.lookup("ejb:/remote-ejb-2/RemoteBBean!" + RemoteB.class.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAndCommit(int id, String bookTitle) {
        remoteB.addAndCommit(id, bookTitle);
        System.out.println("add book id=" + id + ", bookTitle=" + bookTitle);
    }
}
