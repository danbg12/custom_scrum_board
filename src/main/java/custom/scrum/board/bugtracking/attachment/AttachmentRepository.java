package custom.scrum.board.bugtracking.attachment;

import custom.scrum.board.bugtracking.ObjectType;
import custom.scrum.board.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AttachmentRepository extends BaseRepository<Attachment> {

    @Query("SELECT a FROM Attachment a WHERE a.objectId =:objectId AND a.objectType =:objectType")
    List<Attachment> getAllForObject(long objectId, ObjectType objectType);
}
