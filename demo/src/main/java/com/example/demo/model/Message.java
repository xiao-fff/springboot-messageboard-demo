package com.example.demo.model;



import jakarta.persistence.*;
import java.time.LocalDateTime;

//标记实体，对应数据库
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private LocalDateTime createTime;

    //构造函数
    public Message(){}
    public Message(String content){
        this.content=content;
        this.createTime=LocalDateTime.now();
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getContent(){return content;}
    public void setContent(String content){this.content=content;}

    public LocalDateTime getCreateTime(){return createTime;}
    public void setCreateTime(LocalDateTime createTime){this.createTime=createTime;}
    
}
