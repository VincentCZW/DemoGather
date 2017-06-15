package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by VincentChen on 2017/6/14.
 *
 * ±‡“Î ±◊¢Ω‚≤‚ ‘
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface AnnoField {
    String value() default "default";
}
