package cyborgcpec.hospitalrdm.configuration.Security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Roles {
    USER(Set.of(Permission.API_READ)),ADMIN(Set.of(Permission.API_WRITE,Permission.API_READ));
    private final Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    Roles(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission())).
                collect(Collectors.toSet());
    }
}
