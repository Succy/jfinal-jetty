package cn.succy.jfinal.server;

import com.jfinal.core.JFinalFilter;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class JettyServer implements JFinalServer {
    private static final Logger logger = LoggerFactory.getLogger(JettyServer.class);

    private Server server;
    private ServletContextHandler handler;
    private Prop prop;

    public JettyServer() {
        this.prop = PropKit.use("app.properties");
        logger.debug("User sys property: app.properties");
    }

    private void init() {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setHost(prop.get("server.host", "0.0.0.0"));
        connector.setPort(prop.getInt("server.port", 8080));
        connector.setIdleTimeout(30000L);
        server.addConnector(connector);

        handler = new ServletContextHandler();
        handler.setContextPath("/");
        handler.setResourceBase(".");
        handler.setClassLoader(Thread.currentThread().getContextClassLoader());

        // jfinal filter
        FilterHolder jfinalFilter = handler.addFilter(JFinalFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.FORWARD));
        jfinalFilter.setInitParameter("configClass", prop.get("server.jfinal.config"));

        server.setHandler(handler);
    }

    @Override
    public void start() {
        try {
            init();
            server.start();
//            server.join();
            logger.info("<===== JfinalApp has been startup ====>");
            logger.info("Use server host: {}", prop.get("server.host"));
            logger.info("Use server port: {}", prop.get("server.port"));
        } catch (Exception e) {
            logger.error(e.toString(), e);
            stop();
        }
    }

    @Override
    public void restart() {
       stop();
       start();
    }

    @Override
    public void stop() {
        try {
            server.stop();
        }catch (Exception e) {
            logger.error("JFinal App server shutdown failure", e);
        }
    }
}