package com.claims.manage.common.messages;



public enum ConstantMessage {
		SUCCESS(200, Messages.getString("ConstantMessage.sucess")), //$NON-NLS-1$
		NOUSERFOUND(103, Messages.getString("ConstantMessage.user_blank")), //$NON-NLS-1$
		EMAILISEMPTY(104, Messages.getString("ConstantMessage.email_empty")), //$NON-NLS-1$
		FIRSTNAMEISEMPTY(104, Messages.getString("ConstantMessage.first_name_empty")),		 //$NON-NLS-1$
		INVALIDEMAIL(105, Messages.getString("ConstantMessage.email_not_correct")), //$NON-NLS-1$
		EMAILALREADYEXISTS(105, Messages.getString("ConstantMessage.email_already_exists")), //$NON-NLS-1$
		TAGREADYEXISTS(105, Messages.getString("ConstantMessage.tag_already_exists")), //$NON-NLS-1$
		ERRORONUPDATE(106, Messages.getString("ConstantMessage.error_on_update")),		 //$NON-NLS-1$
		USERADDRESSBLANK(107, Messages.getString("ConstantMessage.city_blank")),		 //$NON-NLS-1$		
		USERNOTFOUND(108, Messages.getString("ConstantMessage.user_not_found")),		 //$NON-NLS-1$
		USERCANNOTADDSELF(109, Messages.getString("ConstantMessage.user_can_not_add_self")),		 //$NON-NLS-1$		
		USERALREADYEXISTS(110, Messages.getString("ConstantMessage.user_already_exists")),		 //$NON-NLS-1$		
		NETWORKNOTFOUND(111, Messages.getString("ConstantMessage.network_not_found")),		 //$NON-NLS-1$
		ROLENOTFOUND(112, Messages.getString("ConstantMessage.role_not_found")),		 //$NON-NLS-1$
		TAGNOTFOUND(113, Messages.getString("ConstantMessage.tag_not_found")),		 //$NON-NLS-1$	
		CITYBLANK(114, Messages.getString("ConstantMessage.city_blank")),		 //$NON-NLS-1$
		STATEBLANK(115, Messages.getString("ConstantMessage.state_blank")),		 //$NON-NLS-1$
		COUNTRYBLANK(116, Messages.getString("ConstantMessage.country_blank")),		 //$NON-NLS-1$
		ADDRESSLINE1BLANK(117, Messages.getString("ConstantMessage.address_line_blank")),		 //$NON-NLS-1$
		LATBLANK(118, Messages.getString("ConstantMessage.lat_blank")),		 //$NON-NLS-1$
		LNGBLANK(119, Messages.getString("ConstantMessage.lng_blank")),		 //$NON-NLS-1$
		NETWORKBLANK(120, Messages.getString("ConstantMessage.network_blank")),		 //$NON-NLS-1$
		ROLEBLANK(121, Messages.getString("ConstantMessage.role_blank")),		 //$NON-NLS-1$
		NETWORKALREADY(121, Messages.getString("ConstantMessage.network_already_exists")),		 //$NON-NLS-1$
		ROLEALREADY(122, Messages.getString("ConstantMessage.role_already_exists")),		 //$NON-NLS-1$
		TAGBLANK(123, Messages.getString("ConstantMessage.tags_blank")),		 //$NON-NLS-1$
		TITLEBLANK(124, Messages.getString("ConstantMessage.title_blank")),		 //$NON-NLS-1$
		DESCBLANK(125, Messages.getString("ConstantMessage.discription_blank")),		 //$NON-NLS-1$		
		PASSWORDISEMPTY(126, Messages.getString("ConstantMessage.password_not_empty")), //$NON-NLS-1$
		TREATMENTISNULL(127, Messages.getString("ConstantMessage.treatment_null")), //$NON-NLS-1$
		TREATMENTNAMEREQUIRED(128, Messages.getString("ConstantMessage.treatment_name_null")), //$NON-NLS-1$
		TREATMENTDESCREQUIRED(129, Messages.getString("ConstantMessage.treatment_desc_null")), //$NON-NLS-1$
		TREATMENTACTIVECREQUIRED(130, Messages.getString("ConstantMessage.treatment_active_null")), //$NON-NLS-1$
		TREATMENTACTIVENOTFALSE(131, Messages.getString("ConstantMessage.treatment_active_not_false")), //$NON-NLS-1$
		TREATMENTACTIVENOTTRUE(132, Messages.getString("ConstantMessage.treatment_active_not_true")), //$NON-NLS-1$
		SURGERYISNULL(127, Messages.getString("ConstantMessage.surgery_null")), //$NON-NLS-1$
		SURGERYNAMEREQUIRED(128, Messages.getString("ConstantMessage.surgery_name_null")), //$NON-NLS-1$
		SURGERYDESCREQUIRED(129, Messages.getString("ConstantMessage.surgery_desc_null")), //$NON-NLS-1$
		SURGERYACTIVECREQUIRED(130, Messages.getString("ConstantMessage.surgery_active_null")), //$NON-NLS-1$
		SURGERYACTIVENOTFALSE(131, Messages.getString("ConstantMessage.surgery_active_not_false")), //$NON-NLS-1$
		SURGERYACTIVENOTTRUE(132, Messages.getString("ConstantMessage.surgery_active_not_true")); //$NON-NLS-1$
	
	
	
	
	

	      

	    private final Integer errcode;
	    private final String message;
	    

	    private ConstantMessage(Integer errcode, String message) {
	        this.errcode = errcode;
	        this.message = message;
	        
	    }

	    public Integer getErrcode() {
	        return errcode;
	    }

	    public String getMessage() {
	        return message;
	    }

	  
	
}
