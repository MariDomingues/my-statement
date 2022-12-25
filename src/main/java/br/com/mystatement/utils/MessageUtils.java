package br.com.mystatement.utils;

import br.com.mystatement.domain.enums.DefaultErrorParametersEnum;
import br.com.mystatement.domain.enums.ExceptionMessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtils {

    @Autowired
    MessageSource messageSource;

    public String getMessage(ExceptionMessageEnum message, Locale locale) {
        return messageSource.getMessage(message.toString(), null, locale);
    }

    public String getMessage(ExceptionMessageEnum message) {
        return messageSource.getMessage(message.toString(), null, LocaleContextHolder.getLocale());
    }

    public String getMessage(DefaultErrorParametersEnum message) {
        return messageSource.getMessage(message.toString(), null, LocaleContextHolder.getLocale());
    }
}
