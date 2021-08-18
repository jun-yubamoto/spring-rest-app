package com.example.ybmt.jun.spring.web.springoas.message;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.Logger;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;

@MessageLogger(projectCode = "WOASL-")
public interface SpringOASLogger extends BasicLogger {

    @LogMessage(level=Logger.Level.WARN)
    @Message(id=1, value="internal server error.")
    void internalServerError(@Cause Throwable cause);


    @LogMessage(level=Logger.Level.WARN)
    @Message(id=2, value="not Found.")
    void notFound(@Cause Throwable cause);


    @LogMessage(level=Logger.Level.DEBUG)
    @Message(id=3, value="Customer query failed, customerid:%s, user:%s")
    void customerLookupFailed(Long customerid, String username);

    
}
