package com.distribuida;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(
        title = "app-authors",
        version = "4.0.0",
        license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html"),
        termsOfService = "Educational Purposes 2023",
        contact = @Contact(
                name = "seckq",
                email = "seckq@example.com",
                url = "distribuida.com"
        )
))
public class RestApp extends Application {
}
