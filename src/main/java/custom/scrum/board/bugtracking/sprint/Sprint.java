package custom.scrum.board.bugtracking.sprint;

import custom.scrum.board.bugtracking.project.Project;
import custom.scrum.board.common.HasCode;
import custom.scrum.board.common.model.TimestampEntry;
import custom.scrum.board.common.util.validation.Code;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sprint")
@Getter
@Setter
@NoArgsConstructor
public class Sprint extends TimestampEntry implements HasCode {
    @Code
    @Column(name = "code", nullable = false)
    private String code;

    @Code
    @Column(name = "status_code", nullable = false)
    private String statusCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false, insertable = false, updatable = false)
    private Project project;

    @Column(name = "project_id")
    private long projectId;

    public Sprint(Long id, String code, String statusCode, long projectId) {
        super(id);
        this.code = code;
        this.statusCode = statusCode;
        this.projectId = projectId;
    }
}
