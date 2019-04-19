```jsp
<%@ page 
    [ language="java" ] 
    [ extends="package.class" ] 
    [ import="{package.class | package.*}, ..." ] 
    [ session="true | false" ] 
    [ buffer="none | 8kb | sizekb" ] 
    [ autoFlush="true | false" ] 
    [ isThreadSafe="true | false" ] 
    [ info="text" ] 
    [ errorPage="relative_url" ] 
    [ isErrorPage="true | false" ] 
    [ contentType="mimeType [ ;charset=characterSet ]" | "text/html ; charset=ISO-8859-1" ] 
    [ pageEncoding="characterSet | ISO-8859-1" ] 
    [ isELIgnored="true | false" ] 
%>
```

```jsp
<%@ page import="java.util.*,java.io.*,java.sql.*"%>
```

###page指令的errorPage属性
errorPage属性的设置值必须使用相对路径，如果以“/”开头，表示相对于当前Web应用程序的根目录(注意不是站点根目录)，否则，表示相对于当前页面
可以在web.xml文件中使用<error-page>元素为整个Web应用程序设置错误处理页面。
<error-page>元素有3个子元素，<error-code>、<exception-type>、<location>
<error-code>子元素指定错误的状态码，例如：<error-code>404</error-code>
<exception-type>子元素指定异常类的完全限定名，例如：<exception-type>java.lang.ArithmeticException</exception-type>
<location>子元素指定以“/”开头的错误处理页面的路径，例如：<location>/ErrorPage/404Error.jsp</location>
如果设置了某个JSP页面的errorPage属性，那么在web.xml文件中设置的错误处理将不对该页面起作用。
