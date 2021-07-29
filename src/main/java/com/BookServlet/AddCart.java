package com.BookServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddCart", value = "/AddCart")
public class AddCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //處理
        String id = request.getParameter("id");

        Map<String,Integer> shoppingChat = (Map<String,Integer>)httpSession.getAttribute("ShoppingCart");
        if(shoppingChat==null){
            shoppingChat = new HashMap<>();

        }
        if(shoppingChat.get(id)==null){
            shoppingChat.put(id,1);
        }else{
            shoppingChat.put(id,shoppingChat.get(id)+1);
        }
        httpSession.setAttribute("ShoppingCart",shoppingChat);
        for (Map.Entry<String, Integer> entry:shoppingChat.entrySet()) {
            System.out.println("index"+entry.getKey()+",number = "+entry.getValue());
        }
        System.out.println(shoppingChat);
        writer.print("<div>添加成功.....</div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
