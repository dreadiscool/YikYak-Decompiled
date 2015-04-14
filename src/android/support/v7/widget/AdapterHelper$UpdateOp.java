package android.support.v7.widget;

class AdapterHelper$UpdateOp
{
  static final int ADD = 0;
  static final int MOVE = 3;
  static final int POOL_SIZE = 30;
  static final int REMOVE = 1;
  static final int UPDATE = 2;
  int cmd;
  int itemCount;
  int positionStart;
  
  AdapterHelper$UpdateOp(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cmd = paramInt1;
    this.positionStart = paramInt2;
    this.itemCount = paramInt3;
  }
  
  String cmdToString()
  {
    String str;
    switch (this.cmd)
    {
    default: 
      str = "??";
    }
    for (;;)
    {
      return str;
      str = "add";
      continue;
      str = "rm";
      continue;
      str = "up";
      continue;
      str = "mv";
    }
  }
  
  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject) {}
    for (;;)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
      }
      else
      {
        UpdateOp localUpdateOp = (UpdateOp)paramObject;
        if (this.cmd != localUpdateOp.cmd)
        {
          i = 0;
        }
        else if ((this.cmd != 3) || (Math.abs(this.itemCount - this.positionStart) != i) || (this.itemCount != localUpdateOp.positionStart) || (this.positionStart != localUpdateOp.itemCount))
        {
          int j;
          if (this.itemCount != localUpdateOp.itemCount) {
            j = 0;
          } else if (this.positionStart != localUpdateOp.positionStart) {
            j = 0;
          }
        }
      }
    }
  }
  
  public int hashCode()
  {
    return 31 * (31 * this.cmd + this.positionStart) + this.itemCount;
  }
  
  public String toString()
  {
    return "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + "]";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AdapterHelper.UpdateOp
 * JD-Core Version:    0.7.0.1
 */