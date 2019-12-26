package io.cnad.api;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

/**
 *  * Camel route definitions.
 *   */
public class Routes extends RouteBuilder {

    public Routes() {
	// Add some init stuff
    }

    @Override
    public void configure() throws Exception {

	rest()
    	  .get("/my-get-endpoint")
            .route()
            .setBody(constant("Hello from /my-get-endpoint"))
            .endRest()
    	  .post("/my-post-endpoint")
            .route()
          .setBody(constant("Hello from /my-post-endpoint"))
          .endRest();
        
	from("platform-http:/dummy?httpMethodRestrict=GET,POST")
		.setBody(simple("Hello ${header.name}"));
    }
}
