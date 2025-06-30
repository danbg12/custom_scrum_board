package custom.scrum.board.bugtracking.dashboard;

import custom.scrum.board.bugtracking.Handlers;
import custom.scrum.board.common.TimestampRepository;
import custom.scrum.board.ref.RefType;
import custom.scrum.board.ref.ReferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(DashboardUIController.DASHBOARD_URL)
@RequiredArgsConstructor
public class DashboardUIController {
    static final String DASHBOARD_URL = "/ui/dashboard";

    private final Handlers.ProjectHandler handler;

    @GetMapping
    public String showDashboard(Model model) {
        log.info("show dashboard");
        model.addAttribute("projects", handler.getAllTos(TimestampRepository.NEWEST_FIRST));
        model.addAttribute("taskStatusRefs", ReferenceService.getRefs(RefType.TASK_STATUS));
        return "dashboard";
    }
}
