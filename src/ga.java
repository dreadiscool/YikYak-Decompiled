import android.os.IInterface;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

public abstract interface ga
  extends IInterface
{
  public abstract void a();
  
  public abstract void a(Map paramMap, long paramLong, String paramString, List<Command> paramList);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ga
 * JD-Core Version:    0.7.0.1
 */