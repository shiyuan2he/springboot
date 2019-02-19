package com.hsy.springboot.oauth.server.service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.oauth2.client.service
 * @date 19/02/2019 18:17
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2019 shiyuan4work@126.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

    private final static Set<User> users = new HashSet<>();

    static {
        users.add(new User("aa", "test-user1", getAuthority()));
        users.add(new User("bb", "test-user2", getAuthority()));
        users.add(new User("cc", "test-user3", getAuthority()));
        users.add(new User("dd", "test-user4", getAuthority()));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = users.stream()
                .filter((u) -> u.getUsername().equals(username))
                .findFirst();
        if (!user.isPresent())
            throw new UsernameNotFoundException("there's no user founded!");
        else
            return user.get();
    }

    private static List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
