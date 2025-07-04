package custom.scrum.board.login.internal.web;

import custom.scrum.board.common.HasIdAndEmail;
import custom.scrum.board.login.AuthUser;
import custom.scrum.board.login.internal.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

@Component
@AllArgsConstructor
public class UniqueMailValidator implements org.springframework.validation.Validator {
    public static final String EXCEPTION_DUPLICATE_EMAIL = "User with this email already exists";

    private final UserRepository repository;
    private final HttpServletRequest request;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return HasIdAndEmail.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        HasIdAndEmail user = ((HasIdAndEmail) target);
        if (StringUtils.hasText(user.getEmail())) {
            repository.findByEmailIgnoreCase(user.getEmail())
                    .ifPresent(dbUser -> {
                        long dbId = dbUser.id();
                        if (user.getId() != null && dbId == user.id()) return;

                        String requestURI = request.getRequestURI();
                        AuthUser authUser = AuthUser.safeGet();
                        if (requestURI.endsWith("/" + dbId) || (authUser != null && dbId == authUser.id())) return;
                        errors.rejectValue("email", "Duplicate", EXCEPTION_DUPLICATE_EMAIL);
                    });
        }
    }
}
