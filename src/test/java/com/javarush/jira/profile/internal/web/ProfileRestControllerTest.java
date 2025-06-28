package com.javarush.jira.profile.internal.web;

import com.javarush.jira.AbstractControllerTest;
import com.javarush.jira.login.AuthUser;
import com.javarush.jira.login.Role;
import com.javarush.jira.login.User;
import com.javarush.jira.profile.internal.ProfileMapper;
import com.javarush.jira.profile.internal.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
class ProfileRestControllerTest extends AbstractControllerTest {
    @Autowired
    protected ProfileMapper profileMapper;
    @Autowired
    private ProfileRepository profileRepository;

    private static final String REST_URL = "/api/profile";

    private static final long USER_ID = 7L;
    private static final long GUEST_ID = 100001L;

    private AuthUser getAuthUser(Long id) {
        return new AuthUser(new User(id,
                "moroz_a@gmail.com",
                "password",
                "Александр",
                "Мороз",
                "@Moroz93",
                Role.ADMIN));
    }

    @Test
    void getUnauthorized() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}