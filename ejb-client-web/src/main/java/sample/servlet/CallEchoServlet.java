package sample.servlet;

import sample.ejb.DelegateEchoBean;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/echo")
public class CallEchoServlet extends HttpServlet {

    @EJB
    private DelegateEchoBean delegateEchoBean;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException {

        delegateEchoBean.callRemoteBean();

        res.setContentType("text/plain; charset=utf-8");
        res.getWriter().write("echo done.");
    }
}
