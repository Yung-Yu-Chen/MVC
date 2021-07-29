package com.BookServlet;

import com.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ClearCart", value = "/ClearCart")
public class ClearCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        httpSession.removeAttribute("ShoppingCart");
        Enumeration<String> attributeNames = httpSession.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String key = attributeNames.nextElement().toString();
            System.out.println("key = "+key);
        }
        Map<String,Integer> shoppingChat2 = (Map<String,Integer>)httpSession.getAttribute("ShoppingCart");
        writer.print("<div>清空成功!</div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
