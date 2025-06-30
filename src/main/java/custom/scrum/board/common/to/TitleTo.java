package custom.scrum.board.common.to;

import custom.scrum.board.common.util.validation.Title;
import lombok.Getter;
import lombok.Setter;

@Getter
public class TitleTo extends CodeTo {
    @Title
    @Setter
    protected String title;

    public TitleTo(Long id, String code, String title) {
        super(id, code);
        this.title = title;
    }
}
