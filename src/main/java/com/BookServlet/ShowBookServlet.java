package com.BookServlet;

import com.bean.Book;
import com.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "ShowBookServlet", value = "/ShowBookServlet")
public class ShowBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Welcome
        out.write("<div>書籍選擇系統</div>");
        //加入購物車
        Map<String, Book> stringBookMap = DBUtil.finaAllBook();
        for (Map.Entry<String, Book> entry:stringBookMap.entrySet()) {
            out.print("<a href="+"'/AddCart?id="+entry.getKey()+"'>"+entry.getValue().getName()+"</a>");
            out.print("<br>");
        }
        //查看購物車
        out.write("<a href='/ShowCart'>查看購物車</a> <br/>");
        //清除購物車
        out.write("<a href='/ClearCart'>清除購物車</a> <br/>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
