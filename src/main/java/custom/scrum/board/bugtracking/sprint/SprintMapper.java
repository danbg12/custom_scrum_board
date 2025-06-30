package custom.scrum.board.bugtracking.sprint;

import custom.scrum.board.bugtracking.sprint.to.SprintTo;
import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.TimestampMapper;
import custom.scrum.board.common.error.DataConflictException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = TimestampMapper.class)
public interface SprintMapper extends BaseMapper<Sprint, SprintTo> {
    static long checkProjectBelong(long projectId, Sprint dbSprint) {
        if (projectId != dbSprint.getProjectId())
            throw new DataConflictException("Sprint " + dbSprint.id() + " doesn't belong to Project " + projectId);
        return projectId;
    }

    @Override
    @Mapping(target = "projectId", expression = "java(SprintMapper.checkProjectBelong(sprintTo.getProjectId(), sprint))")
    Sprint updateFromTo(SprintTo sprintTo, @MappingTarget Sprint sprint);
}
