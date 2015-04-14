import java.util.Collections;
import java.util.List;

public final class dQ
  extends sp<dQ>
  implements dX
{
  public static sI<dQ> a = new dR();
  private static final dQ c;
  private static volatile sH t = null;
  private final rZ d;
  private int e;
  private dV f;
  private Object g;
  private List<dQ> h;
  private List<dQ> i;
  private List<dQ> j;
  private Object k;
  private Object l;
  private long m;
  private boolean n;
  private List<dQ> o;
  private List<dT> p;
  private boolean q;
  private byte r = -1;
  private int s = -1;
  
  static
  {
    c = new dQ(true);
    c.J();
  }
  
  /* Error */
  private dQ(sc paramsc, sg paramsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 64	sp:<init>	()V
    //   4: aload_0
    //   5: bipush 255
    //   7: putfield 66	dQ:r	B
    //   10: aload_0
    //   11: bipush 255
    //   13: putfield 68	dQ:s	I
    //   16: aload_0
    //   17: invokespecial 58	dQ:J	()V
    //   20: iconst_0
    //   21: istore_3
    //   22: invokestatic 73	rZ:i	()Lsb;
    //   25: astore 4
    //   27: aload 4
    //   29: invokestatic 78	se:a	(Ljava/io/OutputStream;)Lse;
    //   32: astore 5
    //   34: iconst_0
    //   35: istore 6
    //   37: iload 6
    //   39: ifne +1030 -> 1069
    //   42: aload_1
    //   43: invokevirtual 83	sc:a	()I
    //   46: istore 14
    //   48: iload 14
    //   50: lookupswitch	default:+122->172, 0:+1258->1308, 8:+144->194, 18:+212->262, 26:+244->294, 34:+300->350, 42:+359->409, 50:+418->468, 58:+450->500, 64:+483->533, 72:+512->562, 80:+541->591, 82:+639->689, 90:+928->978, 96:+990->1040
    //   173: aload_1
    //   174: aload 5
    //   176: aload_2
    //   177: iload 14
    //   179: invokevirtual 86	dQ:a	(Lsc;Lse;Lsg;I)Z
    //   182: ifne +877 -> 1059
    //   185: iconst_1
    //   186: istore 15
    //   188: iload_3
    //   189: istore 16
    //   191: goto +1107 -> 1298
    //   194: aload_1
    //   195: invokevirtual 88	sc:n	()I
    //   198: istore 41
    //   200: iload 41
    //   202: invokestatic 93	dV:a	(I)LdV;
    //   205: astore 42
    //   207: aload 42
    //   209: ifnonnull +27 -> 236
    //   212: aload 5
    //   214: iload 14
    //   216: invokevirtual 96	se:d	(I)V
    //   219: aload 5
    //   221: iload 41
    //   223: invokevirtual 96	se:d	(I)V
    //   226: iload 6
    //   228: istore 15
    //   230: iload_3
    //   231: istore 16
    //   233: goto +1065 -> 1298
    //   236: aload_0
    //   237: iconst_1
    //   238: aload_0
    //   239: getfield 98	dQ:e	I
    //   242: ior
    //   243: putfield 98	dQ:e	I
    //   246: aload_0
    //   247: aload 42
    //   249: putfield 100	dQ:f	LdV;
    //   252: iload 6
    //   254: istore 15
    //   256: iload_3
    //   257: istore 16
    //   259: goto +1039 -> 1298
    //   262: aload_1
    //   263: invokevirtual 103	sc:l	()LrZ;
    //   266: astore 40
    //   268: aload_0
    //   269: iconst_2
    //   270: aload_0
    //   271: getfield 98	dQ:e	I
    //   274: ior
    //   275: putfield 98	dQ:e	I
    //   278: aload_0
    //   279: aload 40
    //   281: putfield 105	dQ:g	Ljava/lang/Object;
    //   284: iload 6
    //   286: istore 15
    //   288: iload_3
    //   289: istore 16
    //   291: goto +1007 -> 1298
    //   294: iload_3
    //   295: iconst_4
    //   296: iand
    //   297: iconst_4
    //   298: if_icmpeq +994 -> 1292
    //   301: aload_0
    //   302: new 107	java/util/ArrayList
    //   305: dup
    //   306: invokespecial 108	java/util/ArrayList:<init>	()V
    //   309: putfield 110	dQ:h	Ljava/util/List;
    //   312: iload_3
    //   313: iconst_4
    //   314: ior
    //   315: istore 17
    //   317: aload_0
    //   318: getfield 110	dQ:h	Ljava/util/List;
    //   321: aload_1
    //   322: getstatic 49	dQ:a	LsI;
    //   325: aload_2
    //   326: invokevirtual 113	sc:a	(LsI;Lsg;)LsE;
    //   329: invokeinterface 119 2 0
    //   334: pop
    //   335: iload 6
    //   337: istore 39
    //   339: iload 17
    //   341: istore 16
    //   343: iload 39
    //   345: istore 15
    //   347: goto +951 -> 1298
    //   350: iload_3
    //   351: bipush 8
    //   353: iand
    //   354: bipush 8
    //   356: if_icmpeq +930 -> 1286
    //   359: aload_0
    //   360: new 107	java/util/ArrayList
    //   363: dup
    //   364: invokespecial 108	java/util/ArrayList:<init>	()V
    //   367: putfield 121	dQ:i	Ljava/util/List;
    //   370: iload_3
    //   371: bipush 8
    //   373: ior
    //   374: istore 17
    //   376: aload_0
    //   377: getfield 121	dQ:i	Ljava/util/List;
    //   380: aload_1
    //   381: getstatic 49	dQ:a	LsI;
    //   384: aload_2
    //   385: invokevirtual 113	sc:a	(LsI;Lsg;)LsE;
    //   388: invokeinterface 119 2 0
    //   393: pop
    //   394: iload 6
    //   396: istore 37
    //   398: iload 17
    //   400: istore 16
    //   402: iload 37
    //   404: istore 15
    //   406: goto +892 -> 1298
    //   409: iload_3
    //   410: bipush 16
    //   412: iand
    //   413: bipush 16
    //   415: if_icmpeq +865 -> 1280
    //   418: aload_0
    //   419: new 107	java/util/ArrayList
    //   422: dup
    //   423: invokespecial 108	java/util/ArrayList:<init>	()V
    //   426: putfield 123	dQ:j	Ljava/util/List;
    //   429: iload_3
    //   430: bipush 16
    //   432: ior
    //   433: istore 17
    //   435: aload_0
    //   436: getfield 123	dQ:j	Ljava/util/List;
    //   439: aload_1
    //   440: getstatic 49	dQ:a	LsI;
    //   443: aload_2
    //   444: invokevirtual 113	sc:a	(LsI;Lsg;)LsE;
    //   447: invokeinterface 119 2 0
    //   452: pop
    //   453: iload 6
    //   455: istore 35
    //   457: iload 17
    //   459: istore 16
    //   461: iload 35
    //   463: istore 15
    //   465: goto +833 -> 1298
    //   468: aload_1
    //   469: invokevirtual 103	sc:l	()LrZ;
    //   472: astore 33
    //   474: aload_0
    //   475: iconst_4
    //   476: aload_0
    //   477: getfield 98	dQ:e	I
    //   480: ior
    //   481: putfield 98	dQ:e	I
    //   484: aload_0
    //   485: aload 33
    //   487: putfield 125	dQ:k	Ljava/lang/Object;
    //   490: iload 6
    //   492: istore 15
    //   494: iload_3
    //   495: istore 16
    //   497: goto +801 -> 1298
    //   500: aload_1
    //   501: invokevirtual 103	sc:l	()LrZ;
    //   504: astore 32
    //   506: aload_0
    //   507: bipush 8
    //   509: aload_0
    //   510: getfield 98	dQ:e	I
    //   513: ior
    //   514: putfield 98	dQ:e	I
    //   517: aload_0
    //   518: aload 32
    //   520: putfield 127	dQ:l	Ljava/lang/Object;
    //   523: iload 6
    //   525: istore 15
    //   527: iload_3
    //   528: istore 16
    //   530: goto +768 -> 1298
    //   533: aload_0
    //   534: bipush 16
    //   536: aload_0
    //   537: getfield 98	dQ:e	I
    //   540: ior
    //   541: putfield 98	dQ:e	I
    //   544: aload_0
    //   545: aload_1
    //   546: invokevirtual 130	sc:e	()J
    //   549: putfield 132	dQ:m	J
    //   552: iload 6
    //   554: istore 15
    //   556: iload_3
    //   557: istore 16
    //   559: goto +739 -> 1298
    //   562: aload_0
    //   563: bipush 64
    //   565: aload_0
    //   566: getfield 98	dQ:e	I
    //   569: ior
    //   570: putfield 98	dQ:e	I
    //   573: aload_0
    //   574: aload_1
    //   575: invokevirtual 135	sc:i	()Z
    //   578: putfield 137	dQ:q	Z
    //   581: iload 6
    //   583: istore 15
    //   585: iload_3
    //   586: istore 16
    //   588: goto +710 -> 1298
    //   591: aload_1
    //   592: invokevirtual 88	sc:n	()I
    //   595: istore 28
    //   597: iload 28
    //   599: invokestatic 142	dT:a	(I)LdT;
    //   602: astore 29
    //   604: aload 29
    //   606: ifnonnull +27 -> 633
    //   609: aload 5
    //   611: iload 14
    //   613: invokevirtual 96	se:d	(I)V
    //   616: aload 5
    //   618: iload 28
    //   620: invokevirtual 96	se:d	(I)V
    //   623: iload 6
    //   625: istore 15
    //   627: iload_3
    //   628: istore 16
    //   630: goto +668 -> 1298
    //   633: iload_3
    //   634: sipush 1024
    //   637: iand
    //   638: sipush 1024
    //   641: if_icmpeq +633 -> 1274
    //   644: aload_0
    //   645: new 107	java/util/ArrayList
    //   648: dup
    //   649: invokespecial 108	java/util/ArrayList:<init>	()V
    //   652: putfield 144	dQ:p	Ljava/util/List;
    //   655: iload_3
    //   656: sipush 1024
    //   659: ior
    //   660: istore 17
    //   662: aload_0
    //   663: getfield 144	dQ:p	Ljava/util/List;
    //   666: aload 29
    //   668: invokeinterface 119 2 0
    //   673: pop
    //   674: iload 6
    //   676: istore 31
    //   678: iload 17
    //   680: istore 16
    //   682: iload 31
    //   684: istore 15
    //   686: goto +612 -> 1298
    //   689: aload_1
    //   690: aload_1
    //   691: invokevirtual 146	sc:s	()I
    //   694: invokevirtual 149	sc:c	(I)I
    //   697: istore 23
    //   699: iload_3
    //   700: istore 17
    //   702: aload_1
    //   703: invokevirtual 152	sc:w	()I
    //   706: ifle +251 -> 957
    //   709: aload_1
    //   710: invokevirtual 88	sc:n	()I
    //   713: istore 25
    //   715: iload 25
    //   717: invokestatic 142	dT:a	(I)LdT;
    //   720: astore 26
    //   722: aload 26
    //   724: ifnonnull +161 -> 885
    //   727: aload 5
    //   729: iload 14
    //   731: invokevirtual 96	se:d	(I)V
    //   734: aload 5
    //   736: iload 25
    //   738: invokevirtual 96	se:d	(I)V
    //   741: goto -39 -> 702
    //   744: astore 22
    //   746: iload 17
    //   748: istore_3
    //   749: aload 22
    //   751: astore 9
    //   753: aload 9
    //   755: aload_0
    //   756: invokevirtual 155	sx:a	(LsE;)Lsx;
    //   759: athrow
    //   760: astore 10
    //   762: iload_3
    //   763: iconst_4
    //   764: iand
    //   765: iconst_4
    //   766: if_icmpne +14 -> 780
    //   769: aload_0
    //   770: aload_0
    //   771: getfield 110	dQ:h	Ljava/util/List;
    //   774: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   777: putfield 110	dQ:h	Ljava/util/List;
    //   780: iload_3
    //   781: bipush 8
    //   783: iand
    //   784: bipush 8
    //   786: if_icmpne +14 -> 800
    //   789: aload_0
    //   790: aload_0
    //   791: getfield 121	dQ:i	Ljava/util/List;
    //   794: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   797: putfield 121	dQ:i	Ljava/util/List;
    //   800: iload_3
    //   801: bipush 16
    //   803: iand
    //   804: bipush 16
    //   806: if_icmpne +14 -> 820
    //   809: aload_0
    //   810: aload_0
    //   811: getfield 123	dQ:j	Ljava/util/List;
    //   814: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   817: putfield 123	dQ:j	Ljava/util/List;
    //   820: iload_3
    //   821: sipush 1024
    //   824: iand
    //   825: sipush 1024
    //   828: if_icmpne +14 -> 842
    //   831: aload_0
    //   832: aload_0
    //   833: getfield 144	dQ:p	Ljava/util/List;
    //   836: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   839: putfield 144	dQ:p	Ljava/util/List;
    //   842: iload_3
    //   843: sipush 512
    //   846: iand
    //   847: sipush 512
    //   850: if_icmpne +14 -> 864
    //   853: aload_0
    //   854: aload_0
    //   855: getfield 163	dQ:o	Ljava/util/List;
    //   858: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   861: putfield 163	dQ:o	Ljava/util/List;
    //   864: aload 5
    //   866: invokevirtual 165	se:a	()V
    //   869: aload_0
    //   870: aload 4
    //   872: invokevirtual 169	sb:a	()LrZ;
    //   875: putfield 171	dQ:d	LrZ;
    //   878: aload_0
    //   879: invokevirtual 174	dQ:R	()V
    //   882: aload 10
    //   884: athrow
    //   885: iload 17
    //   887: sipush 1024
    //   890: iand
    //   891: sipush 1024
    //   894: if_icmpeq +22 -> 916
    //   897: aload_0
    //   898: new 107	java/util/ArrayList
    //   901: dup
    //   902: invokespecial 108	java/util/ArrayList:<init>	()V
    //   905: putfield 144	dQ:p	Ljava/util/List;
    //   908: iload 17
    //   910: sipush 1024
    //   913: ior
    //   914: istore 17
    //   916: aload_0
    //   917: getfield 144	dQ:p	Ljava/util/List;
    //   920: aload 26
    //   922: invokeinterface 119 2 0
    //   927: pop
    //   928: goto -226 -> 702
    //   931: astore 21
    //   933: iload 17
    //   935: istore_3
    //   936: aload 21
    //   938: astore 13
    //   940: new 61	sx
    //   943: dup
    //   944: aload 13
    //   946: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   949: invokespecial 181	sx:<init>	(Ljava/lang/String;)V
    //   952: aload_0
    //   953: invokevirtual 155	sx:a	(LsE;)Lsx;
    //   956: athrow
    //   957: aload_1
    //   958: iload 23
    //   960: invokevirtual 182	sc:d	(I)V
    //   963: iload 6
    //   965: istore 24
    //   967: iload 17
    //   969: istore 16
    //   971: iload 24
    //   973: istore 15
    //   975: goto +323 -> 1298
    //   978: iload_3
    //   979: sipush 512
    //   982: iand
    //   983: sipush 512
    //   986: if_icmpeq +282 -> 1268
    //   989: aload_0
    //   990: new 107	java/util/ArrayList
    //   993: dup
    //   994: invokespecial 108	java/util/ArrayList:<init>	()V
    //   997: putfield 163	dQ:o	Ljava/util/List;
    //   1000: iload_3
    //   1001: sipush 512
    //   1004: ior
    //   1005: istore 17
    //   1007: aload_0
    //   1008: getfield 163	dQ:o	Ljava/util/List;
    //   1011: aload_1
    //   1012: getstatic 49	dQ:a	LsI;
    //   1015: aload_2
    //   1016: invokevirtual 113	sc:a	(LsI;Lsg;)LsE;
    //   1019: invokeinterface 119 2 0
    //   1024: pop
    //   1025: iload 6
    //   1027: istore 20
    //   1029: iload 17
    //   1031: istore 16
    //   1033: iload 20
    //   1035: istore 15
    //   1037: goto +261 -> 1298
    //   1040: aload_0
    //   1041: bipush 32
    //   1043: aload_0
    //   1044: getfield 98	dQ:e	I
    //   1047: ior
    //   1048: putfield 98	dQ:e	I
    //   1051: aload_0
    //   1052: aload_1
    //   1053: invokevirtual 135	sc:i	()Z
    //   1056: putfield 184	dQ:n	Z
    //   1059: iload 6
    //   1061: istore 15
    //   1063: iload_3
    //   1064: istore 16
    //   1066: goto +232 -> 1298
    //   1069: iload_3
    //   1070: iconst_4
    //   1071: iand
    //   1072: iconst_4
    //   1073: if_icmpne +14 -> 1087
    //   1076: aload_0
    //   1077: aload_0
    //   1078: getfield 110	dQ:h	Ljava/util/List;
    //   1081: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1084: putfield 110	dQ:h	Ljava/util/List;
    //   1087: iload_3
    //   1088: bipush 8
    //   1090: iand
    //   1091: bipush 8
    //   1093: if_icmpne +14 -> 1107
    //   1096: aload_0
    //   1097: aload_0
    //   1098: getfield 121	dQ:i	Ljava/util/List;
    //   1101: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1104: putfield 121	dQ:i	Ljava/util/List;
    //   1107: iload_3
    //   1108: bipush 16
    //   1110: iand
    //   1111: bipush 16
    //   1113: if_icmpne +14 -> 1127
    //   1116: aload_0
    //   1117: aload_0
    //   1118: getfield 123	dQ:j	Ljava/util/List;
    //   1121: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1124: putfield 123	dQ:j	Ljava/util/List;
    //   1127: iload_3
    //   1128: sipush 1024
    //   1131: iand
    //   1132: sipush 1024
    //   1135: if_icmpne +14 -> 1149
    //   1138: aload_0
    //   1139: aload_0
    //   1140: getfield 144	dQ:p	Ljava/util/List;
    //   1143: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1146: putfield 144	dQ:p	Ljava/util/List;
    //   1149: iload_3
    //   1150: sipush 512
    //   1153: iand
    //   1154: sipush 512
    //   1157: if_icmpne +14 -> 1171
    //   1160: aload_0
    //   1161: aload_0
    //   1162: getfield 163	dQ:o	Ljava/util/List;
    //   1165: invokestatic 161	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1168: putfield 163	dQ:o	Ljava/util/List;
    //   1171: aload 5
    //   1173: invokevirtual 165	se:a	()V
    //   1176: aload_0
    //   1177: aload 4
    //   1179: invokevirtual 169	sb:a	()LrZ;
    //   1182: putfield 171	dQ:d	LrZ;
    //   1185: aload_0
    //   1186: invokevirtual 174	dQ:R	()V
    //   1189: return
    //   1190: astore 8
    //   1192: aload_0
    //   1193: aload 4
    //   1195: invokevirtual 169	sb:a	()LrZ;
    //   1198: putfield 171	dQ:d	LrZ;
    //   1201: goto -16 -> 1185
    //   1204: astore 7
    //   1206: aload_0
    //   1207: aload 4
    //   1209: invokevirtual 169	sb:a	()LrZ;
    //   1212: putfield 171	dQ:d	LrZ;
    //   1215: aload 7
    //   1217: athrow
    //   1218: astore 12
    //   1220: aload_0
    //   1221: aload 4
    //   1223: invokevirtual 169	sb:a	()LrZ;
    //   1226: putfield 171	dQ:d	LrZ;
    //   1229: goto -351 -> 878
    //   1232: astore 11
    //   1234: aload_0
    //   1235: aload 4
    //   1237: invokevirtual 169	sb:a	()LrZ;
    //   1240: putfield 171	dQ:d	LrZ;
    //   1243: aload 11
    //   1245: athrow
    //   1246: astore 18
    //   1248: iload 17
    //   1250: istore_3
    //   1251: aload 18
    //   1253: astore 10
    //   1255: goto -493 -> 762
    //   1258: astore 13
    //   1260: goto -320 -> 940
    //   1263: astore 9
    //   1265: goto -512 -> 753
    //   1268: iload_3
    //   1269: istore 17
    //   1271: goto -264 -> 1007
    //   1274: iload_3
    //   1275: istore 17
    //   1277: goto -615 -> 662
    //   1280: iload_3
    //   1281: istore 17
    //   1283: goto -848 -> 435
    //   1286: iload_3
    //   1287: istore 17
    //   1289: goto -913 -> 376
    //   1292: iload_3
    //   1293: istore 17
    //   1295: goto -978 -> 317
    //   1298: iload 16
    //   1300: istore_3
    //   1301: iload 15
    //   1303: istore 6
    //   1305: goto -1268 -> 37
    //   1308: iconst_1
    //   1309: istore 15
    //   1311: iload_3
    //   1312: istore 16
    //   1314: goto -16 -> 1298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1317	0	this	dQ
    //   0	1317	1	paramsc	sc
    //   0	1317	2	paramsg	sg
    //   21	1291	3	i1	int
    //   25	1211	4	localsb	sb
    //   32	1140	5	localse	se
    //   35	1269	6	i2	int
    //   1204	12	7	localObject1	Object
    //   1190	1	8	localIOException1	java.io.IOException
    //   751	3	9	localsx1	sx
    //   1263	1	9	localsx2	sx
    //   760	123	10	localObject2	Object
    //   1253	1	10	localObject3	Object
    //   1232	12	11	localObject4	Object
    //   1218	1	12	localIOException2	java.io.IOException
    //   938	7	13	localIOException3	java.io.IOException
    //   1258	1	13	localIOException4	java.io.IOException
    //   46	684	14	i3	int
    //   186	1124	15	i4	int
    //   189	1124	16	i5	int
    //   315	979	17	i6	int
    //   1246	6	18	localObject5	Object
    //   1027	7	20	i7	int
    //   931	6	21	localIOException5	java.io.IOException
    //   744	6	22	localsx3	sx
    //   697	262	23	i8	int
    //   965	7	24	i9	int
    //   713	24	25	i10	int
    //   720	201	26	localdT1	dT
    //   595	24	28	i11	int
    //   602	65	29	localdT2	dT
    //   676	7	31	i12	int
    //   504	15	32	localrZ1	rZ
    //   472	14	33	localrZ2	rZ
    //   455	7	35	i13	int
    //   396	7	37	i14	int
    //   337	7	39	i15	int
    //   266	14	40	localrZ3	rZ
    //   198	24	41	i16	int
    //   205	43	42	localdV	dV
    // Exception table:
    //   from	to	target	type
    //   317	335	744	sx
    //   376	394	744	sx
    //   435	453	744	sx
    //   662	674	744	sx
    //   702	741	744	sx
    //   897	928	744	sx
    //   957	963	744	sx
    //   1007	1025	744	sx
    //   42	312	760	finally
    //   359	370	760	finally
    //   418	429	760	finally
    //   468	655	760	finally
    //   689	699	760	finally
    //   753	760	760	finally
    //   940	957	760	finally
    //   989	1000	760	finally
    //   1040	1059	760	finally
    //   317	335	931	java/io/IOException
    //   376	394	931	java/io/IOException
    //   435	453	931	java/io/IOException
    //   662	674	931	java/io/IOException
    //   702	741	931	java/io/IOException
    //   897	928	931	java/io/IOException
    //   957	963	931	java/io/IOException
    //   1007	1025	931	java/io/IOException
    //   1171	1176	1190	java/io/IOException
    //   1171	1176	1204	finally
    //   864	869	1218	java/io/IOException
    //   864	869	1232	finally
    //   317	335	1246	finally
    //   376	394	1246	finally
    //   435	453	1246	finally
    //   662	674	1246	finally
    //   702	741	1246	finally
    //   897	928	1246	finally
    //   957	963	1246	finally
    //   1007	1025	1246	finally
    //   42	312	1258	java/io/IOException
    //   359	370	1258	java/io/IOException
    //   418	429	1258	java/io/IOException
    //   468	655	1258	java/io/IOException
    //   689	699	1258	java/io/IOException
    //   989	1000	1258	java/io/IOException
    //   1040	1059	1258	java/io/IOException
    //   42	312	1263	sx
    //   359	370	1263	sx
    //   418	429	1263	sx
    //   468	655	1263	sx
    //   689	699	1263	sx
    //   989	1000	1263	sx
    //   1040	1059	1263	sx
  }
  
  private dQ(so<dQ, ?> paramso)
  {
    super(paramso);
    this.d = paramso.r();
  }
  
  private dQ(boolean paramBoolean)
  {
    this.d = rZ.a;
  }
  
  public static dS F()
  {
    return dS.q();
  }
  
  private void J()
  {
    this.f = dV.a;
    this.g = "";
    this.h = Collections.emptyList();
    this.i = Collections.emptyList();
    this.j = Collections.emptyList();
    this.k = "";
    this.l = "";
    this.m = 0L;
    this.n = false;
    this.o = Collections.emptyList();
    this.p = Collections.emptyList();
    this.q = false;
  }
  
  public static dQ a()
  {
    return c;
  }
  
  public static dS a(dQ paramdQ)
  {
    return F().a(paramdQ);
  }
  
  public int A()
  {
    return this.o.size();
  }
  
  public List<dT> B()
  {
    return this.p;
  }
  
  public int C()
  {
    return this.p.size();
  }
  
  public boolean D()
  {
    if ((0x40 & this.e) == 64) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean E()
  {
    return this.q;
  }
  
  public dS G()
  {
    return F();
  }
  
  public dS H()
  {
    return a(this);
  }
  
  public dQ a(int paramInt)
  {
    return (dQ)this.h.get(paramInt);
  }
  
  public dQ b()
  {
    return c;
  }
  
  public dQ b(int paramInt)
  {
    return (dQ)this.i.get(paramInt);
  }
  
  public dQ c(int paramInt)
  {
    return (dQ)this.j.get(paramInt);
  }
  
  public sI<dQ> c()
  {
    return a;
  }
  
  public dQ d(int paramInt)
  {
    return (dQ)this.o.get(paramInt);
  }
  
  public boolean d()
  {
    int i1 = 1;
    if ((0x1 & this.e) == i1) {}
    for (;;)
    {
      return i1;
      int i2 = 0;
    }
  }
  
  public dV e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool1;
      if (!(paramObject instanceof dQ))
      {
        bool1 = super.equals(paramObject);
      }
      else
      {
        dQ localdQ = (dQ)paramObject;
        boolean bool2;
        label44:
        label70:
        boolean bool3;
        label89:
        label118:
        boolean bool4;
        label142:
        boolean bool5;
        label166:
        boolean bool6;
        label190:
        boolean bool7;
        label209:
        label238:
        boolean bool8;
        label257:
        label286:
        boolean bool9;
        label305:
        label332:
        boolean bool10;
        label351:
        label377:
        boolean bool11;
        label401:
        boolean bool12;
        if (d() == localdQ.d())
        {
          bool2 = bool1;
          if (d())
          {
            if ((!bool2) || (e() != localdQ.e())) {
              break label478;
            }
            bool2 = bool1;
          }
          if ((!bool2) || (f() != localdQ.f())) {
            break label484;
          }
          bool3 = bool1;
          if (f())
          {
            if ((!bool3) || (!g().equals(localdQ.g()))) {
              break label490;
            }
            bool3 = bool1;
          }
          if ((!bool3) || (!h().equals(localdQ.h()))) {
            break label496;
          }
          bool4 = bool1;
          if ((!bool4) || (!k().equals(localdQ.k()))) {
            break label502;
          }
          bool5 = bool1;
          if ((!bool5) || (!m().equals(localdQ.m()))) {
            break label508;
          }
          bool6 = bool1;
          if ((!bool6) || (r() != localdQ.r())) {
            break label514;
          }
          bool7 = bool1;
          if (r())
          {
            if ((!bool7) || (!s().equals(localdQ.s()))) {
              break label520;
            }
            bool7 = bool1;
          }
          if ((!bool7) || (t() != localdQ.t())) {
            break label526;
          }
          bool8 = bool1;
          if (t())
          {
            if ((!bool8) || (!u().equals(localdQ.u()))) {
              break label532;
            }
            bool8 = bool1;
          }
          if ((!bool8) || (v() != localdQ.v())) {
            break label538;
          }
          bool9 = bool1;
          if (v())
          {
            if ((!bool9) || (w() != localdQ.w())) {
              break label544;
            }
            bool9 = bool1;
          }
          if ((!bool9) || (x() != localdQ.x())) {
            break label550;
          }
          bool10 = bool1;
          if (x())
          {
            if ((!bool10) || (y() != localdQ.y())) {
              break label556;
            }
            bool10 = bool1;
          }
          if ((!bool10) || (!z().equals(localdQ.z()))) {
            break label562;
          }
          bool11 = bool1;
          if ((!bool11) || (!B().equals(localdQ.B()))) {
            break label568;
          }
          bool12 = bool1;
          label425:
          if ((!bool12) || (D() != localdQ.D())) {
            break label574;
          }
        }
        label514:
        label520:
        label526:
        label532:
        label538:
        label544:
        label550:
        label556:
        label562:
        label568:
        label574:
        for (boolean bool13 = bool1;; bool13 = false)
        {
          if (!D()) {
            break label580;
          }
          if ((bool13) && (E() == localdQ.E())) {
            break;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label44;
          label478:
          bool2 = false;
          break label70;
          label484:
          bool3 = false;
          break label89;
          label490:
          bool3 = false;
          break label118;
          label496:
          bool4 = false;
          break label142;
          label502:
          bool5 = false;
          break label166;
          label508:
          bool6 = false;
          break label190;
          bool7 = false;
          break label209;
          bool7 = false;
          break label238;
          bool8 = false;
          break label257;
          bool8 = false;
          break label286;
          bool9 = false;
          break label305;
          bool9 = false;
          break label332;
          bool10 = false;
          break label351;
          bool10 = false;
          break label377;
          bool11 = false;
          break label401;
          bool12 = false;
          break label425;
        }
        label580:
        bool1 = bool13;
      }
    }
  }
  
  public boolean f()
  {
    if ((0x2 & this.e) == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String g()
  {
    Object localObject1 = this.g;
    if ((localObject1 instanceof String)) {}
    String str;
    for (Object localObject2 = (String)localObject1;; localObject2 = str)
    {
      return localObject2;
      rZ localrZ = (rZ)localObject1;
      str = localrZ.f();
      if (localrZ.g()) {
        this.g = str;
      }
    }
  }
  
  public List<dQ> h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    int i2;
    if (this.b != 0) {
      i2 = this.b;
    }
    for (;;)
    {
      return i2;
      int i1 = 779 + dQ.class.hashCode();
      if (d()) {
        i1 = 53 * (1 + i1 * 37) + su.a(e());
      }
      if (f()) {
        i1 = 53 * (2 + i1 * 37) + g().hashCode();
      }
      if (i() > 0) {
        i1 = 53 * (3 + i1 * 37) + h().hashCode();
      }
      if (l() > 0) {
        i1 = 53 * (4 + i1 * 37) + k().hashCode();
      }
      if (q() > 0) {
        i1 = 53 * (5 + i1 * 37) + m().hashCode();
      }
      if (r()) {
        i1 = 53 * (6 + i1 * 37) + s().hashCode();
      }
      if (t()) {
        i1 = 53 * (7 + i1 * 37) + u().hashCode();
      }
      if (v()) {
        i1 = 53 * (8 + i1 * 37) + su.a(w());
      }
      if (x()) {
        i1 = 53 * (12 + i1 * 37) + su.a(y());
      }
      if (A() > 0) {
        i1 = 53 * (11 + i1 * 37) + z().hashCode();
      }
      if (C() > 0) {
        i1 = 53 * (10 + i1 * 37) + su.a(B());
      }
      if (D()) {
        i1 = 53 * (9 + i1 * 37) + su.a(E());
      }
      i2 = i1 * 29 + this.d.hashCode();
      this.b = i2;
    }
  }
  
  public int i()
  {
    return this.h.size();
  }
  
  public final boolean j()
  {
    int i1 = 1;
    boolean bool = false;
    int i2 = this.r;
    if (i2 != -1) {
      if (i2 == i1) {
        bool = i1;
      }
    }
    for (;;)
    {
      return bool;
      i1 = 0;
      break;
      if (!d())
      {
        this.r = 0;
      }
      else
      {
        for (int i3 = 0;; i3++)
        {
          if (i3 >= i()) {
            break label82;
          }
          if (!a(i3).j())
          {
            this.r = 0;
            break;
          }
        }
        label82:
        for (int i4 = 0;; i4++)
        {
          if (i4 >= l()) {
            break label120;
          }
          if (!b(i4).j())
          {
            this.r = 0;
            break;
          }
        }
        label120:
        for (int i5 = 0;; i5++)
        {
          if (i5 >= q()) {
            break label158;
          }
          if (!c(i5).j())
          {
            this.r = 0;
            break;
          }
        }
        label158:
        for (int i6 = 0;; i6++)
        {
          if (i6 >= A()) {
            break label196;
          }
          if (!d(i6).j())
          {
            this.r = 0;
            break;
          }
        }
        label196:
        if (!I())
        {
          this.r = 0;
        }
        else
        {
          this.r = i1;
          bool = i1;
        }
      }
    }
  }
  
  public List<dQ> k()
  {
    return this.i;
  }
  
  public int l()
  {
    return this.i.size();
  }
  
  public List<dQ> m()
  {
    return this.j;
  }
  
  public int q()
  {
    return this.j.size();
  }
  
  public boolean r()
  {
    if ((0x4 & this.e) == 4) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String s()
  {
    Object localObject1 = this.k;
    if ((localObject1 instanceof String)) {}
    String str;
    for (Object localObject2 = (String)localObject1;; localObject2 = str)
    {
      return localObject2;
      rZ localrZ = (rZ)localObject1;
      str = localrZ.f();
      if (localrZ.g()) {
        this.k = str;
      }
    }
  }
  
  public boolean t()
  {
    if ((0x8 & this.e) == 8) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String u()
  {
    Object localObject1 = this.l;
    if ((localObject1 instanceof String)) {}
    String str;
    for (Object localObject2 = (String)localObject1;; localObject2 = str)
    {
      return localObject2;
      rZ localrZ = (rZ)localObject1;
      str = localrZ.f();
      if (localrZ.g()) {
        this.l = str;
      }
    }
  }
  
  public boolean v()
  {
    if ((0x10 & this.e) == 16) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public long w()
  {
    return this.m;
  }
  
  public boolean x()
  {
    if ((0x20 & this.e) == 32) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean y()
  {
    return this.n;
  }
  
  public List<dQ> z()
  {
    return this.o;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dQ
 * JD-Core Version:    0.7.0.1
 */