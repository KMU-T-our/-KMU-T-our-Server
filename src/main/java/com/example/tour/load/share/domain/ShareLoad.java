package com.example.tour.load.share.domain;

import com.example.tour.load.share.dto.ShareLoadSaveRequest;
import com.example.tour.load.share.dto.ShareLoadUpdateRequest;
import com.example.tour.project.Project;
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
