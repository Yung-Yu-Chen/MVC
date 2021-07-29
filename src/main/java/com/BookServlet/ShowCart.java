package com.BookServlet;

import com.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "ShowCart", value = "/ShowCart")
public class ShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        Map<String,Integer> shoppingChat= (Map<String,Integer>)session.getAttribute("ShoppingCart");
        if(shoppingChat==null){

            writer.print("<div>空空如也</div>");
            response.setHeader("refresh", "2;url=/ShowBookServlet");

            return;
        }
        for (Map.Entry<String,Integer> map:shoppingChat.entrySet()) {
            writer.print("<div>書名:"+DBUtil.finaBookById(map.getKey()).getName()+"數量"+map.getValue()+"</div>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
