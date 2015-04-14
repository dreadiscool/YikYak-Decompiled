import java.util.Collections;
import java.util.List;

public final class dG
  extends sl
  implements dJ
{
  public static sI<dG> a = new dH();
  private static final dG c;
  private static volatile sH x = null;
  private final rZ d;
  private int e;
  private sA f;
  private List<dQ> g;
  private List<dC> h;
  private List<dy> i;
  private List<dy> j;
  private List<dy> k;
  private List<dK> l;
  private Object m;
  private Object n;
  private Object o;
  private Object p;
  private ds q;
  private float r;
  private boolean s;
  private sA t;
  private int u;
  private byte v = -1;
  private int w = -1;
  
  static
  {
    c = new dG(true);
    c.S();
  }
  
  /* Error */
  private dG(sc paramsc, sg paramsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 71	sl:<init>	()V
    //   4: aload_0
    //   5: bipush 255
    //   7: putfield 73	dG:v	B
    //   10: aload_0
    //   11: bipush 255
    //   13: putfield 75	dG:w	I
    //   16: aload_0
    //   17: invokespecial 65	dG:S	()V
    //   20: iconst_0
    //   21: istore_3
    //   22: invokestatic 80	rZ:i	()Lsb;
    //   25: astore 4
    //   27: aload 4
    //   29: invokestatic 85	se:a	(Ljava/io/OutputStream;)Lse;
    //   32: astore 5
    //   34: iconst_0
    //   35: istore 6
    //   37: iload 6
    //   39: ifne +941 -> 980
    //   42: aload_1
    //   43: invokevirtual 90	sc:a	()I
    //   46: istore 14
    //   48: iload 14
    //   50: lookupswitch	default:+146->196, 0:+1484->1534, 10:+168->218, 18:+223->273, 26:+279->329, 34:+335->385, 42:+394->444, 50:+453->503, 58:+512->562, 74:+571->621, 82:+603->653, 98:+635->685, 106:+667->717, 114:+700->750, 125:+781->831, 130:+810->860, 136:+871->921, 144:+901->951
    //   197: aload_1
    //   198: aload 5
    //   200: aload_2
    //   201: iload 14
    //   203: invokevirtual 93	dG:a	(Lsc;Lse;Lsg;I)Z
    //   206: ifne +764 -> 970
    //   209: iconst_1
    //   210: istore 15
    //   212: iload_3
    //   213: istore 16
    //   215: goto +1309 -> 1524
    //   218: aload_1
    //   219: invokevirtual 96	sc:l	()LrZ;
    //   222: astore 41
    //   224: iload_3
    //   225: iconst_1
    //   226: iand
    //   227: iconst_1
    //   228: if_icmpeq +1290 -> 1518
    //   231: aload_0
    //   232: new 98	sz
    //   235: dup
    //   236: invokespecial 99	sz:<init>	()V
    //   239: putfield 101	dG:f	LsA;
    //   242: iload_3
    //   243: iconst_1
    //   244: ior
    //   245: istore 18
    //   247: aload_0
    //   248: getfield 101	dG:f	LsA;
    //   251: aload 41
    //   253: invokeinterface 106 2 0
    //   258: iload 6
    //   260: istore 42
    //   262: iload 18
    //   264: istore 16
    //   266: iload 42
    //   268: istore 15
    //   270: goto +1254 -> 1524
    //   273: iload_3
    //   274: iconst_2
    //   275: iand
    //   276: iconst_2
    //   277: if_icmpeq +1235 -> 1512
    //   280: aload_0
    //   281: new 108	java/util/ArrayList
    //   284: dup
    //   285: invokespecial 109	java/util/ArrayList:<init>	()V
    //   288: putfield 111	dG:g	Ljava/util/List;
    //   291: iload_3
    //   292: iconst_2
    //   293: ior
    //   294: istore 18
    //   296: aload_0
    //   297: getfield 111	dG:g	Ljava/util/List;
    //   300: aload_1
    //   301: getstatic 114	dQ:a	LsI;
    //   304: aload_2
    //   305: invokevirtual 117	sc:a	(LsI;Lsg;)LsE;
    //   308: invokeinterface 123 2 0
    //   313: pop
    //   314: iload 6
    //   316: istore 40
    //   318: iload 18
    //   320: istore 16
    //   322: iload 40
    //   324: istore 15
    //   326: goto +1198 -> 1524
    //   329: iload_3
    //   330: iconst_4
    //   331: iand
    //   332: iconst_4
    //   333: if_icmpeq +1173 -> 1506
    //   336: aload_0
    //   337: new 108	java/util/ArrayList
    //   340: dup
    //   341: invokespecial 109	java/util/ArrayList:<init>	()V
    //   344: putfield 125	dG:h	Ljava/util/List;
    //   347: iload_3
    //   348: iconst_4
    //   349: ior
    //   350: istore 18
    //   352: aload_0
    //   353: getfield 125	dG:h	Ljava/util/List;
    //   356: aload_1
    //   357: getstatic 128	dC:a	LsI;
    //   360: aload_2
    //   361: invokevirtual 117	sc:a	(LsI;Lsg;)LsE;
    //   364: invokeinterface 123 2 0
    //   369: pop
    //   370: iload 6
    //   372: istore 38
    //   374: iload 18
    //   376: istore 16
    //   378: iload 38
    //   380: istore 15
    //   382: goto +1142 -> 1524
    //   385: iload_3
    //   386: bipush 8
    //   388: iand
    //   389: bipush 8
    //   391: if_icmpeq +1109 -> 1500
    //   394: aload_0
    //   395: new 108	java/util/ArrayList
    //   398: dup
    //   399: invokespecial 109	java/util/ArrayList:<init>	()V
    //   402: putfield 130	dG:i	Ljava/util/List;
    //   405: iload_3
    //   406: bipush 8
    //   408: ior
    //   409: istore 18
    //   411: aload_0
    //   412: getfield 130	dG:i	Ljava/util/List;
    //   415: aload_1
    //   416: getstatic 133	dy:a	LsI;
    //   419: aload_2
    //   420: invokevirtual 117	sc:a	(LsI;Lsg;)LsE;
    //   423: invokeinterface 123 2 0
    //   428: pop
    //   429: iload 6
    //   431: istore 36
    //   433: iload 18
    //   435: istore 16
    //   437: iload 36
    //   439: istore 15
    //   441: goto +1083 -> 1524
    //   444: iload_3
    //   445: bipush 16
    //   447: iand
    //   448: bipush 16
    //   450: if_icmpeq +1044 -> 1494
    //   453: aload_0
    //   454: new 108	java/util/ArrayList
    //   457: dup
    //   458: invokespecial 109	java/util/ArrayList:<init>	()V
    //   461: putfield 135	dG:j	Ljava/util/List;
    //   464: iload_3
    //   465: bipush 16
    //   467: ior
    //   468: istore 18
    //   470: aload_0
    //   471: getfield 135	dG:j	Ljava/util/List;
    //   474: aload_1
    //   475: getstatic 133	dy:a	LsI;
    //   478: aload_2
    //   479: invokevirtual 117	sc:a	(LsI;Lsg;)LsE;
    //   482: invokeinterface 123 2 0
    //   487: pop
    //   488: iload 6
    //   490: istore 34
    //   492: iload 18
    //   494: istore 16
    //   496: iload 34
    //   498: istore 15
    //   500: goto +1024 -> 1524
    //   503: iload_3
    //   504: bipush 32
    //   506: iand
    //   507: bipush 32
    //   509: if_icmpeq +979 -> 1488
    //   512: aload_0
    //   513: new 108	java/util/ArrayList
    //   516: dup
    //   517: invokespecial 109	java/util/ArrayList:<init>	()V
    //   520: putfield 137	dG:k	Ljava/util/List;
    //   523: iload_3
    //   524: bipush 32
    //   526: ior
    //   527: istore 18
    //   529: aload_0
    //   530: getfield 137	dG:k	Ljava/util/List;
    //   533: aload_1
    //   534: getstatic 133	dy:a	LsI;
    //   537: aload_2
    //   538: invokevirtual 117	sc:a	(LsI;Lsg;)LsE;
    //   541: invokeinterface 123 2 0
    //   546: pop
    //   547: iload 6
    //   549: istore 32
    //   551: iload 18
    //   553: istore 16
    //   555: iload 32
    //   557: istore 15
    //   559: goto +965 -> 1524
    //   562: iload_3
    //   563: bipush 64
    //   565: iand
    //   566: bipush 64
    //   568: if_icmpeq +914 -> 1482
    //   571: aload_0
    //   572: new 108	java/util/ArrayList
    //   575: dup
    //   576: invokespecial 109	java/util/ArrayList:<init>	()V
    //   579: putfield 139	dG:l	Ljava/util/List;
    //   582: iload_3
    //   583: bipush 64
    //   585: ior
    //   586: istore 18
    //   588: aload_0
    //   589: getfield 139	dG:l	Ljava/util/List;
    //   592: aload_1
    //   593: getstatic 142	dK:a	LsI;
    //   596: aload_2
    //   597: invokevirtual 117	sc:a	(LsI;Lsg;)LsE;
    //   600: invokeinterface 123 2 0
    //   605: pop
    //   606: iload 6
    //   608: istore 30
    //   610: iload 18
    //   612: istore 16
    //   614: iload 30
    //   616: istore 15
    //   618: goto +906 -> 1524
    //   621: aload_1
    //   622: invokevirtual 96	sc:l	()LrZ;
    //   625: astore 28
    //   627: aload_0
    //   628: iconst_1
    //   629: aload_0
    //   630: getfield 144	dG:e	I
    //   633: ior
    //   634: putfield 144	dG:e	I
    //   637: aload_0
    //   638: aload 28
    //   640: putfield 146	dG:m	Ljava/lang/Object;
    //   643: iload 6
    //   645: istore 15
    //   647: iload_3
    //   648: istore 16
    //   650: goto +874 -> 1524
    //   653: aload_1
    //   654: invokevirtual 96	sc:l	()LrZ;
    //   657: astore 27
    //   659: aload_0
    //   660: iconst_2
    //   661: aload_0
    //   662: getfield 144	dG:e	I
    //   665: ior
    //   666: putfield 144	dG:e	I
    //   669: aload_0
    //   670: aload 27
    //   672: putfield 148	dG:n	Ljava/lang/Object;
    //   675: iload 6
    //   677: istore 15
    //   679: iload_3
    //   680: istore 16
    //   682: goto +842 -> 1524
    //   685: aload_1
    //   686: invokevirtual 96	sc:l	()LrZ;
    //   689: astore 26
    //   691: aload_0
    //   692: iconst_4
    //   693: aload_0
    //   694: getfield 144	dG:e	I
    //   697: ior
    //   698: putfield 144	dG:e	I
    //   701: aload_0
    //   702: aload 26
    //   704: putfield 150	dG:o	Ljava/lang/Object;
    //   707: iload 6
    //   709: istore 15
    //   711: iload_3
    //   712: istore 16
    //   714: goto +810 -> 1524
    //   717: aload_1
    //   718: invokevirtual 96	sc:l	()LrZ;
    //   721: astore 25
    //   723: aload_0
    //   724: bipush 8
    //   726: aload_0
    //   727: getfield 144	dG:e	I
    //   730: ior
    //   731: putfield 144	dG:e	I
    //   734: aload_0
    //   735: aload 25
    //   737: putfield 152	dG:p	Ljava/lang/Object;
    //   740: iload 6
    //   742: istore 15
    //   744: iload_3
    //   745: istore 16
    //   747: goto +777 -> 1524
    //   750: bipush 16
    //   752: aload_0
    //   753: getfield 144	dG:e	I
    //   756: iand
    //   757: bipush 16
    //   759: if_icmpne +717 -> 1476
    //   762: aload_0
    //   763: getfield 154	dG:q	Lds;
    //   766: invokevirtual 159	ds:m	()Ldu;
    //   769: astore 23
    //   771: aload_0
    //   772: aload_1
    //   773: getstatic 160	ds:a	LsI;
    //   776: aload_2
    //   777: invokevirtual 117	sc:a	(LsI;Lsg;)LsE;
    //   780: checkcast 156	ds
    //   783: putfield 154	dG:q	Lds;
    //   786: aload 23
    //   788: ifnull +22 -> 810
    //   791: aload 23
    //   793: aload_0
    //   794: getfield 154	dG:q	Lds;
    //   797: invokevirtual 165	du:a	(Lds;)Ldu;
    //   800: pop
    //   801: aload_0
    //   802: aload 23
    //   804: invokevirtual 168	du:d	()Lds;
    //   807: putfield 154	dG:q	Lds;
    //   810: aload_0
    //   811: bipush 16
    //   813: aload_0
    //   814: getfield 144	dG:e	I
    //   817: ior
    //   818: putfield 144	dG:e	I
    //   821: iload 6
    //   823: istore 15
    //   825: iload_3
    //   826: istore 16
    //   828: goto +696 -> 1524
    //   831: aload_0
    //   832: bipush 32
    //   834: aload_0
    //   835: getfield 144	dG:e	I
    //   838: ior
    //   839: putfield 144	dG:e	I
    //   842: aload_0
    //   843: aload_1
    //   844: invokevirtual 171	sc:c	()F
    //   847: putfield 173	dG:r	F
    //   850: iload 6
    //   852: istore 15
    //   854: iload_3
    //   855: istore 16
    //   857: goto +667 -> 1524
    //   860: aload_1
    //   861: invokevirtual 96	sc:l	()LrZ;
    //   864: astore 17
    //   866: iload_3
    //   867: sipush 16384
    //   870: iand
    //   871: sipush 16384
    //   874: if_icmpeq +596 -> 1470
    //   877: aload_0
    //   878: new 98	sz
    //   881: dup
    //   882: invokespecial 99	sz:<init>	()V
    //   885: putfield 175	dG:t	LsA;
    //   888: iload_3
    //   889: sipush 16384
    //   892: ior
    //   893: istore 18
    //   895: aload_0
    //   896: getfield 175	dG:t	LsA;
    //   899: aload 17
    //   901: invokeinterface 106 2 0
    //   906: iload 6
    //   908: istore 22
    //   910: iload 18
    //   912: istore 16
    //   914: iload 22
    //   916: istore 15
    //   918: goto +606 -> 1524
    //   921: aload_0
    //   922: sipush 128
    //   925: aload_0
    //   926: getfield 144	dG:e	I
    //   929: ior
    //   930: putfield 144	dG:e	I
    //   933: aload_0
    //   934: aload_1
    //   935: invokevirtual 177	sc:f	()I
    //   938: putfield 179	dG:u	I
    //   941: iload 6
    //   943: istore 15
    //   945: iload_3
    //   946: istore 16
    //   948: goto +576 -> 1524
    //   951: aload_0
    //   952: bipush 64
    //   954: aload_0
    //   955: getfield 144	dG:e	I
    //   958: ior
    //   959: putfield 144	dG:e	I
    //   962: aload_0
    //   963: aload_1
    //   964: invokevirtual 182	sc:i	()Z
    //   967: putfield 184	dG:s	Z
    //   970: iload 6
    //   972: istore 15
    //   974: iload_3
    //   975: istore 16
    //   977: goto +547 -> 1524
    //   980: iload_3
    //   981: iconst_1
    //   982: iand
    //   983: iconst_1
    //   984: if_icmpne +18 -> 1002
    //   987: aload_0
    //   988: new 186	sY
    //   991: dup
    //   992: aload_0
    //   993: getfield 101	dG:f	LsA;
    //   996: invokespecial 189	sY:<init>	(LsA;)V
    //   999: putfield 101	dG:f	LsA;
    //   1002: iload_3
    //   1003: iconst_2
    //   1004: iand
    //   1005: iconst_2
    //   1006: if_icmpne +14 -> 1020
    //   1009: aload_0
    //   1010: aload_0
    //   1011: getfield 111	dG:g	Ljava/util/List;
    //   1014: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1017: putfield 111	dG:g	Ljava/util/List;
    //   1020: iload_3
    //   1021: iconst_4
    //   1022: iand
    //   1023: iconst_4
    //   1024: if_icmpne +14 -> 1038
    //   1027: aload_0
    //   1028: aload_0
    //   1029: getfield 125	dG:h	Ljava/util/List;
    //   1032: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1035: putfield 125	dG:h	Ljava/util/List;
    //   1038: iload_3
    //   1039: bipush 8
    //   1041: iand
    //   1042: bipush 8
    //   1044: if_icmpne +14 -> 1058
    //   1047: aload_0
    //   1048: aload_0
    //   1049: getfield 130	dG:i	Ljava/util/List;
    //   1052: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1055: putfield 130	dG:i	Ljava/util/List;
    //   1058: iload_3
    //   1059: bipush 16
    //   1061: iand
    //   1062: bipush 16
    //   1064: if_icmpne +14 -> 1078
    //   1067: aload_0
    //   1068: aload_0
    //   1069: getfield 135	dG:j	Ljava/util/List;
    //   1072: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1075: putfield 135	dG:j	Ljava/util/List;
    //   1078: iload_3
    //   1079: bipush 32
    //   1081: iand
    //   1082: bipush 32
    //   1084: if_icmpne +14 -> 1098
    //   1087: aload_0
    //   1088: aload_0
    //   1089: getfield 137	dG:k	Ljava/util/List;
    //   1092: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1095: putfield 137	dG:k	Ljava/util/List;
    //   1098: iload_3
    //   1099: bipush 64
    //   1101: iand
    //   1102: bipush 64
    //   1104: if_icmpne +14 -> 1118
    //   1107: aload_0
    //   1108: aload_0
    //   1109: getfield 139	dG:l	Ljava/util/List;
    //   1112: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1115: putfield 139	dG:l	Ljava/util/List;
    //   1118: iload_3
    //   1119: sipush 16384
    //   1122: iand
    //   1123: sipush 16384
    //   1126: if_icmpne +18 -> 1144
    //   1129: aload_0
    //   1130: new 186	sY
    //   1133: dup
    //   1134: aload_0
    //   1135: getfield 175	dG:t	LsA;
    //   1138: invokespecial 189	sY:<init>	(LsA;)V
    //   1141: putfield 175	dG:t	LsA;
    //   1144: aload 5
    //   1146: invokevirtual 197	se:a	()V
    //   1149: aload_0
    //   1150: aload 4
    //   1152: invokevirtual 201	sb:a	()LrZ;
    //   1155: putfield 203	dG:d	LrZ;
    //   1158: aload_0
    //   1159: invokevirtual 206	dG:R	()V
    //   1162: return
    //   1163: astore 8
    //   1165: aload_0
    //   1166: aload 4
    //   1168: invokevirtual 201	sb:a	()LrZ;
    //   1171: putfield 203	dG:d	LrZ;
    //   1174: goto -16 -> 1158
    //   1177: astore 7
    //   1179: aload_0
    //   1180: aload 4
    //   1182: invokevirtual 201	sb:a	()LrZ;
    //   1185: putfield 203	dG:d	LrZ;
    //   1188: aload 7
    //   1190: athrow
    //   1191: astore 13
    //   1193: aload 13
    //   1195: aload_0
    //   1196: invokevirtual 209	sx:a	(LsE;)Lsx;
    //   1199: athrow
    //   1200: astore 10
    //   1202: iload_3
    //   1203: iconst_1
    //   1204: iand
    //   1205: iconst_1
    //   1206: if_icmpne +18 -> 1224
    //   1209: aload_0
    //   1210: new 186	sY
    //   1213: dup
    //   1214: aload_0
    //   1215: getfield 101	dG:f	LsA;
    //   1218: invokespecial 189	sY:<init>	(LsA;)V
    //   1221: putfield 101	dG:f	LsA;
    //   1224: iload_3
    //   1225: iconst_2
    //   1226: iand
    //   1227: iconst_2
    //   1228: if_icmpne +14 -> 1242
    //   1231: aload_0
    //   1232: aload_0
    //   1233: getfield 111	dG:g	Ljava/util/List;
    //   1236: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1239: putfield 111	dG:g	Ljava/util/List;
    //   1242: iload_3
    //   1243: iconst_4
    //   1244: iand
    //   1245: iconst_4
    //   1246: if_icmpne +14 -> 1260
    //   1249: aload_0
    //   1250: aload_0
    //   1251: getfield 125	dG:h	Ljava/util/List;
    //   1254: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1257: putfield 125	dG:h	Ljava/util/List;
    //   1260: iload_3
    //   1261: bipush 8
    //   1263: iand
    //   1264: bipush 8
    //   1266: if_icmpne +14 -> 1280
    //   1269: aload_0
    //   1270: aload_0
    //   1271: getfield 130	dG:i	Ljava/util/List;
    //   1274: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1277: putfield 130	dG:i	Ljava/util/List;
    //   1280: iload_3
    //   1281: bipush 16
    //   1283: iand
    //   1284: bipush 16
    //   1286: if_icmpne +14 -> 1300
    //   1289: aload_0
    //   1290: aload_0
    //   1291: getfield 135	dG:j	Ljava/util/List;
    //   1294: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1297: putfield 135	dG:j	Ljava/util/List;
    //   1300: iload_3
    //   1301: bipush 32
    //   1303: iand
    //   1304: bipush 32
    //   1306: if_icmpne +14 -> 1320
    //   1309: aload_0
    //   1310: aload_0
    //   1311: getfield 137	dG:k	Ljava/util/List;
    //   1314: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1317: putfield 137	dG:k	Ljava/util/List;
    //   1320: iload_3
    //   1321: bipush 64
    //   1323: iand
    //   1324: bipush 64
    //   1326: if_icmpne +14 -> 1340
    //   1329: aload_0
    //   1330: aload_0
    //   1331: getfield 139	dG:l	Ljava/util/List;
    //   1334: invokestatic 195	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1337: putfield 139	dG:l	Ljava/util/List;
    //   1340: iload_3
    //   1341: sipush 16384
    //   1344: iand
    //   1345: sipush 16384
    //   1348: if_icmpne +18 -> 1366
    //   1351: aload_0
    //   1352: new 186	sY
    //   1355: dup
    //   1356: aload_0
    //   1357: getfield 175	dG:t	LsA;
    //   1360: invokespecial 189	sY:<init>	(LsA;)V
    //   1363: putfield 175	dG:t	LsA;
    //   1366: aload 5
    //   1368: invokevirtual 197	se:a	()V
    //   1371: aload_0
    //   1372: aload 4
    //   1374: invokevirtual 201	sb:a	()LrZ;
    //   1377: putfield 203	dG:d	LrZ;
    //   1380: aload_0
    //   1381: invokevirtual 206	dG:R	()V
    //   1384: aload 10
    //   1386: athrow
    //   1387: astore 9
    //   1389: new 68	sx
    //   1392: dup
    //   1393: aload 9
    //   1395: invokevirtual 213	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1398: invokespecial 216	sx:<init>	(Ljava/lang/String;)V
    //   1401: aload_0
    //   1402: invokevirtual 209	sx:a	(LsE;)Lsx;
    //   1405: athrow
    //   1406: astore 12
    //   1408: aload_0
    //   1409: aload 4
    //   1411: invokevirtual 201	sb:a	()LrZ;
    //   1414: putfield 203	dG:d	LrZ;
    //   1417: goto -37 -> 1380
    //   1420: astore 11
    //   1422: aload_0
    //   1423: aload 4
    //   1425: invokevirtual 201	sb:a	()LrZ;
    //   1428: putfield 203	dG:d	LrZ;
    //   1431: aload 11
    //   1433: athrow
    //   1434: astore 21
    //   1436: iload 18
    //   1438: istore_3
    //   1439: aload 21
    //   1441: astore 10
    //   1443: goto -241 -> 1202
    //   1446: astore 20
    //   1448: iload 18
    //   1450: istore_3
    //   1451: aload 20
    //   1453: astore 9
    //   1455: goto -66 -> 1389
    //   1458: astore 19
    //   1460: iload 18
    //   1462: istore_3
    //   1463: aload 19
    //   1465: astore 13
    //   1467: goto -274 -> 1193
    //   1470: iload_3
    //   1471: istore 18
    //   1473: goto -578 -> 895
    //   1476: aconst_null
    //   1477: astore 23
    //   1479: goto -708 -> 771
    //   1482: iload_3
    //   1483: istore 18
    //   1485: goto -897 -> 588
    //   1488: iload_3
    //   1489: istore 18
    //   1491: goto -962 -> 529
    //   1494: iload_3
    //   1495: istore 18
    //   1497: goto -1027 -> 470
    //   1500: iload_3
    //   1501: istore 18
    //   1503: goto -1092 -> 411
    //   1506: iload_3
    //   1507: istore 18
    //   1509: goto -1157 -> 352
    //   1512: iload_3
    //   1513: istore 18
    //   1515: goto -1219 -> 296
    //   1518: iload_3
    //   1519: istore 18
    //   1521: goto -1274 -> 247
    //   1524: iload 16
    //   1526: istore_3
    //   1527: iload 15
    //   1529: istore 6
    //   1531: goto -1494 -> 37
    //   1534: iconst_1
    //   1535: istore 15
    //   1537: iload_3
    //   1538: istore 16
    //   1540: goto -16 -> 1524
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1543	0	this	dG
    //   0	1543	1	paramsc	sc
    //   0	1543	2	paramsg	sg
    //   21	1517	3	i1	int
    //   25	1399	4	localsb	sb
    //   32	1335	5	localse	se
    //   35	1495	6	i2	int
    //   1177	12	7	localObject1	Object
    //   1163	1	8	localIOException1	java.io.IOException
    //   1387	7	9	localIOException2	java.io.IOException
    //   1453	1	9	localObject2	Object
    //   1200	185	10	localObject3	Object
    //   1441	1	10	localObject4	Object
    //   1420	12	11	localObject5	Object
    //   1406	1	12	localIOException3	java.io.IOException
    //   1191	3	13	localsx1	sx
    //   1465	1	13	localObject6	Object
    //   46	156	14	i3	int
    //   210	1326	15	i4	int
    //   213	1326	16	i5	int
    //   864	36	17	localrZ1	rZ
    //   245	1275	18	i6	int
    //   1458	6	19	localsx2	sx
    //   1446	6	20	localIOException4	java.io.IOException
    //   1434	6	21	localObject7	Object
    //   908	7	22	i7	int
    //   769	709	23	localdu	du
    //   721	15	25	localrZ2	rZ
    //   689	14	26	localrZ3	rZ
    //   657	14	27	localrZ4	rZ
    //   625	14	28	localrZ5	rZ
    //   608	7	30	i8	int
    //   549	7	32	i9	int
    //   490	7	34	i10	int
    //   431	7	36	i11	int
    //   372	7	38	i12	int
    //   316	7	40	i13	int
    //   222	30	41	localrZ6	rZ
    //   260	7	42	i14	int
    // Exception table:
    //   from	to	target	type
    //   1144	1149	1163	java/io/IOException
    //   1144	1149	1177	finally
    //   42	242	1191	sx
    //   280	291	1191	sx
    //   336	347	1191	sx
    //   394	405	1191	sx
    //   453	464	1191	sx
    //   512	523	1191	sx
    //   571	582	1191	sx
    //   621	888	1191	sx
    //   921	970	1191	sx
    //   42	242	1200	finally
    //   280	291	1200	finally
    //   336	347	1200	finally
    //   394	405	1200	finally
    //   453	464	1200	finally
    //   512	523	1200	finally
    //   571	582	1200	finally
    //   621	888	1200	finally
    //   921	970	1200	finally
    //   1193	1200	1200	finally
    //   1389	1406	1200	finally
    //   42	242	1387	java/io/IOException
    //   280	291	1387	java/io/IOException
    //   336	347	1387	java/io/IOException
    //   394	405	1387	java/io/IOException
    //   453	464	1387	java/io/IOException
    //   512	523	1387	java/io/IOException
    //   571	582	1387	java/io/IOException
    //   621	888	1387	java/io/IOException
    //   921	970	1387	java/io/IOException
    //   1366	1371	1406	java/io/IOException
    //   1366	1371	1420	finally
    //   247	258	1434	finally
    //   296	314	1434	finally
    //   352	370	1434	finally
    //   411	429	1434	finally
    //   470	488	1434	finally
    //   529	547	1434	finally
    //   588	606	1434	finally
    //   895	906	1434	finally
    //   247	258	1446	java/io/IOException
    //   296	314	1446	java/io/IOException
    //   352	370	1446	java/io/IOException
    //   411	429	1446	java/io/IOException
    //   470	488	1446	java/io/IOException
    //   529	547	1446	java/io/IOException
    //   588	606	1446	java/io/IOException
    //   895	906	1446	java/io/IOException
    //   247	258	1458	sx
    //   296	314	1458	sx
    //   352	370	1458	sx
    //   411	429	1458	sx
    //   470	488	1458	sx
    //   529	547	1458	sx
    //   588	606	1458	sx
    //   895	906	1458	sx
  }
  
  private dG(sn paramsn)
  {
    super(paramsn);
    this.d = paramsn.r();
  }
  
  private dG(boolean paramBoolean)
  {
    this.d = rZ.a;
  }
  
  public static dI N()
  {
    return dI.o();
  }
  
  private void S()
  {
    this.f = sz.a;
    this.g = Collections.emptyList();
    this.h = Collections.emptyList();
    this.i = Collections.emptyList();
    this.j = Collections.emptyList();
    this.k = Collections.emptyList();
    this.l = Collections.emptyList();
    this.m = "";
    this.n = "";
    this.o = "0";
    this.p = "";
    this.q = ds.a();
    this.r = 0.0F;
    this.s = false;
    this.t = sz.a;
    this.u = 0;
  }
  
  public static dG a()
  {
    return c;
  }
  
  public static dI a(dG paramdG)
  {
    return N().a(paramdG);
  }
  
  public String A()
  {
    Object localObject1 = this.o;
    if ((localObject1 instanceof String)) {}
    String str;
    for (Object localObject2 = (String)localObject1;; localObject2 = str)
    {
      return localObject2;
      rZ localrZ = (rZ)localObject1;
      str = localrZ.f();
      if (localrZ.g()) {
        this.o = str;
      }
    }
  }
  
  public boolean B()
  {
    if ((0x8 & this.e) == 8) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String C()
  {
    Object localObject1 = this.p;
    if ((localObject1 instanceof String)) {}
    String str;
    for (Object localObject2 = (String)localObject1;; localObject2 = str)
    {
      return localObject2;
      rZ localrZ = (rZ)localObject1;
      str = localrZ.f();
      if (localrZ.g()) {
        this.p = str;
      }
    }
  }
  
  public boolean D()
  {
    if ((0x10 & this.e) == 16) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public ds E()
  {
    return this.q;
  }
  
  public boolean F()
  {
    if ((0x20 & this.e) == 32) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public float G()
  {
    return this.r;
  }
  
  public boolean H()
  {
    if ((0x40 & this.e) == 64) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean I()
  {
    return this.s;
  }
  
  public List<String> J()
  {
    return this.t;
  }
  
  public int K()
  {
    return this.t.size();
  }
  
  public boolean L()
  {
    if ((0x80 & this.e) == 128) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int M()
  {
    return this.u;
  }
  
  public dI O()
  {
    return N();
  }
  
  public dI P()
  {
    return a(this);
  }
  
  public dQ a(int paramInt)
  {
    return (dQ)this.g.get(paramInt);
  }
  
  public dC b(int paramInt)
  {
    return (dC)this.h.get(paramInt);
  }
  
  public dG b()
  {
    return c;
  }
  
  public dy c(int paramInt)
  {
    return (dy)this.i.get(paramInt);
  }
  
  public sI<dG> c()
  {
    return a;
  }
  
  public dy d(int paramInt)
  {
    return (dy)this.j.get(paramInt);
  }
  
  public List<String> d()
  {
    return this.f;
  }
  
  public int e()
  {
    return this.f.size();
  }
  
  public dy e(int paramInt)
  {
    return (dy)this.k.get(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool1;
      if (!(paramObject instanceof dG))
      {
        bool1 = super.equals(paramObject);
      }
      else
      {
        dG localdG = (dG)paramObject;
        boolean bool2;
        label49:
        boolean bool3;
        label73:
        boolean bool4;
        label97:
        boolean bool5;
        label121:
        boolean bool6;
        label145:
        boolean bool7;
        label169:
        boolean bool8;
        label193:
        boolean bool9;
        label212:
        label241:
        boolean bool10;
        label260:
        label289:
        boolean bool11;
        label308:
        label337:
        boolean bool12;
        label356:
        boolean bool13;
        label385:
        label404:
        label433:
        boolean bool14;
        label452:
        label484:
        boolean bool15;
        label503:
        boolean bool16;
        if (d().equals(localdG.d()))
        {
          bool2 = bool1;
          if ((!bool2) || (!f().equals(localdG.f()))) {
            break label606;
          }
          bool3 = bool1;
          if ((!bool3) || (!h().equals(localdG.h()))) {
            break label612;
          }
          bool4 = bool1;
          if ((!bool4) || (!k().equals(localdG.k()))) {
            break label618;
          }
          bool5 = bool1;
          if ((!bool5) || (!m().equals(localdG.m()))) {
            break label624;
          }
          bool6 = bool1;
          if ((!bool6) || (!r().equals(localdG.r()))) {
            break label630;
          }
          bool7 = bool1;
          if ((!bool7) || (!t().equals(localdG.t()))) {
            break label636;
          }
          bool8 = bool1;
          if ((!bool8) || (v() != localdG.v())) {
            break label642;
          }
          bool9 = bool1;
          if (v())
          {
            if ((!bool9) || (!w().equals(localdG.w()))) {
              break label648;
            }
            bool9 = bool1;
          }
          if ((!bool9) || (x() != localdG.x())) {
            break label654;
          }
          bool10 = bool1;
          if (x())
          {
            if ((!bool10) || (!y().equals(localdG.y()))) {
              break label660;
            }
            bool10 = bool1;
          }
          if ((!bool10) || (z() != localdG.z())) {
            break label666;
          }
          bool11 = bool1;
          if (z())
          {
            if ((!bool11) || (!A().equals(localdG.A()))) {
              break label672;
            }
            bool11 = bool1;
          }
          if ((!bool11) || (B() != localdG.B())) {
            break label678;
          }
          bool12 = bool1;
          if (B())
          {
            if ((!bool12) || (!C().equals(localdG.C()))) {
              break label684;
            }
            bool12 = bool1;
          }
          if ((!bool12) || (D() != localdG.D())) {
            break label690;
          }
          bool13 = bool1;
          if (D())
          {
            if ((!bool13) || (!E().equals(localdG.E()))) {
              break label696;
            }
            bool13 = bool1;
          }
          if ((!bool13) || (F() != localdG.F())) {
            break label702;
          }
          bool14 = bool1;
          if (F())
          {
            if ((!bool14) || (Float.floatToIntBits(G()) != Float.floatToIntBits(localdG.G()))) {
              break label708;
            }
            bool14 = bool1;
          }
          if ((!bool14) || (H() != localdG.H())) {
            break label714;
          }
          bool15 = bool1;
          if (H())
          {
            if ((!bool15) || (I() != localdG.I())) {
              break label720;
            }
            bool15 = bool1;
          }
          label529:
          if ((!bool15) || (!J().equals(localdG.J()))) {
            break label726;
          }
          bool16 = bool1;
          label553:
          if ((!bool16) || (L() != localdG.L())) {
            break label732;
          }
        }
        label642:
        label648:
        label654:
        label660:
        label666:
        label672:
        label678:
        label684:
        label690:
        label696:
        label702:
        label708:
        label714:
        label720:
        label726:
        label732:
        for (boolean bool17 = bool1;; bool17 = false)
        {
          if (!L()) {
            break label738;
          }
          if ((bool17) && (M() == localdG.M())) {
            break;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label49;
          label606:
          bool3 = false;
          break label73;
          label612:
          bool4 = false;
          break label97;
          label618:
          bool5 = false;
          break label121;
          label624:
          bool6 = false;
          break label145;
          label630:
          bool7 = false;
          break label169;
          label636:
          bool8 = false;
          break label193;
          bool9 = false;
          break label212;
          bool9 = false;
          break label241;
          bool10 = false;
          break label260;
          bool10 = false;
          break label289;
          bool11 = false;
          break label308;
          bool11 = false;
          break label337;
          bool12 = false;
          break label356;
          bool12 = false;
          break label385;
          bool13 = false;
          break label404;
          bool13 = false;
          break label433;
          bool14 = false;
          break label452;
          bool14 = false;
          break label484;
          bool15 = false;
          break label503;
          bool15 = false;
          break label529;
          bool16 = false;
          break label553;
        }
        label738:
        bool1 = bool17;
      }
    }
  }
  
  public List<dQ> f()
  {
    return this.g;
  }
  
  public int g()
  {
    return this.g.size();
  }
  
  public List<dC> h()
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
      int i1 = 779 + dG.class.hashCode();
      if (e() > 0) {
        i1 = 53 * (1 + i1 * 37) + d().hashCode();
      }
      if (g() > 0) {
        i1 = 53 * (2 + i1 * 37) + f().hashCode();
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
      if (s() > 0) {
        i1 = 53 * (6 + i1 * 37) + r().hashCode();
      }
      if (u() > 0) {
        i1 = 53 * (7 + i1 * 37) + t().hashCode();
      }
      if (v()) {
        i1 = 53 * (9 + i1 * 37) + w().hashCode();
      }
      if (x()) {
        i1 = 53 * (10 + i1 * 37) + y().hashCode();
      }
      if (z()) {
        i1 = 53 * (12 + i1 * 37) + A().hashCode();
      }
      if (B()) {
        i1 = 53 * (13 + i1 * 37) + C().hashCode();
      }
      if (D()) {
        i1 = 53 * (14 + i1 * 37) + E().hashCode();
      }
      if (F()) {
        i1 = 53 * (15 + i1 * 37) + Float.floatToIntBits(G());
      }
      if (H()) {
        i1 = 53 * (18 + i1 * 37) + su.a(I());
      }
      if (K() > 0) {
        i1 = 53 * (16 + i1 * 37) + J().hashCode();
      }
      if (L()) {
        i1 = 53 * (17 + i1 * 37) + M();
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
    int i2 = this.v;
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
      for (int i3 = 0;; i3++)
      {
        if (i3 >= g()) {
          break label67;
        }
        if (!a(i3).j())
        {
          this.v = 0;
          break;
        }
      }
      label67:
      for (int i4 = 0;; i4++)
      {
        if (i4 >= i()) {
          break label105;
        }
        if (!b(i4).j())
        {
          this.v = 0;
          break;
        }
      }
      label105:
      for (int i5 = 0;; i5++)
      {
        if (i5 >= l()) {
          break label143;
        }
        if (!c(i5).j())
        {
          this.v = 0;
          break;
        }
      }
      label143:
      for (int i6 = 0;; i6++)
      {
        if (i6 >= q()) {
          break label181;
        }
        if (!d(i6).j())
        {
          this.v = 0;
          break;
        }
      }
      label181:
      for (int i7 = 0;; i7++)
      {
        if (i7 >= s()) {
          break label219;
        }
        if (!e(i7).j())
        {
          this.v = 0;
          break;
        }
      }
      label219:
      this.v = i1;
      bool = i1;
    }
  }
  
  public List<dy> k()
  {
    return this.i;
  }
  
  public int l()
  {
    return this.i.size();
  }
  
  public List<dy> m()
  {
    return this.j;
  }
  
  public int q()
  {
    return this.j.size();
  }
  
  public List<dy> r()
  {
    return this.k;
  }
  
  public int s()
  {
    return this.k.size();
  }
  
  public List<dK> t()
  {
    return this.l;
  }
  
  public int u()
  {
    return this.l.size();
  }
  
  public boolean v()
  {
    int i1 = 1;
    if ((0x1 & this.e) == i1) {}
    for (;;)
    {
      return i1;
      int i2 = 0;
    }
  }
  
  public String w()
  {
    Object localObject1 = this.m;
    if ((localObject1 instanceof String)) {}
    String str;
    for (Object localObject2 = (String)localObject1;; localObject2 = str)
    {
      return localObject2;
      rZ localrZ = (rZ)localObject1;
      str = localrZ.f();
      if (localrZ.g()) {
        this.m = str;
      }
    }
  }
  
  public boolean x()
  {
    if ((0x2 & this.e) == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String y()
  {
    Object localObject1 = this.n;
    if ((localObject1 instanceof String)) {}
    String str;
    for (Object localObject2 = (String)localObject1;; localObject2 = str)
    {
      return localObject2;
      rZ localrZ = (rZ)localObject1;
      str = localrZ.f();
      if (localrZ.g()) {
        this.n = str;
      }
    }
  }
  
  public boolean z()
  {
    if ((0x4 & this.e) == 4) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dG
 * JD-Core Version:    0.7.0.1
 */