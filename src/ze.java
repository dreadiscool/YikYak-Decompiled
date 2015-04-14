public enum ze
{
  final String aS;
  
  static
  {
    A = new ze("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 26, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40, 2712, 6, 2147483647);
    B = new ze("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 27, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41, 2712, 6, 2147483647);
    C = new ze("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 28, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43, 2712, 6, 2147483647);
    D = new ze("TLS_RSA_WITH_AES_128_CBC_SHA", 29, "TLS_RSA_WITH_AES_128_CBC_SHA", 47, 5246, 6, 10);
    E = new ze("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 30, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50, 5246, 6, 10);
    F = new ze("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 31, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51, 5246, 6, 10);
    G = new ze("TLS_DH_anon_WITH_AES_128_CBC_SHA", 32, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52, 5246, 6, 10);
    H = new ze("TLS_RSA_WITH_AES_256_CBC_SHA", 33, "TLS_RSA_WITH_AES_256_CBC_SHA", 53, 5246, 6, 10);
    I = new ze("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 34, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56, 5246, 6, 10);
    J = new ze("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 35, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57, 5246, 6, 10);
    K = new ze("TLS_DH_anon_WITH_AES_256_CBC_SHA", 36, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58, 5246, 6, 10);
    L = new ze("TLS_RSA_WITH_NULL_SHA256", 37, "TLS_RSA_WITH_NULL_SHA256", 59, 5246, 7, 21);
    M = new ze("TLS_RSA_WITH_AES_128_CBC_SHA256", 38, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60, 5246, 7, 21);
    N = new ze("TLS_RSA_WITH_AES_256_CBC_SHA256", 39, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61, 5246, 7, 21);
    O = new ze("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 40, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64, 5246, 7, 21);
    P = new ze("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 41, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103, 5246, 7, 21);
    Q = new ze("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 42, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106, 5246, 7, 21);
    R = new ze("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 43, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107, 5246, 7, 21);
    S = new ze("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 44, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108, 5246, 7, 21);
    T = new ze("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 45, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109, 5246, 7, 21);
    U = new ze("TLS_RSA_WITH_AES_128_GCM_SHA256", 46, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156, 5288, 8, 21);
    V = new ze("TLS_RSA_WITH_AES_256_GCM_SHA384", 47, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157, 5288, 8, 21);
    W = new ze("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 48, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158, 5288, 8, 21);
    X = new ze("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 49, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159, 5288, 8, 21);
    Y = new ze("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 50, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162, 5288, 8, 21);
    Z = new ze("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 51, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163, 5288, 8, 21);
    aa = new ze("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 52, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166, 5288, 8, 21);
    ab = new ze("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 53, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167, 5288, 8, 21);
    ac = new ze("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 54, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255, 5746, 6, 14);
    ad = new ze("TLS_ECDH_ECDSA_WITH_NULL_SHA", 55, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153, 4492, 7, 14);
    ae = new ze("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 56, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154, 4492, 7, 14);
    af = new ze("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 57, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155, 4492, 7, 14);
    ag = new ze("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 58, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156, 4492, 7, 14);
    ah = new ze("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 59, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157, 4492, 7, 14);
    ai = new ze("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 60, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158, 4492, 7, 14);
    aj = new ze("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 61, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159, 4492, 7, 14);
    ak = new ze("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 62, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160, 4492, 7, 14);
    al = new ze("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 63, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161, 4492, 7, 14);
    am = new ze("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 64, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162, 4492, 7, 14);
    an = new ze("TLS_ECDH_RSA_WITH_NULL_SHA", 65, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163, 4492, 7, 14);
    ao = new ze("TLS_ECDH_RSA_WITH_RC4_128_SHA", 66, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164, 4492, 7, 14);
    ap = new ze("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 67, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165, 4492, 7, 14);
    aq = new ze("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 68, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166, 4492, 7, 14);
    ar = new ze("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 69, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167, 4492, 7, 14);
    as = new ze("TLS_ECDHE_RSA_WITH_NULL_SHA", 70, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168, 4492, 7, 14);
    at = new ze("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 71, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169, 4492, 7, 14);
    au = new ze("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 72, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170, 4492, 7, 14);
    av = new ze("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 73, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171, 4492, 7, 14);
    aw = new ze("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 74, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172, 4492, 7, 14);
    ax = new ze("TLS_ECDH_anon_WITH_NULL_SHA", 75, "TLS_ECDH_anon_WITH_NULL_SHA", 49173, 4492, 7, 14);
    ay = new ze("TLS_ECDH_anon_WITH_RC4_128_SHA", 76, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174, 4492, 7, 14);
    az = new ze("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 77, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175, 4492, 7, 14);
    aA = new ze("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 78, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176, 4492, 7, 14);
    aB = new ze("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 79, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177, 4492, 7, 14);
    aC = new ze("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 80, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187, 5289, 7, 21);
    aD = new ze("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 81, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188, 5289, 7, 21);
    aE = new ze("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 82, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189, 5289, 7, 21);
    aF = new ze("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 83, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190, 5289, 7, 21);
    aG = new ze("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 84, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191, 5289, 7, 21);
    aH = new ze("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 85, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192, 5289, 7, 21);
    aI = new ze("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 86, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193, 5289, 7, 21);
    aJ = new ze("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 87, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194, 5289, 7, 21);
    aK = new ze("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 88, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195, 5289, 8, 21);
    aL = new ze("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 89, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196, 5289, 8, 21);
    aM = new ze("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 90, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197, 5289, 8, 21);
    aN = new ze("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 91, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198, 5289, 8, 21);
    aO = new ze("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 92, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199, 5289, 8, 21);
    aP = new ze("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 93, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200, 5289, 8, 21);
    aQ = new ze("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 94, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201, 5289, 8, 21);
    aR = new ze("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 95, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202, 5289, 8, 21);
    ze[] arrayOfze = new ze[96];
    arrayOfze[0] = a;
    arrayOfze[1] = b;
    arrayOfze[2] = c;
    arrayOfze[3] = d;
    arrayOfze[4] = e;
    arrayOfze[5] = f;
    arrayOfze[6] = g;
    arrayOfze[7] = h;
    arrayOfze[8] = i;
    arrayOfze[9] = j;
    arrayOfze[10] = k;
    arrayOfze[11] = l;
    arrayOfze[12] = m;
    arrayOfze[13] = n;
    arrayOfze[14] = o;
    arrayOfze[15] = p;
    arrayOfze[16] = q;
    arrayOfze[17] = r;
    arrayOfze[18] = s;
    arrayOfze[19] = t;
    arrayOfze[20] = u;
    arrayOfze[21] = v;
    arrayOfze[22] = w;
    arrayOfze[23] = x;
    arrayOfze[24] = y;
    arrayOfze[25] = z;
    arrayOfze[26] = A;
    arrayOfze[27] = B;
    arrayOfze[28] = C;
    arrayOfze[29] = D;
    arrayOfze[30] = E;
    arrayOfze[31] = F;
    arrayOfze[32] = G;
    arrayOfze[33] = H;
    arrayOfze[34] = I;
    arrayOfze[35] = J;
    arrayOfze[36] = K;
    arrayOfze[37] = L;
    arrayOfze[38] = M;
    arrayOfze[39] = N;
    arrayOfze[40] = O;
    arrayOfze[41] = P;
    arrayOfze[42] = Q;
    arrayOfze[43] = R;
    arrayOfze[44] = S;
    arrayOfze[45] = T;
    arrayOfze[46] = U;
    arrayOfze[47] = V;
    arrayOfze[48] = W;
    arrayOfze[49] = X;
    arrayOfze[50] = Y;
    arrayOfze[51] = Z;
    arrayOfze[52] = aa;
    arrayOfze[53] = ab;
    arrayOfze[54] = ac;
    arrayOfze[55] = ad;
    arrayOfze[56] = ae;
    arrayOfze[57] = af;
    arrayOfze[58] = ag;
    arrayOfze[59] = ah;
    arrayOfze[60] = ai;
    arrayOfze[61] = aj;
    arrayOfze[62] = ak;
    arrayOfze[63] = al;
    arrayOfze[64] = am;
    arrayOfze[65] = an;
    arrayOfze[66] = ao;
    arrayOfze[67] = ap;
    arrayOfze[68] = aq;
    arrayOfze[69] = ar;
    arrayOfze[70] = as;
    arrayOfze[71] = at;
    arrayOfze[72] = au;
    arrayOfze[73] = av;
    arrayOfze[74] = aw;
    arrayOfze[75] = ax;
    arrayOfze[76] = ay;
    arrayOfze[77] = az;
    arrayOfze[78] = aA;
    arrayOfze[79] = aB;
    arrayOfze[80] = aC;
    arrayOfze[81] = aD;
    arrayOfze[82] = aE;
    arrayOfze[83] = aF;
    arrayOfze[84] = aG;
    arrayOfze[85] = aH;
    arrayOfze[86] = aI;
    arrayOfze[87] = aJ;
    arrayOfze[88] = aK;
    arrayOfze[89] = aL;
    arrayOfze[90] = aM;
    arrayOfze[91] = aN;
    arrayOfze[92] = aO;
    arrayOfze[93] = aP;
    arrayOfze[94] = aQ;
    arrayOfze[95] = aR;
    aT = arrayOfze;
  }
  
  private ze(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aS = paramString;
  }
  
  public static ze a(String paramString)
  {
    return (ze)Enum.valueOf(ze.class, paramString);
  }
  
  static ze b(String paramString)
  {
    if (paramString.startsWith("SSL_")) {}
    for (ze localze = a("TLS_" + paramString.substring(4));; localze = a(paramString)) {
      return localze;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ze
 * JD-Core Version:    0.7.0.1
 */