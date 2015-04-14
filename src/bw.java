public enum bw
{
  private Class ak;
  
  static
  {
    A = new bw("FadeOut", 26, bV.class);
    B = new bw("FadeOutDown", 27, bW.class);
    C = new bw("FadeOutLeft", 28, bX.class);
    D = new bw("FadeOutRight", 29, bY.class);
    E = new bw("FadeOutUp", 30, bZ.class);
    F = new bw("FlipInX", 31, ca.class);
    G = new bw("FlipOutX", 32, cb.class);
    H = new bw("FlipOutY", 33, cc.class);
    I = new bw("RotateIn", 34, cd.class);
    J = new bw("RotateInDownLeft", 35, ce.class);
    K = new bw("RotateInDownRight", 36, cf.class);
    L = new bw("RotateInUpLeft", 37, cg.class);
    M = new bw("RotateInUpRight", 38, ch.class);
    N = new bw("RotateOut", 39, ci.class);
    O = new bw("RotateOutDownLeft", 40, cj.class);
    P = new bw("RotateOutDownRight", 41, ck.class);
    Q = new bw("RotateOutUpLeft", 42, cl.class);
    R = new bw("RotateOutUpRight", 43, cm.class);
    S = new bw("SlideInLeft", 44, co.class);
    T = new bw("SlideInRight", 45, cp.class);
    U = new bw("SlideInUp", 46, cq.class);
    V = new bw("SlideInDown", 47, cn.class);
    W = new bw("SlideOutLeft", 48, cs.class);
    X = new bw("SlideOutRight", 49, ct.class);
    Y = new bw("SlideOutUp", 50, cu.class);
    Z = new bw("SlideOutDown", 51, cr.class);
    aa = new bw("ZoomIn", 52, cB.class);
    ab = new bw("ZoomInDown", 53, cC.class);
    ac = new bw("ZoomInLeft", 54, cD.class);
    ad = new bw("ZoomInRight", 55, cE.class);
    ae = new bw("ZoomInUp", 56, cF.class);
    af = new bw("ZoomOut", 57, cG.class);
    ag = new bw("ZoomOutDown", 58, cH.class);
    ah = new bw("ZoomOutLeft", 59, cI.class);
    ai = new bw("ZoomOutRight", 60, cJ.class);
    aj = new bw("ZoomOutUp", 61, cK.class);
    bw[] arrayOfbw = new bw[62];
    arrayOfbw[0] = a;
    arrayOfbw[1] = b;
    arrayOfbw[2] = c;
    arrayOfbw[3] = d;
    arrayOfbw[4] = e;
    arrayOfbw[5] = f;
    arrayOfbw[6] = g;
    arrayOfbw[7] = h;
    arrayOfbw[8] = i;
    arrayOfbw[9] = j;
    arrayOfbw[10] = k;
    arrayOfbw[11] = l;
    arrayOfbw[12] = m;
    arrayOfbw[13] = n;
    arrayOfbw[14] = o;
    arrayOfbw[15] = p;
    arrayOfbw[16] = q;
    arrayOfbw[17] = r;
    arrayOfbw[18] = s;
    arrayOfbw[19] = t;
    arrayOfbw[20] = u;
    arrayOfbw[21] = v;
    arrayOfbw[22] = w;
    arrayOfbw[23] = x;
    arrayOfbw[24] = y;
    arrayOfbw[25] = z;
    arrayOfbw[26] = A;
    arrayOfbw[27] = B;
    arrayOfbw[28] = C;
    arrayOfbw[29] = D;
    arrayOfbw[30] = E;
    arrayOfbw[31] = F;
    arrayOfbw[32] = G;
    arrayOfbw[33] = H;
    arrayOfbw[34] = I;
    arrayOfbw[35] = J;
    arrayOfbw[36] = K;
    arrayOfbw[37] = L;
    arrayOfbw[38] = M;
    arrayOfbw[39] = N;
    arrayOfbw[40] = O;
    arrayOfbw[41] = P;
    arrayOfbw[42] = Q;
    arrayOfbw[43] = R;
    arrayOfbw[44] = S;
    arrayOfbw[45] = T;
    arrayOfbw[46] = U;
    arrayOfbw[47] = V;
    arrayOfbw[48] = W;
    arrayOfbw[49] = X;
    arrayOfbw[50] = Y;
    arrayOfbw[51] = Z;
    arrayOfbw[52] = aa;
    arrayOfbw[53] = ab;
    arrayOfbw[54] = ac;
    arrayOfbw[55] = ad;
    arrayOfbw[56] = ae;
    arrayOfbw[57] = af;
    arrayOfbw[58] = ag;
    arrayOfbw[59] = ah;
    arrayOfbw[60] = ai;
    arrayOfbw[61] = aj;
    al = arrayOfbw;
  }
  
  private bw(Class paramClass)
  {
    this.ak = paramClass;
  }
  
  public bv a()
  {
    try
    {
      bv localbv = (bv)this.ak.newInstance();
      return localbv;
    }
    catch (Exception localException)
    {
      throw new Error("Can not init animatorClazz instance");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bw
 * JD-Core Version:    0.7.0.1
 */