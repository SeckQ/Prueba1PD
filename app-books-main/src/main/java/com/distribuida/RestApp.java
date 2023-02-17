package com.distribuida;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;


@OpenAPIDefinition(info = @Info(
        title = "app-books-main",
        version = "4.0.0",
        license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html"),
        termsOfService = "Educational Purposes 2023",
        contact = @Contact(
                name = "seckq",
                email = "seckq@example.com",
                url = "distribuida.com"
        )
))
@ApplicationPath("/")
public class RestApp extends Application {
}
