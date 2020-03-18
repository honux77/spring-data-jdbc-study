package honux;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleJdbcConfig.class);
        UserRepository repo = (UserRepository) ctx.getBean("userRepository");
        User user = new User();
        user.name = "Hoyoung Jung";
        User savedUser = repo.save(user);
        System.out.println(savedUser);
        User u1 = repo.findById(1L).get();
        System.out.println(u1);
    }
}
