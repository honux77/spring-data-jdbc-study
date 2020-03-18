package honux;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class User {

    @Id
    Long id;

    String email;
    String name;
    LocalDate createdDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
