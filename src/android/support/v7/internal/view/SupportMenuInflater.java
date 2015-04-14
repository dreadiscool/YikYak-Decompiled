package android.support.v7.internal.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.view.ActionProvider;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import org.xmlpull.v1.XmlPullParser;

public class SupportMenuInflater
  extends MenuInflater
{
  private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  private static final String LOG_TAG = "SupportMenuInflater";
  private static final int NO_ID = 0;
  private static final String XML_GROUP = "group";
  private static final String XML_ITEM = "item";
  private static final String XML_MENU = "menu";
  private final Object[] mActionProviderConstructorArguments;
  private final Object[] mActionViewConstructorArguments;
  private Context mContext;
  private Object mRealOwner;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    ACTION_VIEW_CONSTRUCTOR_SIGNATURE = arrayOfClass;
  }
  
  public SupportMenuInflater(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramContext;
    this.mActionViewConstructorArguments = arrayOfObject;
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }
  
  private Object findRealOwner(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {}
    for (;;)
    {
      return paramObject;
      if ((paramObject instanceof ContextWrapper)) {
        paramObject = findRealOwner(((ContextWrapper)paramObject).getBaseContext());
      }
    }
  }
  
  private Object getRealOwner()
  {
    if (this.mRealOwner == null) {
      this.mRealOwner = findRealOwner(this.mContext);
    }
    return this.mRealOwner;
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    SupportMenuInflater.MenuState localMenuState = new SupportMenuInflater.MenuState(this, paramMenu);
    int i = paramXmlPullParser.getEventType();
    String str3;
    label51:
    Object localObject;
    int j;
    int k;
    int m;
    if (i == 2)
    {
      str3 = paramXmlPullParser.getName();
      if (str3.equals("menu"))
      {
        i = paramXmlPullParser.next();
        localObject = null;
        j = 0;
        k = i;
        m = 0;
        label64:
        if (m != 0) {
          return;
        }
      }
    }
    label96:
    int n;
    switch (k)
    {
    default: 
      n = j;
    case 2: 
    case 3: 
      for (;;)
      {
        int i1 = paramXmlPullParser.next();
        int i2 = n;
        k = i1;
        j = i2;
        break label64;
        throw new RuntimeException("Expecting menu, got " + str3);
        i = paramXmlPullParser.next();
        if (i != 1) {
          break;
        }
        break label51;
        if (j != 0)
        {
          n = j;
        }
        else
        {
          String str2 = paramXmlPullParser.getName();
          if (str2.equals("group"))
          {
            localMenuState.readGroup(paramAttributeSet);
            n = j;
          }
          else if (str2.equals("item"))
          {
            localMenuState.readItem(paramAttributeSet);
            n = j;
          }
          else if (str2.equals("menu"))
          {
            parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
            n = j;
          }
          else
          {
            localObject = str2;
            n = 1;
            continue;
            String str1 = paramXmlPullParser.getName();
            if ((j != 0) && (str1.equals(localObject)))
            {
              localObject = null;
              n = 0;
            }
            else if (str1.equals("group"))
            {
              localMenuState.resetGroup();
              n = j;
            }
            else
            {
              if (str1.equals("item"))
              {
                if (localMenuState.hasAddedItem()) {
                  break label96;
                }
                if ((SupportMenuInflater.MenuState.access$000(localMenuState) != null) && (SupportMenuInflater.MenuState.access$000(localMenuState).hasSubMenu()))
                {
                  localMenuState.addSubMenuItem();
                  n = j;
                  continue;
                }
                localMenuState.addItem();
                n = j;
                continue;
              }
              if (!str1.equals("menu")) {
                break label96;
              }
              m = 1;
              n = j;
            }
          }
        }
      }
    }
    throw new RuntimeException("Unexpected end of document");
  }
  
  /* Error */
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 167
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 169	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 47	android/support/v7/internal/view/SupportMenuInflater:mContext	Landroid/content/Context;
    //   20: invokevirtual 173	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload_1
    //   24: invokevirtual 179	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   27: astore_3
    //   28: aload_0
    //   29: aload_3
    //   30: aload_3
    //   31: invokestatic 185	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   34: aload_2
    //   35: invokespecial 138	android/support/v7/internal/view/SupportMenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   38: aload_3
    //   39: ifnull -26 -> 13
    //   42: aload_3
    //   43: invokeinterface 190 1 0
    //   48: goto -35 -> 13
    //   51: astore 6
    //   53: new 192	android/view/InflateException
    //   56: dup
    //   57: ldc 194
    //   59: aload 6
    //   61: invokespecial 197	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: athrow
    //   65: astore 5
    //   67: aload_3
    //   68: ifnull +9 -> 77
    //   71: aload_3
    //   72: invokeinterface 190 1 0
    //   77: aload 5
    //   79: athrow
    //   80: astore 4
    //   82: new 192	android/view/InflateException
    //   85: dup
    //   86: ldc 194
    //   88: aload 4
    //   90: invokespecial 197	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	SupportMenuInflater
    //   0	94	1	paramInt	int
    //   0	94	2	paramMenu	Menu
    //   15	57	3	localXmlResourceParser	android.content.res.XmlResourceParser
    //   80	9	4	localIOException	java.io.IOException
    //   65	13	5	localObject	Object
    //   51	9	6	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    // Exception table:
    //   from	to	target	type
    //   16	38	51	org/xmlpull/v1/XmlPullParserException
    //   16	38	65	finally
    //   53	65	65	finally
    //   82	94	65	finally
    //   16	38	80	java/io/IOException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportMenuInflater
 * JD-Core Version:    0.7.0.1
 */