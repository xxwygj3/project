package com.sbtest.projectjdbc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

public class MessageSourceAccessor {
    @Autowired
    ResourceBundleMessageSource messageSource;

    public MessageSourceAccessor(ResourceBundleMessageSource messageSource){
        this.messageSource = messageSource;
    }
    /**
     * 根据 key
     *
     * @param messageKey
     * @return
     */
    public String getMessage(String messageKey) {
        String message = messageSource.getMessage(messageKey, null, null);
        return message;
    }

    /**
     * 根据 key,参数
     *
     * @param messageKey
     * @param args
     * @return
     */
    public String getMessage(String messageKey, Object... args) {
        String message = messageSource.getMessage(messageKey, args, null);
        return message;
    }
}
