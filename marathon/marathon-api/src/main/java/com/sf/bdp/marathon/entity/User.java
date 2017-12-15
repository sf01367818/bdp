package com.sf.bdp.marathon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -3479439467003051023L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "name", columnDefinition = ("varchar(150) not null comment '姓名'"))
	private String name;
	@Column(name = "password", columnDefinition = ("varchar(100) default null comment '密码'"))
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
