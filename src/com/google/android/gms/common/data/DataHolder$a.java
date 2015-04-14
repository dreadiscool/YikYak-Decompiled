package com.google.android.gms.common.data;

import hZ;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHolder$a
{
  private final String[] Ld;
  private final ArrayList<HashMap<String, Object>> Lm;
  private final String Ln;
  private final HashMap<Object, Integer> Lo;
  private boolean Lp;
  private String Lq;
  
  private DataHolder$a(String[] paramArrayOfString, String paramString)
  {
    this.Ld = ((String[])hZ.a(paramArrayOfString));
    this.Lm = new ArrayList();
    this.Ln = paramString;
    this.Lo = new HashMap();
    this.Lp = false;
    this.Lq = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder.a
 * JD-Core Version:    0.7.0.1
 */