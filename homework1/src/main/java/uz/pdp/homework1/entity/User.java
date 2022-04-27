package uz.pdp.homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.homework1.config.AuditingListener;
import uz.pdp.homework1.entity.enums.Permission;
import uz.pdp.homework1.entity.templete.AbstractEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
@EntityListeners(value = AuditingListener.class)
public class User extends AbstractEntity implements UserDetails{

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne( optional = false, fetch = FetchType.LAZY)
    private Role role;

    private boolean enabled;
    private boolean isAccountNonExpired=true;
    private boolean isAccountNonLocked=true;
    private boolean isCredentialsNonExpired=true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Permission> roleList = this.role.getRoleList();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Permission permission : roleList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.name()));
        }

//        for (Permission permission : roleList) {
//            grantedAuthorities.add(new GrantedAuthority() {
//                @Override
//                public String getAuthority() {
//                    return permission.name();
//                }
//            });
//        }

        return grantedAuthorities;
    }


    public User(String fullName, String username, String password, Role role, boolean enabled) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }
}
