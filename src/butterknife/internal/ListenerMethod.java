package butterknife.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ListenerMethod
{
  String defaultReturn() default "null";
  
  String name();
  
  String[] parameters();
  
  String returnType() default "void";
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.internal.ListenerMethod
 * JD-Core Version:    0.7.0.1
 */