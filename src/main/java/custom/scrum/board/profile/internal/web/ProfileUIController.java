package custom.scrum.board.profile.internal.web;

import custom.scrum.board.common.error.ErrorMessageHandler;
import custom.scrum.board.login.AuthUser;
import custom.scrum.board.ref.RefType;
import custom.scrum.board.ref.ReferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static custom.scrum.board.profile.internal.web.ProfileUIController.PROFILE_URL;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = PROFILE_URL)
public class ProfileUIController extends AbstractProfileController {
    static final String PROFILE_URL = "/ui/profile";

    private final ErrorMessageHandler errorMessageHandler;

    @GetMapping
    public String get(Model model, @AuthenticationPrincipal AuthUser authUser) {
        model.addAttribute("profile", super.get(authUser.id()));
        model.addAttribute("contactRefs", ReferenceService.getRefs(RefType.CONTACT).values());
        model.addAttribute("mailNotificationRefs", ReferenceService.getRefs(RefType.MAIL_NOTIFICATION).values());
        return "profile";
    }

    @PostMapping
    public String update(@Valid ProfilePostRequest profile, BindingResult result,
                         @AuthenticationPrincipal AuthUser authUser, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("profileError", errorMessageHandler.getErrorList(result));
            return "redirect:" + PROFILE_URL;
        }
        redirectAttrs.addFlashAttribute("profileSuccess", "Saved successfully");
        super.update(profileMapper.fromPostToTo(profile), authUser.id());
        return "redirect:" + PROFILE_URL;
    }
}
