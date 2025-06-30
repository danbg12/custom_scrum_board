package custom.scrum.board.login.internal.passwordreset;

import custom.scrum.board.common.AppEvent;
import custom.scrum.board.login.User;

public record PasswordResetEvent(User user, String token) implements AppEvent {
}
