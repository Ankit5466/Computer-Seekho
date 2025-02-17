package com.Project.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "News_id")
    private int NewsId;

    @Column(name = "News_url", length = 255, nullable = false)
    private String NewsUrl;

     @Column(name = "News_title", length  = 255, nullable = false)
    private String NewsTitle;

    @Column(name = "News_description", length = 255, nullable = false)
    private String NewsDescrption;

}
