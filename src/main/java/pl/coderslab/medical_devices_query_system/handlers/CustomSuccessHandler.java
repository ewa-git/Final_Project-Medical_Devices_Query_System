package pl.coderslab.medical_devices_query_system.handlers;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.coderslab.medical_devices_query_system.domain.model.user.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Configuration
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String redirectUrl = null;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals(Role.ROLE_ENGINEER.toString())) {
                redirectUrl = "/engineer/dashboard";
                break;
            } else if (grantedAuthority.getAuthority().equals(Role.ROLE_ADMIN.toString())) {
                redirectUrl = "/admin/dashboard";
                break;
            } else if (grantedAuthority.getAuthority().equals(Role.ROLE_MANAGER.toString())) {
                redirectUrl = "/manager/dashboard";
                break;
            }
        }
        if (redirectUrl == null) {
            throw new IllegalStateException();
        }
        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);

    }
}

