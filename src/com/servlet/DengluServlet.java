package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 有两点要注意的地方：
 *
 * 一：getParameter与getAttribute两者的区别
 *
 * request.setAttribute("xiaoxi", "欢迎用户"+name);//向request域中放置信息 （ 键值对的形式） 名字为xiaoxi 内容为"欢迎用户"+name
 *
 * request.getAttribute("xiaoxi");//得到request域中放置名字为xiaoxi的信息
 *
 * request.getParameter("name");//得到request域的参数信息（得到jsp页面传过来的参数）
 *
 * getAttribute表示从request范围取得设置的属性，必须要先setAttribute设置属性，才能通过getAttribute来取得，设置与取得的为Object对象类型 。
 *
 * getParameter表示接收参数，参数为页面提交的参数，包括：表单提交的参数、URL重写（就是xxx?id=1中的id）传的参数等，
 * 因此这个并没有设置参数的方法（没有setParameter），而且接收参数返回的不是Object，而是String类型
 *
 * 二：转发与重定向的区别
 *
 * （1）.重定向的执行过程：Web服务器向浏览器发送一个http响应--》浏览器接受此响应后再发送一个新的http请求到服务器--》服务器根据此请求寻找资源并发送给浏览器。
 * 它可以重定向到任意URL，不能共享request范围内的数据。
 * （2）.重定向是在客户端发挥作用，通过新的地址实现页面转向。
 * （3）.重定向是通过浏览器重新请求地址，在地址栏中可以显示转向后的地址。
 * （4）.转发过程：Web服务器调用内部方法在容器内部完成请求和转发动作--》将目标资源发送给浏览器，它只能在同一个Web应用中使用，可以共享request范围内的数据。
 * （5）.转发是在服务器端发挥作用，通过forward()方法将提交信息在多个页面间进行传递。
 * （6）.转发是在服务器内部控制权的转移，客户端浏览器的地址栏不会显示出转向后的地址。
 */
@WebServlet(name = "DengluServlet")
public class DengluServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name"); //得到jsp页面传过来的参数
        String pwd = request.getParameter("pwd");
        UserDao ud = new UserDaoImpl();
        if(ud.login(name, pwd)){
            request.setAttribute("xiaoxi", "欢迎用户"+name); //向request域中放置信息
            request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功页面
        }else{
            response.sendRedirect("index.jsp"); //重定向到首页
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
