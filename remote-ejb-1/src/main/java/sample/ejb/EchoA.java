package sample.ejb;

import javax.ejb.Remote;

@Remote
public interface EchoA {
    String echo();
}
