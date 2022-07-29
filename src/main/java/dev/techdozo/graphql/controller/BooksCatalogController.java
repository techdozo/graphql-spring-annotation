package dev.techdozo.graphql.controller;

import dev.techdozo.graphql.domain.model.Book;
import dev.techdozo.graphql.domain.model.Rating;
import dev.techdozo.graphql.domain.service.BookCatalogService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

@Controller
public class BooksCatalogController {

  private final BookCatalogService bookCatalogService;

  public BooksCatalogController(BookCatalogService bookCatalogService) {
    this.bookCatalogService = bookCatalogService;
  }

  @QueryMapping()
  public Collection<Book> books() {
    return bookCatalogService.getBooks();
  }

  @QueryMapping
  public Book bookById(@Argument Integer id) {
    return bookCatalogService.bookById(id);
  }

  @SchemaMapping
  public List<Rating> ratings(Book book) {
    return bookCatalogService.ratings(book);
  }

//  @SchemaMapping(typeName = "Query", field = "books")
//  public Collection<Book> books() {

//    return bookCatalogService.getBooks();

//  }
//  @SchemaMapping(typeName = "Query")
//  public Book bookById(@Argument("id") Integer id) {
//    return bookCatalogService.bookById(id);

//  }


}
