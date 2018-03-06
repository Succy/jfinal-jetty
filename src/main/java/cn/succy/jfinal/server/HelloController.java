package cn.succy.jfinal.server;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class HelloController extends Controller {
    public void  index() {
        renderTemplate("hello.html");
    }

    @ActionKey("/haha")
    public String haha() {
        return "hello.html";
    }
}
