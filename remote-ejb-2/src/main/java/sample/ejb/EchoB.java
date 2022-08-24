package sample.ejb;

import javax.ejb.Remote;

@Remote
public interface EchoB {
    String echo();
}
