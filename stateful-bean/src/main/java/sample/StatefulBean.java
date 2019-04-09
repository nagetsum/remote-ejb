package sample;

import javax.ejb.Stateful;
import java.io.Serializable;

@Stateful
public class StatefulBean implements Serializable {
    private int accessCount;

    public int incrementAndGet() {
        accessCount++;
        return accessCount;
    }

    public int now() {
        return accessCount;
    }
}
