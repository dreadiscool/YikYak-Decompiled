import java.io.IOException;

public class sx
  extends IOException
{
  private sE a = null;
  
  public sx(String paramString)
  {
    super(paramString);
  }
  
  static sx b()
  {
    return new sx("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static sx c()
  {
    return new sx("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static sx d()
  {
    return new sx("CodedInputStream encountered a malformed varint.");
  }
  
  static sx e()
  {
    return new sx("Protocol message contained an invalid tag (zero).");
  }
  
  static sx f()
  {
    return new sx("Protocol message end-group tag did not match expected tag.");
  }
  
  static sx g()
  {
    return new sx("Protocol message tag had invalid wire type.");
  }
  
  static sx h()
  {
    return new sx("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static sx i()
  {
    return new sx("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static sx j()
  {
    return new sx("Protocol message had invalid UTF-8.");
  }
  
  public sE a()
  {
    return this.a;
  }
  
  public sx a(sE paramsE)
  {
    this.a = paramsE;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sx
 * JD-Core Version:    0.7.0.1
 */