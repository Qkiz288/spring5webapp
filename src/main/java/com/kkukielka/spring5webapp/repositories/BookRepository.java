package com.kkukielka.spring5webapp.repositories;

import com.kkukielka.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
