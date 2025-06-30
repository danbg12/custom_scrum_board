package custom.scrum.board.bugtracking.task.to;

import custom.scrum.board.common.HasCode;
import custom.scrum.board.common.HasIdAndParentId;
import custom.scrum.board.common.to.TitleTo;
import custom.scrum.board.common.util.validation.Code;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
public class TaskTo extends TitleTo implements HasCode, HasIdAndParentId {
    @Code
    private final String typeCode;
    Long parentId;
    @NotNull
    Long projectId;
    Long sprintId;
    @Setter
    @Code
    private String statusCode;

    public TaskTo(Long id, String code, String title, String typeCode, String statusCode, Long parentId, Long projectId, Long sprintId) {
        super(id, code, title);
        this.typeCode = typeCode;
        this.statusCode = statusCode;
        this.parentId = parentId;
        this.projectId = projectId;
        this.sprintId = sprintId;
    }
}
