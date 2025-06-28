package com.javarush.jira;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "spring.mail.host=smtp.gmail.com",
        "spring.mail.username=jira4jr@gmail.com",
        "spring.mail.password=zdfzsrqvgimldzyj"
})
abstract class BaseTests {
}
