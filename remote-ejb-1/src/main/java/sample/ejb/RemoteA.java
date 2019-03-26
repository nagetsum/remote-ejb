package sample.ejb;

import javax.ejb.Remote;

@Remote
public interface RemoteA {
    void addAndCommit(int id, String bookTitle);
}
