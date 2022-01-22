package de.x7airworker.fullstack;


import de.x7airworker.fullstack.controller.FrontendHandler;
import de.x7airworker.fullstack.controller.NotFoundController;
import org.javawebstack.httpserver.HTTPServer;
import org.javawebstack.webutils.middleware.CORSPolicy;
import org.javawebstack.webutils.middleware.SerializedResponseTransformer;

public class Bootstrap {
    public static void main(String[] args) {
        HTTPServer server = new HTTPServer()
                .port(3000) // set port to 3000
                .responseTransformer(new SerializedResponseTransformer().ignoreStrings()) // add response transformer for models
                .beforeInterceptor(new CORSPolicy("*")) // Open CORS (you can disable this if you want, because the Frontend runs on same domain)
                .notFound(new FrontendHandler(new NotFoundController())) // FrontendHandler runs and serves index.html when no route is found (so the Vue router can handle it), if its an API handler then the NotFoundController will be run
                .staticDirectory("/assets", "src/main/resources/web/assets") // setup for development
                .staticResourceDirectory("/assets", Bootstrap.class.getClassLoader(), "web/assets") // setup for production
                .start(); // Startup the webserver
    }
}
