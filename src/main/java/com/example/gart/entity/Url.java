package com.example.gart.entity;

import javax.persistence.*;

@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "host")
    private String host;

    @Column(name = "url")
    private String url;

    // getter와 setter 메소드
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}

