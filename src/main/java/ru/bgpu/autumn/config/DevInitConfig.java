package ru.bgpu.autumn.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.bgpu.autumn.models.*;
import ru.bgpu.autumn.repositories.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Component
@Profile("dev")
public class DevInitConfig implements CommandLineRunner {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final VoteRepository voteRepository;
    private final QuestionRepository questionRepository;
    private final AnswerOptionRepository answerOptionRepository;
    private final VoteAnswerRepository voteAnswerRepository;

    public DevInitConfig(GroupRepository groupRepository, UserRepository userRepository,
                         TagRepository tagRepository, VoteRepository voteRepository,
                         QuestionRepository questionRepository,
                         AnswerOptionRepository answerOptionRepository,
                         VoteAnswerRepository voteAnswerRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.voteRepository = voteRepository;
        this.questionRepository = questionRepository;
        this.answerOptionRepository = answerOptionRepository;
        this.voteAnswerRepository = voteAnswerRepository;
    }

    @Override
    public void run(String... args) {
        Group userGroup = groupRepository.save(new Group("USER"));
        Group adminGroup = groupRepository.save(new Group("ADMIN"));

        User admin = userRepository.save(new User("admin"));
        admin.getGroups().add(adminGroup);
        userRepository.save(admin);

        User user1 = userRepository.save(new User("user1"));
        user1.getGroups().add(userGroup);
        userRepository.save(user1);

        User user2 = userRepository.save(new User("user2"));
        user2.getGroups().add(userGroup);
        userRepository.save(user2);

        Tag techTag = tagRepository.save(new Tag("tech"));
        Tag sportTag = tagRepository.save(new Tag("sport"));

        Vote vote = new Vote();
        vote.setTitle("Любимые языки программирования");
        vote.setStartDate(LocalDateTime.now());
        vote.setEndDate(LocalDateTime.now().plusDays(7));
        vote.getTags().add(techTag);
        vote.getTags().add(sportTag);
        vote = voteRepository.save(vote);

        Question q1 = new Question();
        q1.setText("Какой язык ты используешь чаще всего?");
        q1.setAllowMultiple(false);
        q1.setVote(vote);
        q1 = questionRepository.save(q1);

        AnswerOption a1 = answerOptionRepository.save(new AnswerOption("Java"));
        a1.setQuestion(q1);
        answerOptionRepository.save(a1);
        AnswerOption a2 = answerOptionRepository.save(new AnswerOption("Python"));
        a2.setQuestion(q1);
        answerOptionRepository.save(a2);
        AnswerOption a3 = answerOptionRepository.save(new AnswerOption("JavaScript"));
        a3.setQuestion(q1);
        answerOptionRepository.save(a3);

        Question q2 = new Question();
        q2.setText("Сколько лет опыта?");
        q2.setAllowMultiple(false);
        q2.setVote(vote);
        q2 = questionRepository.save(q2);

        AnswerOption a4 = answerOptionRepository.save(new AnswerOption("0-1 год"));
        a4.setQuestion(q2);
        answerOptionRepository.save(a4);
        AnswerOption a5 = answerOptionRepository.save(new AnswerOption("1-3 года"));
        a5.setQuestion(q2);
        answerOptionRepository.save(a5);
        AnswerOption a6 = answerOptionRepository.save(new AnswerOption("3+ лет"));
        a6.setQuestion(q2);
        answerOptionRepository.save(a6);

        Random random = new Random();
        List<User> users = List.of(admin, user1, user2);

        for (User user : users) {
            VoteAnswer va1 = new VoteAnswer();
            va1.setUser(user);
            va1.setQuestion(q1);
            va1.setAnswerOption(List.of(a1, a2, a3).get(random.nextInt(3)));
            va1.setCreatedAt(LocalDateTime.now());
            voteAnswerRepository.save(va1);

            VoteAnswer va2 = new VoteAnswer();
            va2.setUser(user);
            va2.setQuestion(q2);
            va2.setAnswerOption(List.of(a4, a5, a6).get(random.nextInt(3)));
            va2.setCreatedAt(LocalDateTime.now());
            voteAnswerRepository.save(va2);
        }
    }
}