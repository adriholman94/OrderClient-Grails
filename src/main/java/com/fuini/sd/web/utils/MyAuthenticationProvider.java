package com.fuini.sd.web.utils;

import com.fuini.sd.web.beans.Role.RoleB;
import com.fuini.sd.web.beans.User.UserB;
import com.fuini.sd.web.service.User.IUserService;
import grails.plugin.springsecurity.userdetails.GrailsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class MyAuthenticationProvider implements AuthenticationProvider {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private IUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String username = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());

        UserB user = getUser(username);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getUserPassword())) {
                List<GrantedAuthority> authorities = getUserRoles(user);
                if (authorities != null) {

                    GrailsUser userDetails = new GrailsUser(username, password, true, true, true, true, authorities, 1);
                    UsernamePasswordAuthenticationToken token = new     UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

                    token.setDetails(authentication.getDetails());

                    return token;
                } else {
                    throw new BadCredentialsException("Log in failed: El usuario no tiene ningun rol");
                }
            } else {
                throw new BadCredentialsException("Log in failed: Contraseña incorrecta");
            }
        }else throw new BadCredentialsException("Log in failed: El usuario especificado no existe");

        //return auth;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

    private UserB getUser(String userName) {
        return userService.getByUserName(userName);
    }

    private List<GrantedAuthority> getUserRoles(UserB user) {
        List<GrantedAuthority> list = new ArrayList<>();

        final List<RoleB> roles = user.getRole();
        System.out.println("Revisando roles");
        if (roles != null) {
            System.out.println("Roles del usuario: " + user.getUserName());
            for (RoleB roleB : roles) {
                list.add(new SimpleGrantedAuthority(roleB.getRoleName()));
            }
        }
        return list;
    }
}
