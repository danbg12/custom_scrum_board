package custom.scrum.board.bugtracking.project;

import custom.scrum.board.bugtracking.project.to.ProjectToFull;
import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.TimestampMapper;
import org.mapstruct.Mapper;

@Mapper(config = TimestampMapper.class)
public interface ProjectMapperFull extends BaseMapper<Project, ProjectToFull> {
}
