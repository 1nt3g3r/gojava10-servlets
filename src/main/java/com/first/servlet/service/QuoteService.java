package com.first.servlet.service;

import java.util.*;

public class QuoteService {
    private Map<String, List<String>> quotes = new HashMap<String, List<String>>();

    private Random random = new Random();

    public QuoteService() {
        addQuote("en", "Carry out a random act of kindness, with no expectation of reward, safe in the knowledge that one day someone might do the same for you");
        addQuote("en", "A censor is a man who knows more than he thinks you ought to.");
        addQuote("en", "When I meet a man I ask myself, 'Is this the man I want my children to spend their weekends with?'");

        addQuote("ua", "Не водіть машину швидше, ніж літає Ваш ангел-охоронець.");
        addQuote("ua", "А який сенс купувати машину, щоб їздити по асфальту? Там, де асфальт, нічого цікавого, а де цікаво, там немає асфальту.");
        addQuote("ua", "Мій тато — геній. Він може взяти машину, яка майже не їздить, і зробити з неї машину, яка не їздить зовсім.");
    }

    public void addQuote(String language, String quote) {
        getQuotes(language).add(quote);
    }

    public List<String> getQuotes(String language) {
        if (!quotes.containsKey(language)) {
            List<String> quoteList = new ArrayList<String>();
            quotes.put(language, quoteList);
        }

        return quotes.get(language);
    }

    public String getRandomQuote(String language) {
        List<String> langQuotes = getQuotes(language);
        int index = random.nextInt(langQuotes.size());
        return langQuotes.get(index);
    }

    public String getQuoteByIndex(String language, int index) {
        return getQuotes(language).get(index);
    }

    public boolean hasLanguage(String language) {
        return quotes.containsKey(language);
    }

    public List<String> getLanguages() {
        List<String> result = new ArrayList<String>();
        for(String language: quotes.keySet()) {
            result.add(language);
        }
        return result;
    }
}
