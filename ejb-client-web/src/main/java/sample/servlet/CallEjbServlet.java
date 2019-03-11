package sample.servlet;

import sample.ejb.RemoteA;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/test")
public class CallEjbServlet extends HttpServlet {

    private static final AtomicInteger cnt = new AtomicInteger();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        Hashtable<String, String> jndiProps = new Hashtable<>();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        try {
            Context context = new InitialContext(jndiProps);
            RemoteA remoteA = (RemoteA) context.lookup("ejb:/remote-ejb-1/RemoteABean!" + RemoteA.class.getName());
            remoteA.addAndCommit(cnt.incrementAndGet(), "test book " + cnt.get());
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        res.setContentType("text/plain; charset=utf-8");
        res.getWriter().write("add book done. No: " + cnt.get());
    }
}
