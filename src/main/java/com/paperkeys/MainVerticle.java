package com.paperkeys;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;

/**
 * Created by dendy on 10/30/16.
 */
public class MainVerticle extends AbstractVerticle {

    private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

    @Override
    public void start() throws Exception {
        super.start();

        final Router router = Router.router(vertx);
        router.route().handler(ctx -> {
           ctx.response().end("Hello World!");
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(10000);
        LOG.info("Server started on port 1000");
    }
}
