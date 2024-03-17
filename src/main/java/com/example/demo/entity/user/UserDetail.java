package com.example.demo.entity.user;

import com.example.demo.entity.mappedsuper.BaseEntity;
import com.example.demo.entity.vo.Address;
import com.example.demo.entity.vo.TelInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDetail extends BaseEntity {

    @Id
    @OneToOne(orphanRemoval = true)
    private User user;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "agency", column = @Column(name = "home_agency")),
            @AttributeOverride(name = "telNumber", column = @Column(name = "home_tel_number"))
    })
    private TelInfo homeTelinfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "agency", column = @Column(name = "sub_agency")),
            @AttributeOverride(name = "telNumber", column = @Column(name = "sub_tel_number"))
    })
    private TelInfo subTelinfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "home_zip_code")),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "home_detail_address"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "company_zip_code")),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "company_detail_address"))
    })
    private Address companyAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "sub_zip_code")),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "sub_detail_address"))
    })
    private Address subAddress;

}
