package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.dao.AuthorRepository;
import guru.springframework.spring5webapp.dao.BookRepository;
import guru.springframework.spring5webapp.dao.PublisherRepository;
import guru.springframework.spring5webapp.entity.Author;
import guru.springframework.spring5webapp.entity.Book;
import guru.springframework.spring5webapp.entity.Publisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author alex = new Author("Alex", "Sanak");
        Publisher publisher = new Publisher("Super publisher", "best addres");
        Book first = new Book("My life", "123", publisher);

        alex.getBooks().add(first);
        first.getAuthors().add(alex);

        authorRepository.save(alex);
        publisherRepository.save(publisher);
        bookRepository.save(first);

        Author peter = new Author("Peter", "Josh");
        Publisher publisher2 = new Publisher("Not Super publisher", "the worst addres");
        Book second = new Book("Not my life", "228", publisher2);

        peter.getBooks().add(second);
        second.getAuthors().add(peter);

        authorRepository.save(peter);
        publisherRepository.save(publisher2);
        bookRepository.save(second);

    }
}
