public abstract class so<MessageType extends sp<MessageType>, BuilderType extends so<MessageType, BuilderType>>
  extends sn<MessageType, BuilderType>
  implements sq<MessageType>
{
  private si<sr> a = si.b();
  private boolean b;
  
  private void a()
  {
    if (!this.b)
    {
      this.a = this.a.d();
      this.b = true;
    }
  }
  
  private si<sr> b()
  {
    this.a.c();
    this.b = false;
    return this.a;
  }
  
  protected final void a(MessageType paramMessageType)
  {
    a();
    this.a.a(sp.a(paramMessageType));
  }
  
  public BuilderType o()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected boolean s()
  {
    return this.a.e();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     so
 * JD-Core Version:    0.7.0.1
 */