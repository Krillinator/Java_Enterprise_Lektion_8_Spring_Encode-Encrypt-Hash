package com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.config.security;

import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.model.CustomUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;

    public CustomUserDetails(String username, String password,
                             Collection<? extends GrantedAuthority> authorities,
                             boolean accountNonExpired, boolean accountNonLocked,
                             boolean credentialsNonExpired, boolean enabled) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public CustomUserDetails(CustomUser customUser) {
        this.username = customUser.getUsername();
        this.password = customUser.getPassword();
        this.authorities = customUser.getAuthorities();
        this.accountNonExpired = customUser.isAccountNonExpired();
        this.accountNonLocked = customUser.isAccountNonLocked();
        this.credentialsNonExpired = customUser.isCredentialsNonExpired();
        this.enabled = customUser.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
