package custom.scrum.board.profile.internal.web;

import custom.scrum.board.common.util.validation.ValidationUtil;
import custom.scrum.board.profile.ProfileTo;
import custom.scrum.board.profile.internal.ProfileMapper;
import custom.scrum.board.profile.internal.ProfileRepository;
import custom.scrum.board.profile.internal.ProfileUtil;
import custom.scrum.board.profile.internal.model.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class AbstractProfileController {
    @Autowired
    protected ProfileMapper profileMapper;
    @Autowired
    private ProfileRepository profileRepository;

    public ProfileTo get(long id) {
        log.info("get {}", id);
        return profileMapper.toTo(profileRepository.getOrCreate(id));
    }

    public void update(ProfileTo profileTo, long id) {
        log.info("update {}, user {}", profileTo, id);
        ValidationUtil.assureIdConsistent(profileTo, id);
        ValidationUtil.assureIdConsistent(profileTo.getContacts(), id);
        ProfileUtil.checkContactsExist(profileTo.getContacts());
        Profile profile = profileMapper.updateFromTo(profileRepository.getOrCreate(profileTo.id()), profileTo);
        profileRepository.save(profile);
    }
}
