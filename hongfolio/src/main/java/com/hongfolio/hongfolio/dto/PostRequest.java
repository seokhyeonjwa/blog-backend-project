package com.hongfolio.hongfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private String title;
    private String content;
    private String author;
    private String category;
}
