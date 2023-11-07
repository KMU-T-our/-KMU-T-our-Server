package com.example.tour.config.undertable.shareuser;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.load.share.domain.ShareLoad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "share_user")
@Builder
@Entity
public class ShareUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shareload_id", nullable = false)
    private ShareLoad shareLoad;

    @Column(name = "user_id")
    private Long userId;

    public ShareUser(ShareLoad shareLoad ,ProjectUser projectUser){
        this.shareLoad = shareLoad;
        this.userId = projectUser.getUser().getId();
    }
}
