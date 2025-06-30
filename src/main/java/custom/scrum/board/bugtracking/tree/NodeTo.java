package custom.scrum.board.bugtracking.tree;

import custom.scrum.board.bugtracking.ObjectType;
import custom.scrum.board.common.HasIdAndParentId;
import custom.scrum.board.common.to.CodeTo;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Getter
public class NodeTo extends CodeTo implements HasIdAndParentId {
    @NonNull
    protected ObjectType type;
    @Nullable
    protected Long parentId;

    public NodeTo(long id, @NonNull String code, @NonNull ObjectType type, Long parentId) {
        super(id, code);
        this.type = type;
        this.parentId = parentId;
    }
}
