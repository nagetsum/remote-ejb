package sample.ejb;

import org.jboss.ejb.client.annotation.ClientTransaction;
import org.jboss.ejb.client.annotation.ClientTransactionPolicy;
import javax.ejb.Remote;

@Remote
@ClientTransaction(ClientTransactionPolicy.NOT_SUPPORTED)
public interface RemoteA {
    void addAndCommit(int id, String bookTitle);
}
