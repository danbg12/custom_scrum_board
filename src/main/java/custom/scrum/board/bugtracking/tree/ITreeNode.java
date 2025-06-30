package custom.scrum.board.bugtracking.tree;

import custom.scrum.board.common.HasIdAndParentId;

import java.util.List;

public interface ITreeNode<T extends HasIdAndParentId, R extends ITreeNode<T, R>> {
    List<R> subNodes();
}
