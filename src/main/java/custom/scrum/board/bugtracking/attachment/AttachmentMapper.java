package custom.scrum.board.bugtracking.attachment;

import custom.scrum.board.bugtracking.attachment.to.AttachmentTo;
import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.TimestampMapper;
import org.mapstruct.Mapper;

@Mapper(config = TimestampMapper.class)
public interface AttachmentMapper extends BaseMapper<Attachment, AttachmentTo> {
}
