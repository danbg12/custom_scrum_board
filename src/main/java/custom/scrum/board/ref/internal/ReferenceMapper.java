package custom.scrum.board.ref.internal;

import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.TimestampMapper;
import custom.scrum.board.ref.RefTo;
import org.mapstruct.Mapper;

@Mapper(config = TimestampMapper.class)
public interface ReferenceMapper extends BaseMapper<Reference, RefTo> {
}
