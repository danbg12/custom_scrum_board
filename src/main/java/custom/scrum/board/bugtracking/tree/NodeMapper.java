package custom.scrum.board.bugtracking.tree;

import custom.scrum.board.bugtracking.project.to.ProjectTo;
import custom.scrum.board.bugtracking.sprint.to.SprintTo;
import custom.scrum.board.bugtracking.task.to.TaskTo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NodeMapper {
    @Mapping(target = "type", expression = "java(ObjectType.PROJECT)")
    NodeTo fromProject(ProjectTo project);

    @Mapping(target = "type", expression = "java(ObjectType.SPRINT)")
    @Mapping(target = "parentId", expression = "java(null)")
    NodeTo fromSprint(SprintTo sprint);

    @Mapping(target = "type", expression = "java(ObjectType.TASK)")
    NodeTo fromTask(TaskTo task);
}
