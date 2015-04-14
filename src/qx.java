import java.lang.reflect.Field;

class qx
  extends qz
{
  final pm<?> a = this.b.a(this.c);
  
  qx(qw paramqw, String paramString, boolean paramBoolean1, boolean paramBoolean2, oR paramoR, rn paramrn, Field paramField, boolean paramBoolean3)
  {
    super(paramString, paramBoolean1, paramBoolean2);
  }
  
  void a(ro paramro, Object paramObject)
  {
    Object localObject = this.a.b(paramro);
    if ((localObject != null) || (!this.e)) {
      this.d.set(paramObject, localObject);
    }
  }
  
  void a(rr paramrr, Object paramObject)
  {
    Object localObject = this.d.get(paramObject);
    new qE(this.b, this.a, this.c.b()).a(paramrr, localObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qx
 * JD-Core Version:    0.7.0.1
 */