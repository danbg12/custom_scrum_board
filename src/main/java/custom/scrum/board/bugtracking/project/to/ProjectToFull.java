package custom.scrum.board.bugtracking.project.to;

import custom.scrum.board.common.to.CodeTo;
import lombok.Value;

@Value
public class ProjectToFull extends ProjectTo {
    CodeTo parent;

    public ProjectToFull(Long id, String code, String title, String description, String typeCode, CodeTo parent) {
        super(id, code, title, description, typeCode, parent == null ? null : parent.getId());
        this.parent = parent;
    }
}