public final class zk
{
  private boolean a;
  private String[] b;
  private String[] c;
  private boolean d;
  
  public zk(zi paramzi)
  {
    this.a = paramzi.d;
    this.b = zi.a(paramzi);
    this.c = zi.b(paramzi);
    this.d = paramzi.e;
  }
  
  private zk(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public zi a()
  {
    return new zi(this, null);
  }
  
  public zk a(boolean paramBoolean)
  {
    if (!this.a) {
      throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    this.d = paramBoolean;
    return this;
  }
  
  zk a(String[] paramArrayOfString)
  {
    this.b = paramArrayOfString;
    return this;
  }
  
  public zk a(zK... paramVarArgs)
  {
    if (!this.a) {
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    String[] arrayOfString = new String[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      arrayOfString[i] = paramVarArgs[i].e;
    }
    return b(arrayOfString);
  }
  
  public zk a(ze... paramVarArgs)
  {
    if (!this.a) {
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    String[] arrayOfString = new String[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      arrayOfString[i] = paramVarArgs[i].aS;
    }
    return a(arrayOfString);
  }
  
  zk b(String... paramVarArgs)
  {
    this.c = paramVarArgs;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zk
 * JD-Core Version:    0.7.0.1
 */