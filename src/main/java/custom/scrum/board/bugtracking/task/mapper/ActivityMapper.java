package custom.scrum.board.bugtracking.task.mapper;

import custom.scrum.board.bugtracking.task.Activity;
import custom.scrum.board.bugtracking.task.to.ActivityTo;
import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.error.DataConflictException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ActivityMapper extends BaseMapper<Activity, ActivityTo> {
    static long checkTaskBelong(long taskId, Activity dbActivity) {
        if (taskId != dbActivity.getTaskId())
            throw new DataConflictException("Activity " + dbActivity.id() + " doesn't belong to Task " + taskId);
        return taskId;
    }

    @Override
    @Mapping(target = "taskId", expression = "java(ActivityMapper.checkTaskBelong(activityTo.getTaskId(), activity))")
    Activity updateFromTo(ActivityTo activityTo, @MappingTarget Activity activity);
}
