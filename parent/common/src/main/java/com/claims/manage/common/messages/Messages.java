package com.claims.manage.common.messages;





import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	//When generating war then this class will find message file message.properties on this location
	// we can not set in to current jar else this propertiries file will not able to find.
	
	private static final String BUNDLE_NAME = "com.claims.manage.common.messages.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
