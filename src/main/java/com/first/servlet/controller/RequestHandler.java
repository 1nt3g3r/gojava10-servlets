package com.first.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RequestHandler {
    void process(HttpServletRequest request, HttpServletResponse response);
}
