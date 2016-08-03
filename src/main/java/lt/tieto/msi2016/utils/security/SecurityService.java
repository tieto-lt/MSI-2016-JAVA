package lt.tieto.msi2016.utils.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean hasAuthority(String authorityName) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                                    .filter(authority -> authorityName.equals(authority.getAuthority()))
                                    .findAny()
                                    .isPresent();
    }
}
