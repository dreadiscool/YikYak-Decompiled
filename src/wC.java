import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.JsonWriter;
import android.view.View;
import android.view.ViewGroup;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@TargetApi(16)
class wC
{
  private final wF a;
  private final List<ws> b;
  private final wE c;
  private final Handler d;
  private final vd e;
  
  public wC(List<ws> paramList, vd paramvd)
  {
    this.b = paramList;
    this.e = paramvd;
    this.d = new Handler(Looper.getMainLooper());
    this.a = new wF();
    this.c = new wE(255);
  }
  
  private void b(JsonWriter paramJsonWriter, View paramView)
  {
    float f1 = 0.0F;
    int i = paramView.getId();
    String str;
    CharSequence localCharSequence;
    label84:
    Object localObject1;
    if (-1 == i)
    {
      str = null;
      paramJsonWriter.beginObject();
      paramJsonWriter.name("hashCode").value(paramView.hashCode());
      paramJsonWriter.name("id").value(i);
      paramJsonWriter.name("mp_id_name").value(str);
      localCharSequence = paramView.getContentDescription();
      if (localCharSequence != null) {
        break label408;
      }
      paramJsonWriter.name("contentDescription").nullValue();
      localObject1 = paramView.getTag();
      if (localObject1 != null) {
        break label428;
      }
      paramJsonWriter.name("tag").nullValue();
      label105:
      paramJsonWriter.name("top").value(paramView.getTop());
      paramJsonWriter.name("left").value(paramView.getLeft());
      paramJsonWriter.name("width").value(paramView.getWidth());
      paramJsonWriter.name("height").value(paramView.getHeight());
      paramJsonWriter.name("scrollX").value(paramView.getScrollX());
      paramJsonWriter.name("scrollY").value(paramView.getScrollY());
      paramJsonWriter.name("visibility").value(paramView.getVisibility());
      if (Build.VERSION.SDK_INT < 11) {
        break label529;
      }
      f1 = paramView.getTranslationX();
    }
    label529:
    for (float f2 = paramView.getTranslationY();; f2 = 0.0F)
    {
      paramJsonWriter.name("translationX").value(f1);
      paramJsonWriter.name("translationY").value(f2);
      paramJsonWriter.name("classes");
      paramJsonWriter.beginArray();
      Class localClass;
      for (Object localObject2 = paramView.getClass();; localObject2 = localClass)
      {
        paramJsonWriter.value((String)this.c.get(localObject2));
        localClass = ((Class)localObject2).getSuperclass();
        if ((localClass == Object.class) || (localClass == null))
        {
          paramJsonWriter.endArray();
          c(paramJsonWriter, paramView);
          paramJsonWriter.name("subviews");
          paramJsonWriter.beginArray();
          if ((paramView instanceof ViewGroup))
          {
            ViewGroup localViewGroup2 = (ViewGroup)paramView;
            int m = localViewGroup2.getChildCount();
            int n = 0;
            for (;;)
            {
              if (n < m)
              {
                View localView2 = localViewGroup2.getChildAt(n);
                if (localView2 != null) {
                  paramJsonWriter.value(localView2.hashCode());
                }
                n++;
                continue;
                str = this.e.a(i);
                break;
                label408:
                paramJsonWriter.name("contentDescription").value(localCharSequence.toString());
                break label84;
                label428:
                if (!(localObject1 instanceof CharSequence)) {
                  break label105;
                }
                paramJsonWriter.name("tag").value(localObject1.toString());
                break label105;
              }
            }
          }
          paramJsonWriter.endArray();
          paramJsonWriter.endObject();
          if ((paramView instanceof ViewGroup))
          {
            ViewGroup localViewGroup1 = (ViewGroup)paramView;
            int j = localViewGroup1.getChildCount();
            for (int k = 0; k < j; k++)
            {
              View localView1 = localViewGroup1.getChildAt(k);
              if (localView1 != null) {
                b(paramJsonWriter, localView1);
              }
            }
          }
          return;
        }
      }
    }
  }
  
  private void c(JsonWriter paramJsonWriter, View paramView)
  {
    Class localClass = paramView.getClass();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ws localws = (ws)localIterator.next();
      if ((localws.b.isAssignableFrom(localClass)) && (localws.c != null))
      {
        Object localObject = localws.c.a(paramView);
        if (localObject != null) {
          if ((localObject instanceof Number)) {
            paramJsonWriter.name(localws.a).value((Number)localObject);
          } else if ((localObject instanceof Boolean)) {
            paramJsonWriter.name(localws.a).value(((Boolean)localObject).booleanValue());
          } else {
            paramJsonWriter.name(localws.a).value(localObject.toString());
          }
        }
      }
    }
  }
  
  void a(JsonWriter paramJsonWriter, View paramView)
  {
    paramJsonWriter.beginArray();
    b(paramJsonWriter, paramView);
    paramJsonWriter.endArray();
  }
  
  public void a(wu<Activity> paramwu, OutputStream paramOutputStream)
  {
    this.a.a(paramwu);
    FutureTask localFutureTask = new FutureTask(this.a);
    this.d.post(localFutureTask);
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream);
    try
    {
      List localList = (List)localFutureTask.get(1L, TimeUnit.SECONDS);
      int i = localList.size();
      localOutputStreamWriter.write("[");
      for (int j = 0; j < i; j++)
      {
        if (j > 0) {
          localOutputStreamWriter.write(",");
        }
        wG localwG = (wG)localList.get(j);
        localOutputStreamWriter.write("{");
        localOutputStreamWriter.write("\"activity\":");
        localOutputStreamWriter.write(JSONObject.quote(localwG.a));
        localOutputStreamWriter.write(",");
        localOutputStreamWriter.write("\"scale\":");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Float.valueOf(localwG.d);
        localOutputStreamWriter.write(String.format("%s", arrayOfObject));
        localOutputStreamWriter.write(",");
        localOutputStreamWriter.write("\"serialized_objects\":");
        JsonWriter localJsonWriter = new JsonWriter(localOutputStreamWriter);
        localJsonWriter.beginObject();
        localJsonWriter.name("rootObject").value(localwG.b.hashCode());
        localJsonWriter.name("objects");
        a(localJsonWriter, localwG.b);
        localJsonWriter.endObject();
        localJsonWriter.flush();
        localOutputStreamWriter.write(",");
        localOutputStreamWriter.write("\"screenshot\":");
        localOutputStreamWriter.flush();
        localwG.c.a(Bitmap.CompressFormat.PNG, 100, paramOutputStream);
        localOutputStreamWriter.write("}");
      }
      localOutputStreamWriter.write("]");
      localOutputStreamWriter.flush();
      label329:
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label329;
    }
    catch (TimeoutException localTimeoutException)
    {
      break label329;
    }
    catch (ExecutionException localExecutionException)
    {
      break label329;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wC
 * JD-Core Version:    0.7.0.1
 */