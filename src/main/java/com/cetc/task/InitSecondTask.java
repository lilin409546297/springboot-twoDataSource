package com.cetc.task;

import com.cetc.domain.second.User;
import com.cetc.repository.second.UserSecondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitSecondTask implements CommandLineRunner{

    @Autowired
    private UserSecondRepository userSecondRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("test");
        user.setAge(25);
        userSecondRepository.save(user);
    }
}
