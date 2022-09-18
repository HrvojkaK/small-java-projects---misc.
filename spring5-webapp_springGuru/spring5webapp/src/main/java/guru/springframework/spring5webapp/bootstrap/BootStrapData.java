package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author alan = new Author("Alan", "Alanson");
        Book alanBook = new Book("Alaning: a book of Alans","12345");
        alan.getBooks().add(alanBook);
        alanBook.getAuthors().add(alan);

        authorRepository.save(alan);
        bookRepository.save(alanBook);

        Author ana = new Author("Ana", "Annison");
        Book anaBook = new Book("A book by Ana","12346");
        ana.getBooks().add(anaBook);
        anaBook.getAuthors().add(ana);

        authorRepository.save(ana);
        bookRepository.save(anaBook);

        Publisher alphaPrint = new Publisher("Alpha Print", "Street 1", "Big City");
        publisherRepository.save(alphaPrint);

        alanBook.setPublisher(alphaPrint);
        alphaPrint.getBooks().add(alanBook);
        publisherRepository.save(alphaPrint);

        anaBook.setPublisher(alphaPrint);
        alphaPrint.getBooks().add(anaBook);
        publisherRepository.save(alphaPrint);

        System.out.println("In Bootstrap:");
        System.out.println("Num of books: "+bookRepository.count());
        System.out.println("Num of publishers: " + publisherRepository.count());
        System.out.println("Num of publishers books: " + alphaPrint.getBooks().size());


    }
}
