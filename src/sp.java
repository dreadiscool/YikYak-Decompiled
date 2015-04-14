public abstract class sp<MessageType extends sp<MessageType>>
  extends sl
  implements sq<MessageType>
{
  private final si<sr> a;
  
  protected sp()
  {
    this.a = si.a();
  }
  
  protected sp(so<MessageType, ?> paramso)
  {
    this.a = so.a(paramso);
  }
  
  protected boolean I()
  {
    return this.a.e();
  }
  
  protected void R()
  {
    this.a.c();
  }
  
  protected boolean a(sc paramsc, se paramse, sg paramsg, int paramInt)
  {
    return sl.a(this.a, p(), paramsc, paramse, paramsg, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sp
 * JD-Core Version:    0.7.0.1
 */