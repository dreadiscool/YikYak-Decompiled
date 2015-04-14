final class qZ
  implements pn
{
  public <T> pm<T> a(oR paramoR, rn<T> paramrn)
  {
    Class localClass = paramrn.a();
    if ((!Enum.class.isAssignableFrom(localClass)) || (localClass == Enum.class)) {}
    for (Object localObject = null;; localObject = new rm(localClass))
    {
      return localObject;
      if (!localClass.isEnum()) {
        localClass = localClass.getSuperclass();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qZ
 * JD-Core Version:    0.7.0.1
 */