package sample.servlet;

import sample.ejb.DelegateBean;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class CallEjbServlet extends HttpServlet {

    @EJB
    private DelegateBean delegate;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int cnt = delegate.callRemoteBean();

        res.setContentType("text/plain; charset=utf-8");
        res.getWriter().write("add book done. No: " + cnt);
    }
}