package me.ershad;

import me.ershad.entity.Book;
import me.ershad.entity.User;
import me.ershad.repository.BookRepo;
import me.ershad.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.Collator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableSwagger2
public class RestApiApplication {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(){
        return args -> {
            List<User> users = Stream.of(
                    new User(null, "Ershad Ahamed", "ershad", "password", "ershadahamed@hotmail.com"),
                    new User(null, "Ahmad Ali", "ahmad", "password", "ahmad@xyz.com")
            ).collect(Collectors.toList());
            userRepo.saveAll(users);

            List<Book> books = Stream.of(
                    new Book(null, "title", "isbln", "Ershad", 23)
            ).collect(Collectors.toList());
            bookRepo.saveAll(books);
        };
    }
}
