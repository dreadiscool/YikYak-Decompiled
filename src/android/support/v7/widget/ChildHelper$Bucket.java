package android.support.v7.widget;

class ChildHelper$Bucket
{
  static final int BITS_PER_WORD = 64;
  static final long LAST_BIT = -9223372036854775808L;
  long mData = 0L;
  Bucket next;
  
  private void ensureNext()
  {
    if (this.next == null) {
      this.next = new Bucket();
    }
  }
  
  void clear(int paramInt)
  {
    if (paramInt >= 64) {
      if (this.next != null) {
        this.next.clear(paramInt - 64);
      }
    }
    for (;;)
    {
      return;
      this.mData &= (0xFFFFFFFF ^ 1L << paramInt);
    }
  }
  
  int countOnesBefore(int paramInt)
  {
    int i;
    if (this.next == null) {
      if (paramInt >= 64) {
        i = Long.bitCount(this.mData);
      }
    }
    for (;;)
    {
      return i;
      i = Long.bitCount(this.mData & (1L << paramInt) - 1L);
      continue;
      if (paramInt < 64) {
        i = Long.bitCount(this.mData & (1L << paramInt) - 1L);
      } else {
        i = this.next.countOnesBefore(paramInt - 64) + Long.bitCount(this.mData);
      }
    }
  }
  
  boolean get(int paramInt)
  {
    boolean bool;
    if (paramInt >= 64)
    {
      ensureNext();
      bool = this.next.get(paramInt - 64);
    }
    for (;;)
    {
      return bool;
      if ((this.mData & 1L << paramInt) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  void insert(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      this.next.insert(paramInt - 64, paramBoolean);
    }
    label38:
    label111:
    label117:
    for (;;)
    {
      return;
      boolean bool;
      if ((0x0 & this.mData) != 0L)
      {
        bool = true;
        long l = (1L << paramInt) - 1L;
        this.mData = (l & this.mData | (this.mData & (l ^ 0xFFFFFFFF)) << 1);
        if (!paramBoolean) {
          break label111;
        }
        set(paramInt);
      }
      for (;;)
      {
        if ((!bool) && (this.next == null)) {
          break label117;
        }
        ensureNext();
        this.next.insert(0, bool);
        break;
        bool = false;
        break label38;
        clear(paramInt);
      }
    }
  }
  
  boolean remove(int paramInt)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      bool = this.next.remove(paramInt - 64);
      return bool;
    }
    long l1 = 1L << paramInt;
    if ((l1 & this.mData) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.mData &= (l1 ^ 0xFFFFFFFF);
      long l2 = l1 - 1L;
      this.mData = (l2 & this.mData | Long.rotateRight(this.mData & (l2 ^ 0xFFFFFFFF), 1));
      if (this.next == null) {
        break;
      }
      if (this.next.get(0)) {
        set(63);
      }
      this.next.remove(0);
      break;
    }
  }
  
  void reset()
  {
    this.mData = 0L;
    if (this.next != null) {
      this.next.reset();
    }
  }
  
  void set(int paramInt)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      this.next.set(paramInt - 64);
    }
    for (;;)
    {
      return;
      this.mData |= 1L << paramInt;
    }
  }
  
  public String toString()
  {
    if (this.next == null) {}
    for (String str = Long.toBinaryString(this.mData);; str = this.next.toString() + "xx" + Long.toBinaryString(this.mData)) {
      return str;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ChildHelper.Bucket
 * JD-Core Version:    0.7.0.1
 */