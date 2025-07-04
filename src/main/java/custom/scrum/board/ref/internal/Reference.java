package custom.scrum.board.ref.internal;

import custom.scrum.board.common.model.TitleEntity;
import custom.scrum.board.common.util.validation.Code;
import custom.scrum.board.ref.RefType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reference",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ref_type", "code"}, name = "uk_reference_ref_type_code")})
@AllArgsConstructor
@EqualsAndHashCode(of = {"refType", "code"}, callSuper = false)
public class Reference extends TitleEntity {

    @Column(name = "ref_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private RefType refType;

    @Column(name = "code", nullable = false)
    @Code
    private String code;

    @Column(name = "aux", columnDefinition = "varchar")
    @Nullable
    private String aux;

    public Reference(Long id, RefType refType, String code, String title) {
        super(id, title);
        this.refType = refType;
        this.code = code;
    }

    @Override
    public String toString() {
        return refType + ":" + code + '(' + title + ')';
    }
}