package custom.scrum.board.mail.internal;

import custom.scrum.board.common.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MailCaseRepository extends BaseRepository<MailCase> {
}
