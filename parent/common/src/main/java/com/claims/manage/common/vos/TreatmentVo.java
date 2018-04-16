package com.claims.manage.common.vos;



import java.util.Date;

import com.claims.manage.common.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;




public class TreatmentVo implements BaseDto {
	
	
	
	
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
	@ApiModelProperty(required=false,position=0,example="No Desc")
	private Boolean active;
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
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	

}
