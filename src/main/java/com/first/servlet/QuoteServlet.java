package com.first.servlet;

import com.first.servlet.service.LanguageDetectService;
import com.first.servlet.service.QuoteService;
import com.first.servlet.service.SecurityService;
import com.first.servlet.service.ServiceRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/quote")
public class QuoteServlet extends HttpServlet {
    private QuoteService quoteService;
    private LanguageDetectService languageDetectService;
    private SecurityService securityService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        quoteService = ServiceRepository.getInstance().getService(QuoteService.class);
        languageDetectService = ServiceRepository.getInstance().getService(LanguageDetectService.class);
        securityService = ServiceRepository.getInstance().getService(SecurityService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (!securityService.isLoggedIn(session)) {
            resp.sendRedirect("/login");
            return;
        }

        Integer viewCount = (Integer) session.getAttribute("viewCount");
        if (viewCount == null) {
            viewCount = 0;
        }
        viewCount++;
        session.setAttribute("viewCount", viewCount);

        String language = languageDetectService.detectLanguage(req);

        if (!quoteService.hasLanguage(language)) {
            language = "en";
        }

        resp.addCookie(new Cookie("lang", language));

        String quote = null;

        boolean isConcreteId = req.getParameterMap().containsKey("id");
        if (isConcreteId) {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                quote = quoteService.getQuoteByIndex(language, id);
            } catch (NumberFormatException e) {
                quote = quoteService.getRandomQuote(language);
            }
        } else {
            quote = quoteService.getRandomQuote(language);
        }

        req.setAttribute("quote", quote);

        req.setAttribute("language", language);
        req.setAttribute("languages", quoteService.getLanguages());

        req.getRequestDispatcher("jsp/quote.jsp").forward(req, resp);
    }
}
