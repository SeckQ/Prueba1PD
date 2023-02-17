package com.distribuida;

import com.distribuida.config.WebServer;
import com.distribuida.services.AuthorService;
import com.distribuida.services.BookService;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Main {

    public static void main(String[] args) {
        SeContainer seContainer = SeContainerInitializer
                .newInstance()
                .initialize();

        new WebServer(
                seContainer.select(AuthorService.class).get(),
                seContainer.select(BookService.class).get());
    }
}