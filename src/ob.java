class ob
{
  public static hf a(hf paramhf)
  {
    hf localhf = new hf();
    localhf.a = paramhf.a;
    localhf.k = ((int[])paramhf.k.clone());
    if (paramhf.l) {
      localhf.l = paramhf.l;
    }
    return localhf;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ob
 * JD-Core Version:    0.7.0.1
 */