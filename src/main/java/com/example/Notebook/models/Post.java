package com.example.Notebook.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name, IP, AnyDesk, TeamViewer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getAnyDesk() {
        return AnyDesk;
    }

    public void setAnyDesk(String AnyDesk) {
        this.AnyDesk = AnyDesk;
    }

    public String getTeamViewer() {
        return TeamViewer;
    }

    public void setTeamViewer(String TeamViewer) {
        this.TeamViewer = TeamViewer;
    }

    public Post() {
    }

    public Post(String Name, String IP, String AnyDesk, String TeamViewer) {
        this.Name = Name;
        this.IP = IP;
        this.AnyDesk = AnyDesk;
        this.TeamViewer = TeamViewer;
    }
}
