package com.example.tour.load.shareloaduser.domain;

import com.example.tour.load.share.domain.ShareLoad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShareLoadUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loadUserId;

    @ManyToOne
    @JoinColumn(name = "share_load_id")
    private ShareLoad shareLoad;

    private Long userId;

    public ShareLoadUser(ShareLoad shareLoad, Long userId) {
        this.shareLoad = shareLoad;
        this.userId = userId;
    }
}
