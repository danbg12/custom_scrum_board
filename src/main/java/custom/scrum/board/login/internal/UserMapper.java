package custom.scrum.board.login.internal;

import custom.scrum.board.common.BaseMapper;
import custom.scrum.board.login.Role;
import custom.scrum.board.login.User;
import custom.scrum.board.login.UserTo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.EnumSet;

@Mapper(componentModel = "spring", imports = {EnumSet.class, Role.class})
public interface UserMapper extends BaseMapper<User, UserTo> {
    @Override
    @Mapping(target = "roles", expression = "java(EnumSet.of(Role.DEV))")
    User toEntity(UserTo to);

    @Override
    @Mapping(target = "password", ignore = true)
    User updateFromTo(UserTo to, @MappingTarget User entity);
}
