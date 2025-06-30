package custom.scrum.board.bugtracking.sprint.to;

import custom.scrum.board.common.to.CodeTo;
import lombok.Value;

@Value
public class SprintToFull extends SprintTo {
    CodeTo project;

    public SprintToFull(Long id, String code, String statusCode, CodeTo project) {
        super(id, code, statusCode, project.getId());
        this.project = project;
    }
}
