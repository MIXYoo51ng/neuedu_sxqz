package com.neuedu.ann;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Testann {

	public String value() default "morenzhi";
	
}
