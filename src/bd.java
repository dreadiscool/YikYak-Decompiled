final class bd
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public final String k;
  private String l;
  
  public bd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
    this.k = paramString11;
  }
  
  public String toString()
  {
    if (this.l == null) {
      this.l = ("appBundleId=" + this.a + ", executionId=" + this.b + ", installationId=" + this.c + ", androidId=" + this.d + ", advertisingId=" + this.e + ", betaDeviceToken=" + this.f + ", buildId=" + this.g + ", osVersion=" + this.h + ", deviceModel=" + this.i + ", appVersionCode=" + this.j + ", appVersionName=" + this.k);
    }
    return this.l;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bd
 * JD-Core Version:    0.7.0.1
 */