package com.example.demo.entity.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class UserLock {

    @Column(name = "try_count")
    private Integer tryCount;

    @Column(name = "is_lock")
    private boolean isLock; //  이거 기본값 어떻게 넣냐.

}
