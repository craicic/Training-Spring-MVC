package me.craicic.mvc.service;

import me.craicic.mvc.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserService {

    final private AppUserRepository userRepo;

    @Autowired
    public AppUserService(AppUserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
