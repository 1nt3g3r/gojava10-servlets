package com.first.servlet;

import com.first.servlet.service.LanguageDetectService;
import com.first.servlet.service.QuoteService;
import com.first.servlet.service.ServiceRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addQuote")
public class AddQuoteServlet extends HttpServlet {
    private QuoteService quoteService;
    private LanguageDetectService languageDetectService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        quoteService = ServiceRepository.getInstance().getService(QuoteService.class);
        languageDetectService = ServiceRepository.getInstance().getService(LanguageDetectService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String language = languageDetectService.detectLanguage(req);

        String quote = req.getParameter("quoteText");
        quoteService.addQuote(language, quote);

        resp.sendRedirect("/quote");
    }
}
