package ru.bgpu.autumn.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.bgpu.autumn.models.*;
import ru.bgpu.autumn.repositories.*;
import ru.bgpu.autumn.services.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public CommandLineRunner initData(
            GroupRepository groupRepository,
            UserRepository userRepository,
            TagRepository tagRepository,
            VoteRepository voteRepository,
            QuestionRepository questionRepository,
            AnswerOptionRepository answerOptionRepository,
            VoteAnswerRepository voteAnswerRepository) {

        return args -> {
            Group userGroup = groupRepository.save(new Group(null, "USER", Set.of()));
            Group adminGroup = groupRepository.save(new Group(null, "ADMIN", Set.of()));

            User admin = userRepository.save(new User(null, "admin", Set.of(adminGroup)));
            User user1 = userRepository.save(new User(null, "user1", Set.of(userGroup)));
            User user2 = userRepository.save(new User(null, "user2", Set.of(userGroup)));

            Tag techTag = tagRepository.save(new Tag(null, "tech", Set.of()));
            Tag sportTag = tagRepository.save(new Tag(null, "sport", Set.of()));

            Vote vote = new Vote();
            vote.setTitle("Main Vote");
            vote.setStartDate(LocalDateTime.now());
            vote.setEndDate(LocalDateTime.now().plusDays(7));
            vote.setTags(Set.of(techTag, sportTag));
            vote = voteRepository.save(vote);

            Question q1 = new Question();
            q1.setText("What is your favorite programming language?");
            q1.setAllowMultiple(false);
            q1.setVote(vote);
            q1 = questionRepository.save(q1);

            AnswerOption a1 = answerOptionRepository.save(new AnswerOption(null, "Java", q1));
            AnswerOption a2 = answerOptionRepository.save(new AnswerOption(null, "Python", q1));
            AnswerOption a3 = answerOptionRepository.save(new AnswerOption(null, "JavaScript", q1));

            Question q2 = new Question();
            q2.setText("How much experience do you have?");
            q2.setAllowMultiple(false);
            q2.setVote(vote);
            q2 = questionRepository.save(q2);

            AnswerOption a4 = answerOptionRepository.save(new AnswerOption(null, "0-1 years", q2));
            AnswerOption a5 = answerOptionRepository.save(new AnswerOption(null, "1-3 years", q2));
            AnswerOption a6 = answerOptionRepository.save(new AnswerOption(null, "3+ years", q2));

            List<User> users = List.of(admin, user1, user2);
            Random random = new Random();

            for (User user : users) {
                VoteAnswer answer1 = new VoteAnswer();
                answer1.setUser(user);
                answer1.setQuestion(q1);
                answer1.setAnswerOption(List.of(a1, a2, a3).get(random.nextInt(3)));
                answer1.setCreatedAt(LocalDateTime.now());
                voteAnswerRepository.save(answer1);

                VoteAnswer answer2 = new VoteAnswer();
                answer2.setUser(user);
                answer2.setQuestion(q2);
                answer2.setAnswerOption(List.of(a4, a5, a6).get(random.nextInt(3)));
                answer2.setCreatedAt(LocalDateTime.now());
                voteAnswerRepository.save(answer2);
            }

            System.out.println("=== Dev data initialized ===");
            System.out.println("Groups: " + groupRepository.count());
            System.out.println("Users: " + userRepository.count());
            System.out.println("Tags: " + tagRepository.count());
            System.out.println("Votes: " + voteRepository.count());
            System.out.println("Questions: " + questionRepository.count());
            System.out.println("Answers: " + answerOptionRepository.count());
            System.out.println("VoteAnswers: " + voteAnswerRepository.count());
        };
    }
}