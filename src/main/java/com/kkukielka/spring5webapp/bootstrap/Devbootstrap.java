package com.kkukielka.spring5webapp.bootstrap;

import com.kkukielka.spring5webapp.model.Author;
import com.kkukielka.spring5webapp.model.Book;
import com.kkukielka.spring5webapp.model.Publisher;
import com.kkukielka.spring5webapp.repositories.AuthorRepository;
import com.kkukielka.spring5webapp.repositories.BookRepository;
import com.kkukielka.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Devbootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public Devbootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "Nowhere");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "Somewhere");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);

    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
