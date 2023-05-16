package com.sourabh.webapp01.HelloPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController 
{
    // say hello what you are learning 
    //say-hello
    @RequestMapping("say-hello")   // when you hit this on url messaage hit back
    @ResponseBody   // to return string as it is 
    public String sayHello()
    {
        return "Hello Whats you are learning today !!";
    }

    @RequestMapping("say-hello-jsp")   // when you hit this on url messaage hit back
    public String sayHelloJsp()
    {
        return "sayHello" ;
    }
/* 
    @RequestMapping("say-hello-Html")   // when you hit this on url messaage hit back
    @ResponseBody   // to return string as it is 
    public String sayHelloHtml()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> HTML Page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("HTML Page with Body");
        sb.append("</body>");
        sb.append("</html>");
        
        return sb.toString();
    }
*/
    
}
