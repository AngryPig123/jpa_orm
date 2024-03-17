package com.example.demo.entity.user;


import com.example.demo.entity.role.RoleAuthority;
import com.example.demo.entity.mappedsuper.BaseEntity;
import com.example.demo.entity.role.Role;
import com.example.demo.entity.vo.Password;
import com.example.demo.entity.vo.UserLock;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Embedded
    private Password password;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;  //  유저 롤에 설정, 관리자, 사용자, 게스트

    @Embedded
    private UserLock userLock;


    public List<SimpleGrantedAuthority> authorities() {
        return role.authorities();
    }

    public String getPassword() {
        return password.getPassword();
    }

    public boolean isAccountNonLocked() {
        return userLock.isLock();
    }

    //  isAccountNonExpired();
    //  isCredentialsNonExpired();
    //  isEnabled();

}
