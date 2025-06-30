package custom.scrum.board.login.internal;

import custom.scrum.board.login.User;

import static custom.scrum.board.common.internal.config.SecurityConfig.PASSWORD_ENCODER;

public class UsersUtil {

    public static User prepareForCreate(User user) {
        return prepareForUpdate(user, PASSWORD_ENCODER.encode(user.getPassword()));
    }

    public static User prepareForUpdate(User user, String encPassword) {
        user.setPassword(encPassword);
        user.normalize();
        return user;
    }
}
