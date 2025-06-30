package custom.scrum.board.login.internal.verification;

import custom.scrum.board.login.UserTo;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@ToString
public class ConfirmData implements Serializable {
    private final UserTo userTo;
    private final String token;

    public ConfirmData(@NonNull UserTo user) {
        this.userTo = user;
        this.token = UUID.randomUUID().toString();
    }
}
