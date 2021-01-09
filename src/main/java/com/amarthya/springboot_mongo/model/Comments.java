package com.amarthya.springboot_mongo.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

	private String commenter;
	private String comment;
	private LocalDateTime date;

}
