package custom.scrum.board.bugtracking.sprint.to;

import custom.scrum.board.common.HasCode;
import custom.scrum.board.common.to.CodeTo;
import custom.scrum.board.common.util.validation.Code;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SprintTo extends CodeTo implements HasCode {
    @Code
    String statusCode;
    @NotNull
    Long projectId;

    public SprintTo(Long id, String code, String statusCode, Long projectId) {
        super(id, code);
        this.statusCode = statusCode;
        this.projectId = projectId;
    }
}
