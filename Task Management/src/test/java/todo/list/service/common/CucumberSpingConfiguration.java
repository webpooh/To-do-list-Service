package todo.list.service.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import todo.list.service.TaskManagementApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { TaskManagementApplication.class })
public class CucumberSpingConfiguration {}
