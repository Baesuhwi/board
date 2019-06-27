package com.example.bsh.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int reply_code;
	private String reply_content;
	private Date reply_date;
	private  String id;
	private int post_code;
}
