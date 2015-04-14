package com.yik.yak.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class DialogScrollView
  extends ScrollView
{
  private Context a;
  
  public DialogScrollView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public DialogScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public DialogScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  /* Error */
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 24	android/util/DisplayMetrics
    //   3: dup
    //   4: invokespecial 27	android/util/DisplayMetrics:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 12	com/yik/yak/ui/view/DialogScrollView:a	Landroid/content/Context;
    //   12: ldc 29
    //   14: invokevirtual 35	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 37	android/view/WindowManager
    //   20: invokeinterface 41 1 0
    //   25: aload_3
    //   26: invokevirtual 47	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   29: aload_3
    //   30: getfield 51	android/util/DisplayMetrics:heightPixels	I
    //   33: istore 6
    //   35: iload_2
    //   36: invokestatic 57	android/view/View$MeasureSpec:getSize	(I)I
    //   39: istore 7
    //   41: iload 7
    //   43: i2d
    //   44: ldc2_w 58
    //   47: iload 6
    //   49: i2d
    //   50: dmul
    //   51: dcmpl
    //   52: ifle +13 -> 65
    //   55: ldc2_w 58
    //   58: iload 6
    //   60: i2d
    //   61: dmul
    //   62: d2i
    //   63: istore 7
    //   65: iload 7
    //   67: ldc 60
    //   69: invokestatic 64	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   72: istore_2
    //   73: aload_0
    //   74: invokevirtual 68	com/yik/yak/ui/view/DialogScrollView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   77: iload 7
    //   79: putfield 73	android/view/ViewGroup$LayoutParams:height	I
    //   82: aload_0
    //   83: iload_1
    //   84: iload_2
    //   85: invokespecial 75	android/widget/ScrollView:onMeasure	(II)V
    //   88: return
    //   89: astore 5
    //   91: aload_0
    //   92: iload_1
    //   93: iload_2
    //   94: invokespecial 75	android/widget/ScrollView:onMeasure	(II)V
    //   97: goto -9 -> 88
    //   100: astore 4
    //   102: aload_0
    //   103: iload_1
    //   104: iload_2
    //   105: invokespecial 75	android/widget/ScrollView:onMeasure	(II)V
    //   108: aload 4
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	DialogScrollView
    //   0	111	1	paramInt1	int
    //   0	111	2	paramInt2	int
    //   7	23	3	localDisplayMetrics	android.util.DisplayMetrics
    //   100	9	4	localObject	java.lang.Object
    //   89	1	5	localException	java.lang.Exception
    //   33	26	6	i	int
    //   39	39	7	j	int
    // Exception table:
    //   from	to	target	type
    //   0	82	89	java/lang/Exception
    //   0	82	100	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.DialogScrollView
 * JD-Core Version:    0.7.0.1
 */