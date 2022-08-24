package sample.ejb;

import javax.ejb.Stateless;

@Stateless
public class EchoBBean implements EchoB {
    @Override
    public String echo() {
        System.out.println("### sample.ejb.EchoBBean#echo()");
        return "this is EchoBBean";
    }
}
