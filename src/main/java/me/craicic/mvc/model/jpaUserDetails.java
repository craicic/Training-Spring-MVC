package me.craicic.mvc.model;

import me.craicic.mvc.model.entity.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class jpaUserDetails implements UserDetails {

    private final AppUser appUser;

    public jpaUserDetails(AppUser appUser) {
        this.appUser = appUser;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of permissions (name)
        this.appUser.getPermissionList().forEach(p -> authorities.add(new SimpleGrantedAuthority(p)));

        // Extract list of roles (ROLE_name)
        this.appUser.getRoleList().forEach(r -> authorities.add(new SimpleGrantedAuthority("ROLE_" + r)));

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.appUser.getMainPassword();
    }

    @Override
    public String getUsername() {
        return this.appUser.getMainUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
