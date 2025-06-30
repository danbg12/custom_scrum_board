package custom.scrum.board.profile.internal;

import custom.scrum.board.common.BaseRepository;
import custom.scrum.board.profile.internal.model.Profile;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ProfileRepository extends BaseRepository<Profile> {
    default Profile getOrCreate(long id) {
        return findById(id).orElseGet(() -> new Profile(id));
    }
}
