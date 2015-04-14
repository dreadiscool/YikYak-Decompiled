import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Status;

class ih
  extends ib
{
  private final BaseImplementation.b<Status> a;
  
  public ih(BaseImplementation.b<Status> paramb)
  {
    this.a = paramb;
  }
  
  public void a(int paramInt)
  {
    this.a.b(new Status(paramInt));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ih
 * JD-Core Version:    0.7.0.1
 */