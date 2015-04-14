import java.util.List;

class yX
  implements zs
{
  private final int b;
  private final zz c;
  
  yX(yV paramyV, int paramInt, zz paramzz)
  {
    this.b = paramInt;
    this.c = paramzz;
  }
  
  public zF a(zz paramzz)
  {
    yX localyX;
    if (this.b < yV.c(this.a).u().size()) {
      localyX = new yX(this.a, 1 + this.b, paramzz);
    }
    for (zF localzF = ((zr)yV.c(this.a).u().get(this.b)).a(localyX);; localzF = this.a.a(paramzz, false)) {
      return localzF;
    }
  }
  
  public zz a()
  {
    return this.c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yX
 * JD-Core Version:    0.7.0.1
 */