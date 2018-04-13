package com.nsu.yourStory.users.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class TimestampBean {

	private Date createDate;
	private Date lastUpdate;

}
