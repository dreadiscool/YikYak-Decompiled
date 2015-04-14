package butterknife.internal;

final class Parameter
{
  static final Parameter[] NONE = new Parameter[0];
  private final int listenerPosition;
  private final String type;
  
  Parameter(int paramInt, String paramString)
  {
    this.listenerPosition = paramInt;
    this.type = paramString;
  }
  
  int getListenerPosition()
  {
    return this.listenerPosition;
  }
  
  String getType()
  {
    return this.type;
  }
  
  public boolean requiresCast(String paramString)
  {
    if (!this.type.equals(paramString)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.internal.Parameter
 * JD-Core Version:    0.7.0.1
 */