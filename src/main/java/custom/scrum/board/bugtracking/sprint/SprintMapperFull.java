package custom.scrum.board.bugtracking.sprint;

import custom.scrum.board.bugtracking.sprint.to.SprintToFull;
import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.TimestampMapper;
import org.mapstruct.Mapper;

@Mapper(config = TimestampMapper.class)
public interface SprintMapperFull extends BaseMapper<Sprint, SprintToFull> {
}
