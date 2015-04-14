import android.os.IBinder;

class mT
  implements mR
{
  private IBinder a;
  
  mT(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public com.google.android.gms.maps.model.Tile a(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 24
    //   14: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: iload_1
    //   20: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   23: aload 4
    //   25: iload_2
    //   26: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   29: aload 4
    //   31: iload_3
    //   32: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   35: aload_0
    //   36: getfield 15	mT:a	Landroid/os/IBinder;
    //   39: iconst_1
    //   40: aload 4
    //   42: aload 5
    //   44: iconst_0
    //   45: invokeinterface 38 5 0
    //   50: pop
    //   51: aload 5
    //   53: invokevirtual 41	android/os/Parcel:readException	()V
    //   56: aload 5
    //   58: invokevirtual 45	android/os/Parcel:readInt	()I
    //   61: ifeq +30 -> 91
    //   64: getstatic 51	com/google/android/gms/maps/model/Tile:CREATOR	Lng;
    //   67: aload 5
    //   69: invokevirtual 56	ng:a	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/Tile;
    //   72: astore 9
    //   74: aload 9
    //   76: astore 8
    //   78: aload 5
    //   80: invokevirtual 59	android/os/Parcel:recycle	()V
    //   83: aload 4
    //   85: invokevirtual 59	android/os/Parcel:recycle	()V
    //   88: aload 8
    //   90: areturn
    //   91: aconst_null
    //   92: astore 8
    //   94: goto -16 -> 78
    //   97: astore 6
    //   99: aload 5
    //   101: invokevirtual 59	android/os/Parcel:recycle	()V
    //   104: aload 4
    //   106: invokevirtual 59	android/os/Parcel:recycle	()V
    //   109: aload 6
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	mT
    //   0	112	1	paramInt1	int
    //   0	112	2	paramInt2	int
    //   0	112	3	paramInt3	int
    //   3	102	4	localParcel1	android.os.Parcel
    //   8	92	5	localParcel2	android.os.Parcel
    //   97	13	6	localObject	Object
    //   76	17	8	localTile1	com.google.android.gms.maps.model.Tile
    //   72	3	9	localTile2	com.google.android.gms.maps.model.Tile
    // Exception table:
    //   from	to	target	type
    //   10	74	97	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mT
 * JD-Core Version:    0.7.0.1
 */