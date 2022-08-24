package sample.ejb;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

@Stateless
public class DelegateBean {

    private static final AtomicInteger cnt = new AtomicInteger();

    // NOTE: The following code is not thread safe. This is for test.
    public int callRemoteBean() {
        try {
            Context context = new InitialContext();
            RemoteA remoteA = (RemoteA) context.lookup("ejb:/remote-ejb-1/RemoteABean!" + RemoteA.class.getName());
            remoteA.addAndCommit(cnt.incrementAndGet(), "test book " + cnt.get());
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        return cnt.get();
    }
}
