package com.claims.manage.common.dto;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;




public class SurgeryDto implements BaseDto {
	
	
	
	
	private static final long _1L = 1L;


	/**
	 * 
	 */
	private static final long serialVersionUID = _1L;


	private Integer id;
	@ApiModelProperty(required=true,position=0,example="COLD")
	private String name;
	@ApiModelProperty(required=true,position=0,example="No Desc")
	private String description;
	@ApiModelProperty(required=false)
	private Boolean active;	
	@ApiModelProperty(hidden=true)
	@JsonIgnore 
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date created;	
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date modified;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	public Date getCreated() {
		return created;
	}
	@JsonProperty
	public void setCreated(Date created) {
		this.created = created;
	}
	@JsonIgnore
	public Date getModified() {
		return modified;
	}
	@JsonProperty
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

}
