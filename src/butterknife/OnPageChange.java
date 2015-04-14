package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks=OnPageChange.Callback.class, setter="setOnPageChangeListener", targetType="android.support.v4.view.ViewPager", type="android.support.v4.view.ViewPager.OnPageChangeListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnPageChange
{
  OnPageChange.Callback callback();
  
  int[] value();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.OnPageChange
 * JD-Core Version:    0.7.0.1
 */