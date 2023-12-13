package com.dpablos.static_logger_test.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogService {

  private static final Logger logger = LoggerFactory.getLogger(LogService.class);

  public void debug(String msg) {
    logger.debug(msg);
  }

  public void warn(String msg) {
    logger.warn(msg);
  }

  public void warn(String msg, Object... arg) {
    logger.warn(msg, arg);
  }

}