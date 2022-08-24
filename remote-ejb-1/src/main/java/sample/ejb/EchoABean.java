package sample.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class EchoABean implements EchoA {

    private EchoB echoB;

    @PostConstruct
    public void init() {
        try {
            Context context = new InitialContext();
            this.echoB = (EchoB) context.lookup("ejb:/remote-ejb-2/EchoBBean!" + EchoB.class.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String echo() {
        System.out.println("### sample.ejb.EchoABean#getEcho(): echoB.echo() = " + echoB.echo());
        return "this is EchoABean";
    }
}
