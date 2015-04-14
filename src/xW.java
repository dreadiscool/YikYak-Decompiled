import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

class xW
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    ArrayList localArrayList1 = (ArrayList)xQ.h().get();
    ArrayList localArrayList2 = (ArrayList)xQ.i().get();
    ArrayList localArrayList5;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      localArrayList5 = (ArrayList)xQ.j().get();
      if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0)) {
        i = 0;
      }
      break;
    }
    for (;;)
    {
      if (localArrayList5.size() > 0)
      {
        ArrayList localArrayList6 = (ArrayList)localArrayList5.clone();
        localArrayList5.clear();
        int i7 = localArrayList6.size();
        int i8 = 0;
        if (i8 < i7)
        {
          xQ localxQ4 = (xQ)localArrayList6.get(i8);
          if (xQ.a(localxQ4) == 0L) {
            xQ.b(localxQ4);
          }
          for (;;)
          {
            i8++;
            break;
            localArrayList2.add(localxQ4);
          }
          i = 1;
        }
      }
      else
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        ArrayList localArrayList3 = (ArrayList)xQ.k().get();
        ArrayList localArrayList4 = (ArrayList)xQ.l().get();
        int j = localArrayList2.size();
        for (int k = 0; k < j; k++)
        {
          xQ localxQ3 = (xQ)localArrayList2.get(k);
          if (xQ.a(localxQ3, l)) {
            localArrayList3.add(localxQ3);
          }
        }
        int m = localArrayList3.size();
        if (m > 0)
        {
          for (int i6 = 0; i6 < m; i6++)
          {
            xQ localxQ2 = (xQ)localArrayList3.get(i6);
            xQ.b(localxQ2);
            xQ.a(localxQ2, true);
            localArrayList2.remove(localxQ2);
          }
          localArrayList3.clear();
        }
        int n = localArrayList1.size();
        int i1 = 0;
        if (i1 < n)
        {
          xQ localxQ1 = (xQ)localArrayList1.get(i1);
          if (localxQ1.e(l)) {
            localArrayList4.add(localxQ1);
          }
          int i4;
          if (localArrayList1.size() == n) {
            i4 = i1 + 1;
          }
          int i3;
          for (int i5 = n;; i5 = i3)
          {
            n = i5;
            i1 = i4;
            break;
            i3 = n - 1;
            localArrayList4.remove(localxQ1);
            i4 = i1;
          }
        }
        if (localArrayList4.size() > 0)
        {
          for (int i2 = 0; i2 < localArrayList4.size(); i2++) {
            xQ.c((xQ)localArrayList4.get(i2));
          }
          localArrayList4.clear();
        }
        if ((i == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))) {
          break;
        }
        sendEmptyMessageDelayed(1, Math.max(0L, xQ.m() - (AnimationUtils.currentAnimationTimeMillis() - l)));
        break;
        i = 1;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xW
 * JD-Core Version:    0.7.0.1
 */