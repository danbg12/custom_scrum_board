package custom.scrum.board.bugtracking;

import custom.scrum.board.bugtracking.attachment.Attachment;
import custom.scrum.board.bugtracking.attachment.AttachmentMapper;
import custom.scrum.board.bugtracking.attachment.AttachmentRepository;
import custom.scrum.board.bugtracking.attachment.to.AttachmentTo;
import custom.scrum.board.bugtracking.project.Project;
import custom.scrum.board.bugtracking.project.ProjectMapper;
import custom.scrum.board.bugtracking.project.ProjectRepository;
import custom.scrum.board.bugtracking.project.to.ProjectTo;
import custom.scrum.board.bugtracking.sprint.Sprint;
import custom.scrum.board.bugtracking.sprint.SprintMapper;
import custom.scrum.board.bugtracking.sprint.SprintRepository;
import custom.scrum.board.bugtracking.sprint.to.SprintTo;
import custom.scrum.board.bugtracking.task.Activity;
import custom.scrum.board.bugtracking.task.ActivityRepository;
import custom.scrum.board.bugtracking.task.Task;
import custom.scrum.board.bugtracking.task.TaskRepository;
import custom.scrum.board.bugtracking.task.mapper.ActivityMapper;
import custom.scrum.board.bugtracking.task.mapper.TaskExtMapper;
import custom.scrum.board.bugtracking.task.mapper.TaskFullMapper;
import custom.scrum.board.bugtracking.task.mapper.TaskMapper;
import custom.scrum.board.bugtracking.task.to.ActivityTo;
import custom.scrum.board.bugtracking.task.to.TaskTo;
import custom.scrum.board.bugtracking.task.to.TaskToExt;
import custom.scrum.board.bugtracking.task.to.TaskToFull;
import custom.scrum.board.common.BaseHandler;
import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.common.BaseRepository;
import custom.scrum.board.common.HasId;
import custom.scrum.board.common.to.BaseTo;
import custom.scrum.board.login.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Handlers {
    @Component
    public static class ProjectHandler extends UserBelongHandler<Project, ProjectTo, ProjectRepository, ProjectMapper> {
        public ProjectHandler(ProjectRepository repository, ProjectMapper mapper) {
            super(repository, mapper);
        }
    }

    @Component
    public static class SprintHandler extends UserBelongHandler<Sprint, SprintTo, SprintRepository, SprintMapper> {
        public SprintHandler(SprintRepository repository, SprintMapper mapper) {
            super(repository, mapper, null, (sprint, dbSprint) -> {  // link spring to other project not allowed
                SprintMapper.checkProjectBelong(sprint.getProjectId(), dbSprint);
                sprint.setStartpoint(dbSprint.getStartpoint());
                sprint.setEndpoint(dbSprint.getEndpoint());
                return sprint;
            });
        }
    }

    @Component
    public static class TaskHandler extends UserBelongHandler<Task, TaskTo, TaskRepository, TaskMapper> {
        public TaskHandler(TaskRepository repository, TaskMapper mapper) {
            super(repository, mapper);
        }
    }

    @Component
    public static class TaskFullHandler extends UserBelongHandler<Task, TaskToFull, TaskRepository, TaskFullMapper> {
        public TaskFullHandler(TaskRepository repository, TaskFullMapper mapper) {
            super(repository, mapper);
        }
    }

    @Component
    public static class TaskExtHandler extends UserBelongHandler<Task, TaskToExt, TaskRepository, TaskExtMapper> {
        public TaskExtHandler(TaskRepository repository, TaskExtMapper mapper) {
            super(repository, mapper);
        }
    }

    @Component
    public static class ActivityHandler extends BaseHandler<Activity, ActivityTo, ActivityRepository, ActivityMapper> {
        public ActivityHandler(ActivityRepository repository, ActivityMapper mapper) {
            super(repository, mapper);
        }
    }

    @Component
    public static class AttachmentHandler extends BaseHandler<Attachment, AttachmentTo, AttachmentRepository, AttachmentMapper> {
        public AttachmentHandler(AttachmentRepository repository, AttachmentMapper mapper) {
            super(repository, mapper);
        }
    }

    @Slf4j
    public static class UserBelongHandler<E extends HasId, T extends BaseTo, R extends BaseRepository<E>, M extends BaseMapper<E, T>> extends BaseHandler<E, T, R, M> {
        @Autowired
        private UserBelongRepository belongRepository;

        public UserBelongHandler(R repository, M mapper) {
            super(repository, mapper);
        }

        public UserBelongHandler(R repository, M mapper, Function<E, E> prepareForSave, BiFunction<E, E, E> prepareForUpdate) {
            super(repository, mapper, prepareForSave, prepareForUpdate);
        }

        public List<UserBelong> getAllBelongs(long objectId) {
            return belongRepository.findAll(objectId);
        }

        @Transactional
        public E createWithBelong(T to, ObjectType type, String userTypeCode) {
            E created = super.createFromTo(to);
            createUserBelong(created.id(), type, AuthUser.authId(), userTypeCode);
            return created;
        }

        @Transactional
        public void createUserBelong(long id, ObjectType type, long userId, String userTypeCode) {
            if (belongRepository.findActiveAssignment(id, type, userId, userTypeCode).isEmpty()) {
                UserBelong belong = new UserBelong(id, type, userId, userTypeCode);
                belongRepository.save(belong);
            }
        }
    }
}
