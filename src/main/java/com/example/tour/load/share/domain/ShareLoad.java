package com.example.tour.load.share.domain;

import com.example.tour.load.share.dto.ShareLoadSaveRequest;
import com.example.tour.load.share.dto.ShareLoadUpdateRequest;
import com.example.tour.project.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Optional;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shareLoad")
@Entity
public class ShareLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "share_load_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ColumnDefault("false")
    private boolean checkbox;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    @JsonIgnore //순환 참조 하기 위해 사용 -> get 검색시 보이지 않음 사실상 단방향 매핑
//    @OneToMany(mappedBy = "shareLoad")
//    private List<ShareUser> users = new ArrayList<>();

    public ShareLoad(ShareLoadSaveRequest request, Optional<Project> project) {
        this.name = request.getShareLoadName();
        this.checkbox = request.isCheckbox();
        this.project = project.get();
    }

    public void updateShareLoad(ShareLoadUpdateRequest request) {
        this.name = request.getShareLoadName();
        this.checkbox = request.isCheckbox();
    }
}
