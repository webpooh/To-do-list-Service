package todo.list.service.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import todo.list.service.UserAuthenticationApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { UserAuthenticationApplication.class })
public class CucumberSpingConfiguration {}
