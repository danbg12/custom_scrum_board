package custom.scrum.board.bugtracking.task.mapper;

import custom.scrum.board.bugtracking.project.ProjectMapper;
import custom.scrum.board.bugtracking.sprint.SprintMapper;
import custom.scrum.board.bugtracking.task.Task;
import custom.scrum.board.bugtracking.task.to.TaskToExt;
import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.TimestampMapper;
import custom.scrum.board.common.error.DataConflictException;
import custom.scrum.board.login.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = TimestampMapper.class, uses = {SprintMapper.class, ProjectMapper.class})
public interface TaskExtMapper extends BaseMapper<Task, TaskToExt> {

    static long checkProjectBelong(long projectId, Task dbTask) {
        if (projectId != dbTask.getProjectId())
            throw new DataConflictException("Task " + dbTask.id() + " doesn't belong to Project " + projectId);
        return projectId;
    }

    static long checkUserAuthorities(long sprintId, Task dbTask) {
        if (sprintId != dbTask.getSprintId() && !(AuthUser.get().isAdmin() || AuthUser.get().isManager()))
            throw new DataConflictException("Do not have authorities to change task's sprint");
        return sprintId;
    }

    @Override
    TaskToExt toTo(Task task);

    @Override
    @Mapping(target = "projectId", expression = "java(TaskExtMapper.checkProjectBelong(taskToExt.getProjectId(), task))")
    @Mapping(target = "sprintId", expression = "java(TaskExtMapper.checkUserAuthorities(taskToExt.getSprintId(), task))")
    Task updateFromTo(TaskToExt taskToExt, @MappingTarget Task task);
}
