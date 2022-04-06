package ch.skyfy.plugin.core;

import java.lang.annotation.Documented;import java.lang.annotation.Target;

@Documented
@Target({java.lang.annotation.ElementType.METHOD})
public @interface VersionManaged {
}
