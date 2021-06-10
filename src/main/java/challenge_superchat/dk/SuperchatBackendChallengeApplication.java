package challenge_superchat.dk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import challenge_superchat.dk.chattdao.ConversationDao;
import challenge_superchat.dk.chattdao.MessageDao;
import challenge_superchat.dk.chattmodel.Message;

@SpringBootApplication
public class SuperchatBackendChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperchatBackendChallengeApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner mappingDemo(ConversationDao conversationDao,
                                         MessageDao messageDao) {
        return args -> {

            // create a new book
         //   Message msg1 = new Message("Java 101", "John Doe", "123456");

            // save the book
           // bookRepository.save(book);

            // create and save new pages
            //pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
            //pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
            //pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));
        };
    }

}
