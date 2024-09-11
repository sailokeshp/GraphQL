package com.project.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author(Integer id, String name) {
    public static List<Author> authors = Arrays.asList(
        new Author(1, "Lokesh"),
        new Author(2, "Lokesh1"),
        new Author(3, "Lokesh2"),
        new Author(4, "Lokesh3")
    );

    public static Optional<Author> getAuthorById(Integer id) {
        return authors.stream().filter(b -> b.id.equals(id)).findFirst();
    }
}
