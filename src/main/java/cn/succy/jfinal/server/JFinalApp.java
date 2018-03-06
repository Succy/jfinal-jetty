package cn.succy.jfinal.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jfinal免web.xml部署，类似SpringBoot的启动方式
 *
 * @author Succy
 */
public class JFinalApp {
    private static final Logger logger = LoggerFactory.getLogger(JFinalApp.class);

    public static void run() {
        JFinalServer server = new JettyServer();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop();
            logger.info("JFinal App server shutdown successfully");
        }));
    }
}
