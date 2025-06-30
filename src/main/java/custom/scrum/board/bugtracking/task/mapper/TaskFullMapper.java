package custom.scrum.board.bugtracking.task.mapper;

import custom.scrum.board.bugtracking.task.Task;
import custom.scrum.board.bugtracking.task.to.TaskToFull;
import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.TimestampMapper;
import org.mapstruct.Mapper;

@Mapper(config = TimestampMapper.class)
public interface TaskFullMapper extends BaseMapper<Task, TaskToFull> {

    @Override
    TaskToFull toTo(Task task);
}
