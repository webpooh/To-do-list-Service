package todo.list.service.domain;

import java.util.*;
import lombok.*;
import todo.list.service.domain.*;
import todo.list.service.infra.AbstractEvent;

@Data
@ToString
public class TaskCreated extends AbstractEvent {

    private Object taskId;
}
