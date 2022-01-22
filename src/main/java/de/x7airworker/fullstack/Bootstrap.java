package de.x7airworker.fullstack;


import de.x7airworker.fullstack.controller.FrontendHandler;
import de.x7airworker.fullstack.controller.NotFoundController;
import org.javawebstack.httpserver.HTTPServer;
import org.javawebstack.webutils.middleware.CORSPolicy;

public class Bootstrap {
    public static void main(String[] args) {
        HTTPServer server = new HTTPServer()
                .port(3000)
                .beforeInterceptor(new CORSPolicy("*"))
                .notFound(new FrontendHandler(new NotFoundController()))
                .staticResourceDirectory("/assets", Bootstrap.class.getClassLoader(), "web/assets")
                .staticDirectory("/assets", "src/main/resources/web/assets")
                .start();
    }
}
