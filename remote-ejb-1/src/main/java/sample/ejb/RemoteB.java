package sample.ejb;

import javax.ejb.Remote;

@Remote
public interface RemoteB {
    void addAndCommit(int id, String bookTitle);
}