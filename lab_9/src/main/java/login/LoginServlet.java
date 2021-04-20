package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import com.mysql.cj.jdbc.Driver;

@WebServlet( name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private LoginDao loginDao;
    private static int count;

    public void init() {
        loginDao = new LoginDao();
        count = 0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        loginBean.setRole(null);
        boolean status = false;
        try {
            status = loginDao.validate(loginBean);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        request.setAttribute("status", status);
        request.setAttribute("count", count++);
        if (status) {
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect("/loginsuccess");
        } else {
            HttpSession session = request.getSession();
//                session.setAttribute("user", username);
            response.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
