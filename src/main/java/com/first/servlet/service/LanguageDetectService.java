package com.first.servlet.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LanguageDetectService {
    public String detectLanguage(HttpServletRequest request) {
        if (request.getParameterMap().containsKey("customLanguage")) {
            String lang = request.getParameter("customLanguage");
            if (lang.length() > 0) {
                return lang;
            }
        }

        if (request.getParameterMap().containsKey("lang")) {
            String lang = request.getParameter("lang");
            if (lang.length() > 0) {
                return lang;
            }
        }

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies) {
            if (cookie.getName().equals("lang")) {
                return cookie.getValue();
            }
        }

        return "en";
    }
}
