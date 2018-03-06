package cn.succy.jfinal.server;

import com.jfinal.config.*;
import com.jfinal.template.Engine;
import com.jfinal.template.source.ClassPathSourceFactory;

public class AppConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setLogFactory(new SLF4JLogFactory());
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", HelloController.class);
    }

    @Override
    public void configEngine(Engine me) {
        me.setDevMode(true);
        me.setSourceFactory(new ClassPathSourceFactory());
        me.setBaseTemplatePath("views");

    }

    @Override
    public void configPlugin(Plugins me) {

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
