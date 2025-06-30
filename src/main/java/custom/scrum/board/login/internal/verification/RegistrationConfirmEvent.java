package custom.scrum.board.login.internal.verification;

import custom.scrum.board.common.AppEvent;
import custom.scrum.board.login.UserTo;

public record RegistrationConfirmEvent(UserTo userto, String token) implements AppEvent {
}
