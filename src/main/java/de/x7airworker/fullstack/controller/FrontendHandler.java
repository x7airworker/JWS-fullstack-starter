package de.x7airworker.fullstack.controller;

import org.javawebstack.httpserver.Exchange;
import org.javawebstack.httpserver.handler.RequestHandler;
import org.javawebstack.httpserver.helper.MimeType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrontendHandler implements RequestHandler {
    private final RequestHandler fallbackHandler;
    private String indexContent;
    private File devFile = new File("src/main/resources/web/index.html");

    public FrontendHandler(RequestHandler fallbackHandler) {
        this.fallbackHandler = fallbackHandler;
    }

    public String getIndexContent() {
        if (devFile.exists()) {
            try {
                return new Scanner(new FileInputStream(devFile)).useDelimiter("\\Z").next();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (indexContent == null)
            indexContent = new Scanner(getClass().getClassLoader().getResourceAsStream("web/index.html")).useDelimiter("\\Z").next();
        return indexContent;
    }

    @Override
    public Object handle(Exchange exchange) {
        if (exchange.getContentType().equalsIgnoreCase("application/json") || exchange.header("Accept").equalsIgnoreCase("application/json"))
            return fallbackHandler.handle(exchange);
        exchange.contentType(MimeType.HTML);
        return getIndexContent();
    }
}
