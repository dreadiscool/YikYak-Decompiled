package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@butterknife.internal.ListenerMethod(name="onCheckedChanged", parameters={"android.widget.CompoundButton", "boolean"})}, setter="setOnCheckedChangeListener", targetType="android.widget.CompoundButton", type="android.widget.CompoundButton.OnCheckedChangeListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnCheckedChanged
{
  int[] value();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.OnCheckedChanged
 * JD-Core Version:    0.7.0.1
 */