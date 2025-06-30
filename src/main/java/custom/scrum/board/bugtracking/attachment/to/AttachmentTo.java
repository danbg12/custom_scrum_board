package custom.scrum.board.bugtracking.attachment.to;

import custom.scrum.board.common.to.NamedTo;
import lombok.Getter;

@Getter
public class AttachmentTo extends NamedTo {
    public AttachmentTo(Long id, String name) {
        super(id, name);
    }
}
