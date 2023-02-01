package com.zhangbaohpu.springboot.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LocaleMessageSourceService {
    @Autowired
    private MessageSource messageSource;

    /**
     * ИљОн
     * @param messageKey
     * @return
     */
    public String getMessage(String messageKey) {
        String message = messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
        return message;
    }
    public String getOkMessage() {
        String message = messageSource.getMessage("result.msg.success", null, LocaleContextHolder.getLocale());
        return message;
    }
    public String getErrorMessage() {
        String message = messageSource.getMessage("result.msg.error", null, LocaleContextHolder.getLocale());
        return message;
    }
    public Object getErrorMessageByHand(String msg) {
        String message = messageSource.getMessage(msg, null, LocaleContextHolder.getLocale());
        return message;
    }
}


