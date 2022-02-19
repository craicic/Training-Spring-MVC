package me.craicic.mvc.security;

import me.craicic.mvc.model.AppUser;
import me.craicic.mvc.model.CustomUserDetails;
import me.craicic.mvc.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {



    private final AppUserRepository appUserRepository;

    @Autowired
    public JpaUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByPseudo(username);
        return new CustomUserDetails(appUser.getPseudo(), appUser.getPassword(), null);
    }
}
