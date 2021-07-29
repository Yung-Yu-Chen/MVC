import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionTest01", value = "/SessionTest01")
public class SessionTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        HttpSession httpSession = request.getSession();
        String sessionName = (String) httpSession.getAttribute("name");
        if(sessionName == null){
            System.out.println("Null!");
        }else{
            System.out.println("name = "+sessionName);
        }


        httpSession.setAttribute("name",name);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
