package com.example.demo.entity.role;


import com.example.demo.entity.embeddedid.RoleAuthorityId;
import com.example.demo.entity.mappedsuper.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "role_authority")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleAuthority extends BaseEntity {

    @EmbeddedId
    private RoleAuthorityId id;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @MapsId("authorityId")
    @JoinColumn(name = "authority_id")
    private Authority authority;

}
