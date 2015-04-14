public class Cu
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k;
  private String l;
  private boolean m;
  
  public Cu() {}
  
  public Cu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.l = paramString10;
    this.j = paramString11;
    this.i = paramString12;
    try
    {
      this.k = paramString9.substring(0, 19).replace("T", " ");
      this.m = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.k = paramString9;
      }
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.h;
  }
  
  public String d()
  {
    return this.k;
  }
  
  public String e()
  {
    return this.i;
  }
  
  public String f()
  {
    return this.j;
  }
  
  public int g()
  {
    int n = 2130837834;
    if ((this.l.equals("new")) || (this.l.equals("unread"))) {
      if (this.g.equals("vote")) {
        n = 2130837796;
      }
    }
    for (;;)
    {
      return n;
      if (this.g.equals("fictional"))
      {
        n = 2130837800;
      }
      else if (this.g.equals("comment"))
      {
        n = 2130837818;
      }
      else if (this.g.equals("deleted"))
      {
        n = 2130837821;
      }
      else
      {
        n = 2130837835;
        continue;
        if ((this.l.equals("read")) || (this.l.equals("deleted"))) {
          if (this.g.equals("vote")) {
            n = 2130837795;
          } else if (this.g.equals("fictional")) {
            n = 2130837799;
          } else if (this.g.equals("comment")) {
            n = 2130837817;
          } else if (this.g.equals("deleted")) {
            n = 2130837820;
          }
        }
      }
    }
  }
  
  public int h()
  {
    int n = 2131427586;
    if ((this.l.equals("new")) || (this.l.equals("unread"))) {
      if (this.g.equals("vote")) {
        n = 2131427591;
      }
    }
    for (;;)
    {
      return n;
      if (this.g.equals("fictional"))
      {
        n = 2131427584;
      }
      else if (this.g.equals("comment"))
      {
        n = 2131427580;
      }
      else if (this.g.equals("deleted"))
      {
        n = 2131427582;
      }
      else
      {
        n = 2131427587;
        continue;
        if (this.l.equals("read")) {
          if (this.g.equals("vote")) {
            n = 2131427590;
          } else if (this.g.equals("fictional")) {
            n = 2131427583;
          } else if (this.g.equals("comment")) {
            n = 2131427579;
          } else if (this.g.equals("deleted")) {
            n = 2131427581;
          }
        }
      }
    }
  }
  
  public String i()
  {
    return this.l;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Cu
 * JD-Core Version:    0.7.0.1
 */