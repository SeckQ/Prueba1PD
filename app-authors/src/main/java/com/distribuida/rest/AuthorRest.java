package com.distribuida.rest;

import com.distribuida.db.Author;
import com.distribuida.servicios.AuthorService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRest {

    @Inject
    private AuthorService authorRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Find Author by Id", operationId = "findAuthorById")
    @APIResponse(name = "Success Find Author by Id", responseCode = "200", description = "Author Founded by Id", content =
    @Content(mediaType = "application/json", schema = @Schema(implementation = Author.class)))
    @APIResponse(name = "Error Find Author by Id", responseCode = "500", description = "Author not Founded By Id")
    public Author findAuthorById(@PathParam("id") Long id){
        System.out.println("Consultando Servicio findAuthorById*******************");
        return authorRepository.findAuthorById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Find All Authors", operationId = "findAllAuthors")
    @APIResponse(name = "Success Find All Authors",responseCode = "201", description = "Find All Authors", content =
    @Content(mediaType = "application/json", schema = @Schema(allOf = Author.class)))
    public List<Author> findAllAuthors(){
        System.out.println("Consultando Servicio findAllAuthors*******************");
        return authorRepository.findAllAuthors();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Insert Author", operationId = "insertAuthor")
    @APIResponse(name = "Success Insert Author",responseCode = "202", description = "Author Inserted")
    @APIResponse(name = "Error Insert Author",responseCode = "502", description = "Error Inserting Author")
    public void insertAuthor(Author author) {
        System.out.println("Consultando Servicio insertAuthor*******************");
        authorRepository.insertAuthor(author);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Update Author by Id", operationId = "updateAuthor")
    @APIResponse(name = "Success Update Author",responseCode = "203", description = "Author Updated")
    @APIResponse(name = "Error Update Author",responseCode = "503", description = "Error Updating Author")
    public void updateAuthor(Author author, @PathParam("id") Long id) {
        System.out.println("Consultando Servicio updateAuthor*******************");
        authorRepository.updateAuthor(author, id);

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Delete Author by Id", operationId = "deleteAuthor")
    @APIResponse(name = "Success Delete Author", responseCode = "204", description = "Author Deleted")
    @APIResponse(name = "Error Delete Author", responseCode = "504", description = "Error Deleting Author")
    public void deleteAuthor(@PathParam("id") Long id) {
        System.out.println("Consultando Servicio deleteAuthor*******************");
        authorRepository.deleteAuthor(id);
    }
}
