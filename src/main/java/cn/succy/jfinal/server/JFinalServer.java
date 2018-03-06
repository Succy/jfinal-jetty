package cn.succy.jfinal.server;

public interface JFinalServer {

    /**
     * 启动服务
     */
    void start();

    /**
     * 重启服务
     */
    void restart();

    /**
     * 停止服务
     */
    void stop();
}
