package cn.succy.jfinal.server;

import com.jfinal.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JLog extends Log {
    private Logger logger;

    public SLF4JLog(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public SLF4JLog(String name) {
        logger = LoggerFactory.getLogger(name);
    }

    public static SLF4JLog getLog(Class<?> clazz) {
        return new SLF4JLog(clazz);
    }

    public static SLF4JLog getLog(String name) {
        return new SLF4JLog(name);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String message, Throwable t) {
        logger.debug(message, t);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String message, Throwable t) {
        logger.info(message, t);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void warn(String message, Throwable t) {
        logger.warn(message, t);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Throwable t) {
        logger.error(message, t);
    }

    @Override
    public void fatal(String message) {
        logger.trace(message);
    }

    @Override
    public void fatal(String message, Throwable t) {
        logger.trace(message, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isTraceEnabled();
    }
}
