package com.distribuida.db;

import lombok.Data;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;

@Entity
@Schema(name = "author",description = "Schema of Author", title = "Author Schema")
@Table(name = "authors")
@Data
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(required = true,example = "FirstName", minimum = "1", maximum = "100", description = "String")
    private String first_name;

    @Schema(required = true,example = "LastName", minimum = "1", maximum = "100", description = "String")
    private String last_name;

}