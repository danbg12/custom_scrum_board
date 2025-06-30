package custom.scrum.board.login.internal;

import custom.scrum.board.common.BaseHandler;
import custom.scrum.board.login.User;
import custom.scrum.board.login.UserTo;
import org.springframework.stereotype.Component;

import java.util.function.BinaryOperator;

@Component
public class UserHandler extends BaseHandler<User, UserTo, UserRepository, UserMapper> {
    public UserHandler(UserRepository repository, UserMapper mapper) {
        super(repository, mapper,
                UsersUtil::prepareForCreate,
                (BinaryOperator<User>) (user, dbUser) -> UsersUtil.prepareForUpdate(user, dbUser.getPassword()));
    }
}
