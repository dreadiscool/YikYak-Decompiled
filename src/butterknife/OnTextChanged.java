package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks=OnTextChanged.Callback.class, setter="addTextChangedListener", targetType="android.widget.TextView", type="android.text.TextWatcher")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnTextChanged
{
  OnTextChanged.Callback callback();
  
  int[] value();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.OnTextChanged
 * JD-Core Version:    0.7.0.1
 */