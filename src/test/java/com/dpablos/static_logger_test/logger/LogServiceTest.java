package com.dpablos.static_logger_test.logger;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class LogServiceTest {

    @Test
    void log_debug_with_message() {
        try (final MockedStatic<LoggerFactory> loggerFactory = mockStatic(LoggerFactory.class)) {
            final Logger logger = mock(Logger.class);
            loggerFactory.when(() -> LoggerFactory.getLogger(any(Class.class))).thenReturn(logger);

            final LogService logService = new LogService();
            logService.debug("Test message");

            verify(logger, times(1)).debug("Test message");
        }
    }

    @Test
    void log_warn_with_message() {
        try (final MockedStatic<LoggerFactory> loggerFactory = mockStatic(LoggerFactory.class)) {
            final Logger logger = mock(Logger.class);
            loggerFactory.when(() -> LoggerFactory.getLogger(any(Class.class))).thenReturn(logger);

            final LogService logService = new LogService();
            logService.warn("Test message");

            verify(logger, times(1)).warn("Test message");
        }
    }

    @Test
    void log_warn_with_message_and_one_argument() {
        try (final MockedStatic<LoggerFactory> loggerFactory = mockStatic(LoggerFactory.class)) {
            final Logger logger = mock(Logger.class);
            loggerFactory.when(() -> LoggerFactory.getLogger(any(Class.class))).thenReturn(logger);

            final LogService logService = new LogService();
            logService.warn("Test message {}", 15);

            verify(logger, times(1)).warn("Test message {}", 15);
        }
    }

}
