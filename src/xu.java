class xu
  extends xt
{
  float d;
  
  xu(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Float.TYPE;
  }
  
  xu(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.d = paramFloat2;
    this.b = Float.TYPE;
    this.c = true;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == Float.class))
    {
      this.d = ((Float)paramObject).floatValue();
      this.c = true;
    }
  }
  
  public Object b()
  {
    return Float.valueOf(this.d);
  }
  
  public float f()
  {
    return this.d;
  }
  
  public xu g()
  {
    xu localxu = new xu(c(), this.d);
    localxu.a(d());
    return localxu;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xu
 * JD-Core Version:    0.7.0.1
 */