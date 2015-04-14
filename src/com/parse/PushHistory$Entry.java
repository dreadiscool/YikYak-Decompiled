package com.parse;

class PushHistory$Entry
  implements Comparable<Entry>
{
  public String pushId;
  public String timestamp;
  
  public PushHistory$Entry(String paramString1, String paramString2)
  {
    this.pushId = paramString1;
    this.timestamp = paramString2;
  }
  
  public int compareTo(Entry paramEntry)
  {
    return this.timestamp.compareTo(paramEntry.timestamp);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushHistory.Entry
 * JD-Core Version:    0.7.0.1
 */