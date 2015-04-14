package android.support.v4.widget;

import android.view.animation.Interpolator;

final class BakedBezierInterpolator
  implements Interpolator
{
  private static final BakedBezierInterpolator INSTANCE = new BakedBezierInterpolator();
  private static final float STEP_SIZE = 1.0F / (-1 + VALUES.length);
  private static final float[] VALUES;
  
  static
  {
    float[] arrayOfFloat = new float[101];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0002F;
    arrayOfFloat[2] = 0.0009F;
    arrayOfFloat[3] = 0.0019F;
    arrayOfFloat[4] = 0.0036F;
    arrayOfFloat[5] = 0.0059F;
    arrayOfFloat[6] = 0.0086F;
    arrayOfFloat[7] = 0.0119F;
    arrayOfFloat[8] = 0.0157F;
    arrayOfFloat[9] = 0.0209F;
    arrayOfFloat[10] = 0.0257F;
    arrayOfFloat[11] = 0.0321F;
    arrayOfFloat[12] = 0.0392F;
    arrayOfFloat[13] = 0.0469F;
    arrayOfFloat[14] = 0.0566F;
    arrayOfFloat[15] = 0.0656F;
    arrayOfFloat[16] = 0.0768F;
    arrayOfFloat[17] = 0.0887F;
    arrayOfFloat[18] = 0.1033F;
    arrayOfFloat[19] = 0.1186F;
    arrayOfFloat[20] = 0.1349F;
    arrayOfFloat[21] = 0.1519F;
    arrayOfFloat[22] = 0.1696F;
    arrayOfFloat[23] = 0.1928F;
    arrayOfFloat[24] = 0.2121F;
    arrayOfFloat[25] = 0.237F;
    arrayOfFloat[26] = 0.2627F;
    arrayOfFloat[27] = 0.2892F;
    arrayOfFloat[28] = 0.3109F;
    arrayOfFloat[29] = 0.3386F;
    arrayOfFloat[30] = 0.3667F;
    arrayOfFloat[31] = 0.3952F;
    arrayOfFloat[32] = 0.4241F;
    arrayOfFloat[33] = 0.4474F;
    arrayOfFloat[34] = 0.4766F;
    arrayOfFloat[35] = 0.5F;
    arrayOfFloat[36] = 0.5234F;
    arrayOfFloat[37] = 0.5468F;
    arrayOfFloat[38] = 0.5701F;
    arrayOfFloat[39] = 0.5933F;
    arrayOfFloat[40] = 0.6134F;
    arrayOfFloat[41] = 0.6333F;
    arrayOfFloat[42] = 0.6531F;
    arrayOfFloat[43] = 0.6698F;
    arrayOfFloat[44] = 0.6891F;
    arrayOfFloat[45] = 0.7054F;
    arrayOfFloat[46] = 0.7214F;
    arrayOfFloat[47] = 0.7346F;
    arrayOfFloat[48] = 0.7502F;
    arrayOfFloat[49] = 0.763F;
    arrayOfFloat[50] = 0.7756F;
    arrayOfFloat[51] = 0.7879F;
    arrayOfFloat[52] = 0.8F;
    arrayOfFloat[53] = 0.8107F;
    arrayOfFloat[54] = 0.8212F;
    arrayOfFloat[55] = 0.8326F;
    arrayOfFloat[56] = 0.8415F;
    arrayOfFloat[57] = 0.8503F;
    arrayOfFloat[58] = 0.8588F;
    arrayOfFloat[59] = 0.8672F;
    arrayOfFloat[60] = 0.8754F;
    arrayOfFloat[61] = 0.8833F;
    arrayOfFloat[62] = 0.8911F;
    arrayOfFloat[63] = 0.8977F;
    arrayOfFloat[64] = 0.9041F;
    arrayOfFloat[65] = 0.9113F;
    arrayOfFloat[66] = 0.9165F;
    arrayOfFloat[67] = 0.9232F;
    arrayOfFloat[68] = 0.9281F;
    arrayOfFloat[69] = 0.9328F;
    arrayOfFloat[70] = 0.9382F;
    arrayOfFloat[71] = 0.9434F;
    arrayOfFloat[72] = 0.9476F;
    arrayOfFloat[73] = 0.9518F;
    arrayOfFloat[74] = 0.9557F;
    arrayOfFloat[75] = 0.9596F;
    arrayOfFloat[76] = 0.9632F;
    arrayOfFloat[77] = 0.9662F;
    arrayOfFloat[78] = 0.9695F;
    arrayOfFloat[79] = 0.9722F;
    arrayOfFloat[80] = 0.9753F;
    arrayOfFloat[81] = 0.9777F;
    arrayOfFloat[82] = 0.9805F;
    arrayOfFloat[83] = 0.9826F;
    arrayOfFloat[84] = 0.9847F;
    arrayOfFloat[85] = 0.9866F;
    arrayOfFloat[86] = 0.9884F;
    arrayOfFloat[87] = 0.9901F;
    arrayOfFloat[88] = 0.9917F;
    arrayOfFloat[89] = 0.9931F;
    arrayOfFloat[90] = 0.9944F;
    arrayOfFloat[91] = 0.9955F;
    arrayOfFloat[92] = 0.9964F;
    arrayOfFloat[93] = 0.9973F;
    arrayOfFloat[94] = 0.9981F;
    arrayOfFloat[95] = 0.9986F;
    arrayOfFloat[96] = 0.9992F;
    arrayOfFloat[97] = 0.9995F;
    arrayOfFloat[98] = 0.9998F;
    arrayOfFloat[99] = 1.0F;
    arrayOfFloat[100] = 1.0F;
    VALUES = arrayOfFloat;
  }
  
  public static final BakedBezierInterpolator getInstance()
  {
    return INSTANCE;
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f1 = 1.0F;
    if (paramFloat >= f1) {}
    for (;;)
    {
      return f1;
      if (paramFloat <= 0.0F)
      {
        f1 = 0.0F;
      }
      else
      {
        int i = Math.min((int)(paramFloat * (-1 + VALUES.length)), -2 + VALUES.length);
        float f2 = (paramFloat - i * STEP_SIZE) / STEP_SIZE;
        f1 = VALUES[i] + f2 * (VALUES[(i + 1)] - VALUES[i]);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.BakedBezierInterpolator
 * JD-Core Version:    0.7.0.1
 */