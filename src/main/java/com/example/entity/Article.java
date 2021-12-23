package com.example.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

    @Data
	@Document(indexName = "codeplayer")
	public class Article implements Serializable {
	    private static final long serialVersionUID = -4464567572629455945L;

	    @Id
	    private Long articleId;
	    // analyzer = "ik_max_word" **常用**
	    // 会将文本做最细粒度的拆分，比如会将“中华人民共和国人民大会堂”拆分为“中华人民共和国、中华人民、中华、华人、人民共和国、人民、共和国、大会堂、大会、会堂等词语。
	    @Field(type = FieldType.Text,store = true,analyzer = "ik_max_word")
	    private String title;
	    // analyzer = "ik_smart"
	    // 会做最粗粒度的拆分，比如会将“中华人民共和国人民大会堂”拆分为中华人民共和国、人民大会堂。
	    @Field(type = FieldType.Text,store = true,analyzer = "ik_max_word")
	    private Object content;
	    
	    @Field(type = FieldType.Text)
	    private String tag;
	
	


}
