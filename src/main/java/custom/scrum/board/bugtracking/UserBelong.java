package custom.scrum.board.bugtracking;

import custom.scrum.board.common.model.TimestampEntry;
import custom.scrum.board.common.util.validation.Code;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_belong",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"object_id", "object_type", "user_id", "user_type_code"}, name = "uk_user_belong")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBelong extends TimestampEntry {

    @Column(name = "object_id", nullable = false)
    @NotNull
    private Long objectId;

    @Column(name = "object_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private ObjectType objectType;

    @Column(name = "user_id", nullable = false)
    @NotNull
    private Long userId;

    @Code
    @Column(name = "user_type_code", nullable = false)
    private String userTypeCode;
}
