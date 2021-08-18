package com.example.ybmt.jun.spring.web.springoas.message;

import java.io.IOException;
import java.text.ParseException;

import org.jboss.logging.Messages;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageBundle;
import org.jboss.logging.annotations.Param;

@MessageBundle(projectCode = "WEXC-")
public interface ExceptionBundle {
    ExceptionBundle EXCEPTIONS = Messages.getBundle(ExceptionBundle.class);

    @Message(id = 1, value = "The config file could not be opened.")
    IOException configFileAccessError();

    @Message(id = 13230, value = "Date string '%s' was invalid.")
    ParseException dateWasInvalid(String dateString, @Param int errorOffset);

    @Message(id=328, value = "Error calculating: %s.")
    ArithmeticException calculationError(@Cause Throwable cause, String msg);
}
