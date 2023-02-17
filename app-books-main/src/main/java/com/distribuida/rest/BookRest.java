package com.distribuida.rest;

import com.distribuida.clientes.authors.AuthorRestProxy;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookRest {

    @Inject BookRepository bookService;

    @RestClient
    @Inject AuthorRestProxy proxyAuthor;

    /**
     * GET          /books/{id}     buscar un libro por ID
     * GET          /books          listar todos
     * POST         /books          insertar
     * PUT/PATCH    /books/{id}     actualizar
     * DELETE       /books/{id}     eliminar
     */

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Find Book by Id", operationId = "findBookById")
    @APIResponse(name = "Success Find Book by Id", responseCode = "200", description = "Book Founded by Id", content =
    @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)))
    @APIResponse(name = "Error Find Book by Id", responseCode = "500", description = "Book not Founded By Id")
    public Book findBookById(@Parameter(name = "IDFindBookById",description = "Book Id for Find by Id") @PathParam("id")Integer id){
        System.out.println("Consultando Servicio findBookById*******************");
        return bookService.findBookById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Find All Books", operationId = "findAllBooks")
    @APIResponse(name = "Success Find All Books",responseCode = "201", description = "Find All Books", content =
    @Content(mediaType = "application/json", schema = @Schema(allOf = Book.class)))
    public List<Book> findAllBooks (){
        System.out.println("Consultando Servicio findAllBooks*******************");
        return bookService.findAllBooks();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Insert Book", operationId = "insertBook")
    @APIResponse(name = "Success Insert Book",responseCode = "202", description = "Book Inserted")
    @APIResponse(name = "Error Insert Book",responseCode = "502", description = "Error Inserting Book")
    public Response insertBook(@RequestBody(name = "BodyInsertBook",description = "Book Object to Insert",
            required = true,
            content = @Content(schema = @Schema(implementation = Book.class))) Book book){
        System.out.println("Consultando Servicio insertBook*******************");
        bookService.insertBook(book);
        return Response.status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("/{id}")
    @Operation(description = "Update Book by Id", operationId = "updateBook")
    @APIResponse(name = "Sucess Update Book",responseCode = "203", description = "Book Updated")
    @APIResponse(name = "Error Update Book",responseCode = "503", description = "Error Updating Book")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook (@RequestBody(name = "BodyUpdateBook",description = "Book Object to Insert",
            required = true,
            content = @Content(schema = @Schema(implementation = Book.class))) Book book,
                                @Parameter(description = "Book Id") @PathParam("id") Integer id){
        System.out.println("Consultando Servicio updateBook*******************");
        bookService.updateBook(id,book);
        return Response.status((Response.Status.OK) ).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(description = "Delete Book by Id", operationId = "deleteBook")
    @APIResponse(name = "Success Delete Book", responseCode = "204", description = "Book Deleted")
    @APIResponse(name = "Error Delete Book", responseCode = "504", description = "Error Deleting Book")
    public Response deleteBook (@Parameter(name = "DeleteBookId",description = "Book Id") @PathParam("id") Integer id){
        System.out.println("Consultando Servicio deleteBook*******************");
        bookService.deleteBook(id);
        return Response.status((Response.Status.NO_CONTENT) ).build();
    }
}
