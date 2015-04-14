public abstract class sn<MessageType extends sl, BuilderType extends sn>
  extends rT<BuilderType>
{
  private rZ a = rZ.a;
  
  public final BuilderType a(rZ paramrZ)
  {
    this.a = paramrZ;
    return this;
  }
  
  public abstract BuilderType a(MessageType paramMessageType);
  
  public abstract MessageType e();
  
  public BuilderType f()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public final rZ r()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sn
 * JD-Core Version:    0.7.0.1
 */