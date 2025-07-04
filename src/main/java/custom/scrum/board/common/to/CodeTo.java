package custom.scrum.board.common.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import custom.scrum.board.common.HasCode;
import custom.scrum.board.common.util.validation.Code;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
public class CodeTo extends BaseTo implements HasCode {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Setter
    boolean enabled = true;
    @Code
    String code;

    public CodeTo(Long id, @NonNull String code) {
        super(id);
        this.code = code;
    }

    @Override
    public String toString() {
        return super.toString() + '[' + code + ']' + ',' + enabled;
    }
}