package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@butterknife.internal.ListenerMethod(defaultReturn="false", name="onTouch", parameters={"android.view.View", "android.view.MotionEvent"}, returnType="boolean")}, setter="setOnTouchListener", targetType="android.view.View", type="android.view.View.OnTouchListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnTouch
{
  int[] value();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.OnTouch
 * JD-Core Version:    0.7.0.1
 */