package com.example.bsh.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
	private int post_code;
	private String post_title;
	private String post_content;
	private Date post_date;
	private String id;
	private String pw;
	private int board_code;
	private int searchnum;
	private int no_good;
	private int pr_good;
}
