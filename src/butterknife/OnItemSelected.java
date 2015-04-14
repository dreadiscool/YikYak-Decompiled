package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks=OnItemSelected.Callback.class, setter="setOnItemSelectedListener", targetType="android.widget.AdapterView<?>", type="android.widget.AdapterView.OnItemSelectedListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnItemSelected
{
  OnItemSelected.Callback callback();
  
  int[] value();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.OnItemSelected
 * JD-Core Version:    0.7.0.1
 */