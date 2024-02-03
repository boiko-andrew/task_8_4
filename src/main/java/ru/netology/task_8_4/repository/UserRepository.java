package ru.netology.task_8_4.repository;

import org.springframework.stereotype.Repository;
import ru.netology.task_8_4.model.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<User> users = new ArrayList<>();

        // Add user with admin authorities
        User admin = new User("admin", "admin_password");
        admin.addAuthority(Authorities.READ);
        admin.addAuthority(Authorities.WRITE);
        admin.addAuthority(Authorities.DELETE);
        users.add(admin);

        // Add user with manager authorities
        User manager = new User("manager", "manager_password");
        manager.addAuthority(Authorities.READ);
        manager.addAuthority(Authorities.WRITE);
        users.add(manager);

        // Add user with general user authorities
        User generalUser = new User("general_user", "general_user_password");
        generalUser.addAuthority(Authorities.READ);
        users.add(generalUser);

        // Add guest user without any authorities
        User guest = new User("guest", "guest_password");
        users.add(guest);

        List<Authorities> authorities = new ArrayList<>();
        for (User singleUser : users) {
            if (singleUser.getUser().equals(user)
                    && singleUser.getPassword().equals(password)) {
                authorities = singleUser.getAuthorities();
                break;
            }
        }
        return authorities;
    }
}