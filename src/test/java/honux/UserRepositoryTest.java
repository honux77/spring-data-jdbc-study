package honux;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Test
    @Transactional
    public void createUserTest() {
        User user = new User();
        user.createdDate = LocalDate.now();
        user.name = "Hoyoung";
        user.email = "honux77@gmail.com";

        logger.debug("User before save: {}", user);

        User saved = userRepository.save(user);
        assertThat(saved.id).isNotNull();
        logger.debug("User after save: {}", saved);

        saved.name = "Hoyoung Kim";

        userRepository.save(saved);

        Optional<User> reloaded = userRepository.findById(saved.id);

        assertThat(reloaded).isNotEmpty();

        assertThat(reloaded.get().name).isEqualTo(saved.name);
        logger.debug("User after update: {}", reloaded.get());
    }
}
