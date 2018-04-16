package com.claims.manage.rest.jwt.model;





import io.swagger.annotations.ApiModelProperty;

public class JwtUser {
	
	@ApiModelProperty(example="USER")
    private String email;
    @ApiModelProperty(example="1")
    private long id;
    @ApiModelProperty(example="2")
    private String role;

    public void setUserName(String userName) {
        this.email = userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
