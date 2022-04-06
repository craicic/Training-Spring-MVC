package me.craicic.mvc.security;

import me.craicic.mvc.model.entity.AppUser;
import me.craicic.mvc.model.jpaUserDetails;
import me.craicic.mvc.repository.AppUserRepository;
import me.craicic.mvc.utils.PasswordManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {


    private static final Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

    final private PasswordManager passwordManager;

    private final AppUserRepository appUserRepository;

    @Autowired
    public JpaUserDetailsService(AppUserRepository appUserRepository, PasswordManager passwordManager) {
        this.appUserRepository = appUserRepository;
        this.passwordManager = passwordManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByMainUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("Wrong login");
        }
        UserDetails details = new jpaUserDetails(appUser);
        logger.info(details.getPassword());
        passwordManager.createTextEncryptor(appUser.getMainUsername(), details.getPassword());
        logger.info(details.toString());
        return details;
    }
}
