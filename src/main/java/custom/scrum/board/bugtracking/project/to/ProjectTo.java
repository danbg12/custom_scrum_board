package custom.scrum.board.bugtracking.project.to;

import custom.scrum.board.common.to.TitleTo;
import custom.scrum.board.common.util.validation.Code;
import custom.scrum.board.common.util.validation.Description;
import lombok.Getter;

@Getter
public class ProjectTo extends TitleTo {
    @Description
    String description;

    @Code
    String typeCode;

    Long parentId;

    public ProjectTo(Long id, String code, String title, String description, String typeCode, Long parentId) {
        super(id, code, title);
        this.description = description;
        this.typeCode = typeCode;
        this.parentId = parentId;
    }
}
