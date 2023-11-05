package com.example.tour.load.share.domain;

import com.example.tour.load.share.dto.ShareLoadRequest;
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
    private Long id;

    @Column(nullable = false)
    private String name;

    @ColumnDefault("false")
    private boolean checkbox;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public ShareLoad(ShareLoadRequest request, Optional<Project> project){
        this.name = request.getName();
        this.checkbox = request.isCheckbox();
        this.project = project.get();
    }

    public void updateShareLoad(ShareLoadRequest request){
        this.name = request.getName();
        this.checkbox = request.isCheckbox();
    }

}
