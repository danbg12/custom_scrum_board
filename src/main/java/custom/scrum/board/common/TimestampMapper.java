package custom.scrum.board.common;

import custom.scrum.board.common.model.TimestampEntry;
import custom.scrum.board.common.to.CodeTo;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.MappingTarget;

@MapperConfig(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface TimestampMapper<E extends TimestampEntry, T extends CodeTo> {
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "id", ignore = true)
    E updateFromTo(T to, @MappingTarget E entity);
}
