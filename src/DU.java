import com.yik.yak.ui.activity.SendAYak;

public class DU
  implements Runnable
{
  public DU(SendAYak paramSendAYak) {}
  
  public void run()
  {
    SendAYak.c(this.a, SendAYak.b(this.a));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DU
 * JD-Core Version:    0.7.0.1
 */