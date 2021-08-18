package com.example.ybmt.jun.spring.web.springoas.message;

import org.jboss.logging.Messages;
import org.jboss.logging.annotations.MessageBundle;
import org.jboss.logging.annotations.Message;

@MessageBundle(projectCode = "WOASR-")
public interface ErrorResponseMessageBundle {
    ErrorResponseMessageBundle MESSAGES = Messages.getBundle(ErrorResponseMessageBundle.class);

    @Message(id = 1, value = "Hello world.")
    String helloworldString();
}
