package com.example.demo.entity.role;

import com.example.demo.entity.mappedsuper.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "roles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<RoleAuthority> roleAuthorities = new ArrayList<>();

    public List<SimpleGrantedAuthority> authorities() {
        return this.getRoleAuthorities().stream()
                .map(RoleAuthority::getAuthority)
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .toList();
    }

}
