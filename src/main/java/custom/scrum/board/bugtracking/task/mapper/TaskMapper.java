package custom.scrum.board.bugtracking.task.mapper;

import custom.scrum.board.bugtracking.task.Task;
import custom.scrum.board.bugtracking.task.to.TaskTo;
import custom.scrum.board.common.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<Task, TaskTo> {

    @Override
    TaskTo toTo(Task task);
}
