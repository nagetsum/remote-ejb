package sample.ejb;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class DelegateEchoBean {

    public void callRemoteBean() {
        try {
            Context context = new InitialContext();
            EchoA echoA = (EchoA) context.lookup("ejb:/remote-ejb-1/EchoABean!" + EchoA.class.getName());
            System.out.println("### sample.ejb.DelegateEchoBean echoA.echo():" + echoA.echo());
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
