package butterknife.internal;

final class ViewBinding
  implements Binding
{
  private final String name;
  private final boolean required;
  private final String type;
  
  ViewBinding(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.name = paramString1;
    this.type = paramString2;
    this.required = paramBoolean;
  }
  
  public String getDescription()
  {
    return "field '" + this.name + "'";
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public boolean isRequired()
  {
    return this.required;
  }
  
  public boolean requiresCast()
  {
    if (!"android.view.View".equals(this.type)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.internal.ViewBinding
 * JD-Core Version:    0.7.0.1
 */