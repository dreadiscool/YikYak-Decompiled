package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter
  extends ResourceCursorAdapter
  implements View.OnClickListener
{
  private static final boolean DBG = false;
  static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = "SuggestionsAdapter";
  private static final int QUERY_LIMIT = 50;
  static final int REFINE_ALL = 2;
  static final int REFINE_BY_ENTRY = 1;
  static final int REFINE_NONE;
  private boolean mClosed = false;
  private final int mCommitIconResId;
  private int mFlagsCol = -1;
  private int mIconName1Col = -1;
  private int mIconName2Col = -1;
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
  private final Context mProviderContext;
  private int mQueryRefinement = 1;
  private final SearchManager mSearchManager = (SearchManager)this.mContext.getSystemService("search");
  private final SearchView mSearchView;
  private final SearchableInfo mSearchable;
  private int mText1Col = -1;
  private int mText2Col = -1;
  private int mText2UrlCol = -1;
  private ColorStateList mUrlColor;
  
  public SuggestionsAdapter(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.mSearchView = paramSearchView;
    this.mSearchable = paramSearchableInfo;
    this.mCommitIconResId = paramSearchView.getSuggestionCommitIconResId();
    this.mProviderContext = paramContext;
    this.mOutsideDrawablesCache = paramWeakHashMap;
  }
  
  private Drawable checkIconCache(String paramString)
  {
    Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.mOutsideDrawablesCache.get(paramString);
    if (localConstantState == null) {}
    for (Drawable localDrawable = null;; localDrawable = localConstantState.newDrawable()) {
      return localDrawable;
    }
  }
  
  private CharSequence formatUrl(CharSequence paramCharSequence)
  {
    if (this.mUrlColor == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, localTypedValue, true);
      this.mUrlColor = this.mContext.getResources().getColorStateList(localTypedValue.resourceId);
    }
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    localSpannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, paramCharSequence.length(), 33);
    return localSpannableString;
  }
  
  private Drawable getActivityIcon(ComponentName paramComponentName)
  {
    localObject = null;
    localPackageManager = this.mContext.getPackageManager();
    try
    {
      localActivityInfo = localPackageManager.getActivityInfo(paramComponentName, 128);
      i = localActivityInfo.getIconResource();
      if (i != 0) {
        break label45;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        ActivityInfo localActivityInfo;
        int i;
        localNameNotFoundException.toString();
        continue;
        Drawable localDrawable = localPackageManager.getDrawable(paramComponentName.getPackageName(), i, localActivityInfo.applicationInfo);
        if (localDrawable == null) {
          new StringBuilder().append("Invalid icon resource ").append(i).append(" for ").append(paramComponentName.flattenToShortString()).toString();
        } else {
          localObject = localDrawable;
        }
      }
    }
    return localObject;
  }
  
  private Drawable getActivityIconWithCache(ComponentName paramComponentName)
  {
    Object localObject = null;
    String str = paramComponentName.flattenToShortString();
    if (this.mOutsideDrawablesCache.containsKey(str))
    {
      Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.mOutsideDrawablesCache.get(str);
      if (localConstantState == null) {}
      for (localDrawable = null;; localDrawable = localConstantState.newDrawable(this.mProviderContext.getResources())) {
        return localDrawable;
      }
    }
    Drawable localDrawable = getActivityIcon(paramComponentName);
    if (localDrawable == null) {}
    for (;;)
    {
      this.mOutsideDrawablesCache.put(str, localObject);
      break;
      localObject = localDrawable.getConstantState();
    }
  }
  
  public static String getColumnString(Cursor paramCursor, String paramString)
  {
    return getStringOrNull(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private Drawable getDefaultIcon1(Cursor paramCursor)
  {
    Drawable localDrawable = getActivityIconWithCache(this.mSearchable.getSearchActivity());
    if (localDrawable != null) {}
    for (;;)
    {
      return localDrawable;
      localDrawable = this.mContext.getPackageManager().getDefaultActivityIcon();
    }
  }
  
  /* Error */
  private Drawable getDrawable(Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 278
    //   3: aload_1
    //   4: invokevirtual 283	android/net/Uri:getScheme	()Ljava/lang/String;
    //   7: invokevirtual 288	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: istore 5
    //   12: iload 5
    //   14: ifeq +88 -> 102
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 291	android/support/v7/widget/SuggestionsAdapter:getDrawableFromResourceUri	(Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;
    //   22: astore 14
    //   24: aload 14
    //   26: astore 4
    //   28: aload 4
    //   30: areturn
    //   31: astore 13
    //   33: new 272	java/io/FileNotFoundException
    //   36: dup
    //   37: new 208	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 293
    //   47: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 299	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: astore_2
    //   62: new 208	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 301
    //   72: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: ldc_w 303
    //   82: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 306	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   89: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: pop
    //   96: aconst_null
    //   97: astore 4
    //   99: goto -71 -> 28
    //   102: aload_0
    //   103: getfield 98	android/support/v7/widget/SuggestionsAdapter:mProviderContext	Landroid/content/Context;
    //   106: invokevirtual 310	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   109: aload_1
    //   110: invokevirtual 316	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   113: astore 6
    //   115: aload 6
    //   117: ifnonnull +31 -> 148
    //   120: new 272	java/io/FileNotFoundException
    //   123: dup
    //   124: new 208	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 318
    //   134: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokespecial 299	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   147: athrow
    //   148: aload 6
    //   150: aconst_null
    //   151: invokestatic 322	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   154: astore 10
    //   156: aload 10
    //   158: astore 4
    //   160: aload 6
    //   162: invokevirtual 327	java/io/InputStream:close	()V
    //   165: goto -137 -> 28
    //   168: astore 11
    //   170: new 208	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 329
    //   180: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: pop
    //   191: goto -163 -> 28
    //   194: astore 7
    //   196: aload 6
    //   198: invokevirtual 327	java/io/InputStream:close	()V
    //   201: aload 7
    //   203: athrow
    //   204: astore 8
    //   206: new 208	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 329
    //   216: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_1
    //   220: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: pop
    //   227: goto -26 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	SuggestionsAdapter
    //   0	230	1	paramUri	Uri
    //   61	25	2	localFileNotFoundException	FileNotFoundException
    //   26	133	4	localObject1	Object
    //   10	3	5	bool	boolean
    //   113	84	6	localInputStream	java.io.InputStream
    //   194	8	7	localObject2	Object
    //   204	1	8	localIOException1	java.io.IOException
    //   154	3	10	localDrawable1	Drawable
    //   168	1	11	localIOException2	java.io.IOException
    //   31	1	13	localNotFoundException	Resources.NotFoundException
    //   22	3	14	localDrawable2	Drawable
    // Exception table:
    //   from	to	target	type
    //   17	24	31	android/content/res/Resources$NotFoundException
    //   0	12	61	java/io/FileNotFoundException
    //   17	24	61	java/io/FileNotFoundException
    //   33	61	61	java/io/FileNotFoundException
    //   102	148	61	java/io/FileNotFoundException
    //   160	165	61	java/io/FileNotFoundException
    //   170	191	61	java/io/FileNotFoundException
    //   196	201	61	java/io/FileNotFoundException
    //   201	227	61	java/io/FileNotFoundException
    //   160	165	168	java/io/IOException
    //   148	156	194	finally
    //   196	201	204	java/io/IOException
  }
  
  private Drawable getDrawableFromResourceValue(String paramString)
  {
    Drawable localDrawable;
    if ((paramString == null) || (paramString.length() == 0) || ("0".equals(paramString))) {
      localDrawable = null;
    }
    for (;;)
    {
      return localDrawable;
      try
      {
        int i = Integer.parseInt(paramString);
        String str = "android.resource://" + this.mProviderContext.getPackageName() + "/" + i;
        localDrawable = checkIconCache(str);
        if (localDrawable == null)
        {
          localDrawable = ContextCompat.getDrawable(this.mProviderContext, i);
          storeInIconCache(str, localDrawable);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localDrawable = checkIconCache(paramString);
        if (localDrawable == null)
        {
          localDrawable = getDrawable(Uri.parse(paramString));
          storeInIconCache(paramString, localDrawable);
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        new StringBuilder().append("Icon resource not found: ").append(paramString).toString();
        localDrawable = null;
      }
    }
  }
  
  private Drawable getIcon1(Cursor paramCursor)
  {
    Drawable localDrawable;
    if (this.mIconName1Col == -1) {
      localDrawable = null;
    }
    for (;;)
    {
      return localDrawable;
      localDrawable = getDrawableFromResourceValue(paramCursor.getString(this.mIconName1Col));
      if (localDrawable == null) {
        localDrawable = getDefaultIcon1(paramCursor);
      }
    }
  }
  
  private Drawable getIcon2(Cursor paramCursor)
  {
    if (this.mIconName2Col == -1) {}
    for (Drawable localDrawable = null;; localDrawable = getDrawableFromResourceValue(paramCursor.getString(this.mIconName2Col))) {
      return localDrawable;
    }
  }
  
  private static String getStringOrNull(Cursor paramCursor, int paramInt)
  {
    Object localObject = null;
    if (paramInt == -1) {}
    for (;;)
    {
      return localObject;
      try
      {
        String str = paramCursor.getString(paramInt);
        localObject = str;
      }
      catch (Exception localException) {}
    }
  }
  
  private void setViewDrawable(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null) {
      paramImageView.setVisibility(paramInt);
    }
    for (;;)
    {
      return;
      paramImageView.setVisibility(0);
      paramDrawable.setVisible(false, false);
      paramDrawable.setVisible(true, false);
    }
  }
  
  private void setViewText(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {
      paramTextView.setVisibility(8);
    }
    for (;;)
    {
      return;
      paramTextView.setVisibility(0);
    }
  }
  
  private void storeInIconCache(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.mOutsideDrawablesCache.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private void updateSpinnerState(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (Bundle localBundle = paramCursor.getExtras();; localBundle = null)
    {
      if ((localBundle != null) && (localBundle.getBoolean("in_progress"))) {}
      return;
    }
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    SuggestionsAdapter.ChildViewCache localChildViewCache = (SuggestionsAdapter.ChildViewCache)paramView.getTag();
    if (this.mFlagsCol != -1) {}
    for (int i = paramCursor.getInt(this.mFlagsCol);; i = 0)
    {
      if (localChildViewCache.mText1 != null)
      {
        String str2 = getStringOrNull(paramCursor, this.mText1Col);
        setViewText(localChildViewCache.mText1, str2);
      }
      Object localObject;
      if (localChildViewCache.mText2 != null)
      {
        String str1 = getStringOrNull(paramCursor, this.mText2UrlCol);
        if (str1 != null)
        {
          localObject = formatUrl(str1);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label253;
          }
          if (localChildViewCache.mText1 != null)
          {
            localChildViewCache.mText1.setSingleLine(false);
            localChildViewCache.mText1.setMaxLines(2);
          }
          label124:
          setViewText(localChildViewCache.mText2, (CharSequence)localObject);
        }
      }
      else
      {
        if (localChildViewCache.mIcon1 != null) {
          setViewDrawable(localChildViewCache.mIcon1, getIcon1(paramCursor), 4);
        }
        if (localChildViewCache.mIcon2 != null) {
          setViewDrawable(localChildViewCache.mIcon2, getIcon2(paramCursor), 8);
        }
        if ((this.mQueryRefinement != 2) && ((this.mQueryRefinement != 1) || ((i & 0x1) == 0))) {
          break label282;
        }
        localChildViewCache.mIconRefine.setVisibility(0);
        localChildViewCache.mIconRefine.setTag(localChildViewCache.mText1.getText());
        localChildViewCache.mIconRefine.setOnClickListener(this);
      }
      for (;;)
      {
        return;
        localObject = getStringOrNull(paramCursor, this.mText2Col);
        break;
        label253:
        if (localChildViewCache.mText1 == null) {
          break label124;
        }
        localChildViewCache.mText1.setSingleLine(true);
        localChildViewCache.mText1.setMaxLines(1);
        break label124;
        label282:
        localChildViewCache.mIconRefine.setVisibility(8);
      }
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (this.mClosed) {
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    for (;;)
    {
      return;
      try
      {
        super.changeCursor(paramCursor);
        if (paramCursor != null)
        {
          this.mText1Col = paramCursor.getColumnIndex("suggest_text_1");
          this.mText2Col = paramCursor.getColumnIndex("suggest_text_2");
          this.mText2UrlCol = paramCursor.getColumnIndex("suggest_text_2_url");
          this.mIconName1Col = paramCursor.getColumnIndex("suggest_icon_1");
          this.mIconName2Col = paramCursor.getColumnIndex("suggest_icon_2");
          this.mFlagsCol = paramCursor.getColumnIndex("suggest_flags");
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void close()
  {
    changeCursor(null);
    this.mClosed = true;
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    Object localObject = null;
    if (paramCursor == null) {}
    for (;;)
    {
      return localObject;
      String str1 = getColumnString(paramCursor, "suggest_intent_query");
      if (str1 != null)
      {
        localObject = str1;
      }
      else
      {
        if (this.mSearchable.shouldRewriteQueryFromData())
        {
          String str3 = getColumnString(paramCursor, "suggest_intent_data");
          if (str3 != null)
          {
            localObject = str3;
            continue;
          }
        }
        if (this.mSearchable.shouldRewriteQueryFromText())
        {
          String str2 = getColumnString(paramCursor, "suggest_text_1");
          if (str2 != null) {
            localObject = str2;
          }
        }
      }
    }
  }
  
  Drawable getDrawableFromResourceUri(Uri paramUri)
  {
    String str = paramUri.getAuthority();
    if (TextUtils.isEmpty(str)) {
      throw new FileNotFoundException("No authority: " + paramUri);
    }
    Resources localResources;
    List localList;
    try
    {
      localResources = this.mContext.getPackageManager().getResourcesForApplication(str);
      localList = paramUri.getPathSegments();
      if (localList == null) {
        throw new FileNotFoundException("No path: " + paramUri);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new FileNotFoundException("No package found for authority: " + paramUri);
    }
    int i = localList.size();
    if (i == 1) {}
    int j;
    for (;;)
    {
      try
      {
        int k = Integer.parseInt((String)localList.get(0));
        j = k;
        if (j != 0) {
          break;
        }
        throw new FileNotFoundException("No resource found for: " + paramUri);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new FileNotFoundException("Single path segment is not a resource ID: " + paramUri);
      }
      if (i == 2) {
        j = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), str);
      } else {
        throw new FileNotFoundException("More than two path segments: " + paramUri);
      }
    }
    return localResources.getDrawable(j);
  }
  
  public int getQueryRefinement()
  {
    return this.mQueryRefinement;
  }
  
  Cursor getSearchManagerSuggestions(SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    Cursor localCursor = null;
    if (paramSearchableInfo == null) {}
    String str1;
    do
    {
      return localCursor;
      str1 = paramSearchableInfo.getSuggestAuthority();
    } while (str1 == null);
    Uri.Builder localBuilder = new Uri.Builder().scheme("content").authority(str1).query("").fragment("");
    String str2 = paramSearchableInfo.getSuggestPath();
    if (str2 != null) {
      localBuilder.appendEncodedPath(str2);
    }
    localBuilder.appendPath("search_suggest_query");
    String str3 = paramSearchableInfo.getSuggestSelection();
    String[] arrayOfString;
    if (str3 != null)
    {
      arrayOfString = new String[1];
      arrayOfString[0] = paramString;
    }
    for (;;)
    {
      if (paramInt > 0) {
        localBuilder.appendQueryParameter("limit", String.valueOf(paramInt));
      }
      Uri localUri = localBuilder.build();
      localCursor = this.mContext.getContentResolver().query(localUri, null, str3, arrayOfString, null);
      break;
      localBuilder.appendPath(paramString);
      arrayOfString = null;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      View localView2 = super.getView(paramInt, paramView, paramViewGroup);
      localObject = localView2;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        View localView1 = newView(this.mContext, this.mCursor, paramViewGroup);
        if (localView1 != null) {
          ((SuggestionsAdapter.ChildViewCache)localView1.getTag()).mText1.setText(localRuntimeException.toString());
        }
        Object localObject = localView1;
      }
    }
    return localObject;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    View localView = super.newView(paramContext, paramCursor, paramViewGroup);
    localView.setTag(new SuggestionsAdapter.ChildViewCache(localView));
    ((ImageView)localView.findViewById(R.id.edit_query)).setImageResource(this.mCommitIconResId);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    updateSpinnerState(getCursor());
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    updateSpinnerState(getCursor());
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof CharSequence)) {
      this.mSearchView.onQueryRefine((CharSequence)localObject);
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    String str;
    Cursor localCursor;
    if (paramCharSequence == null)
    {
      str = "";
      if ((this.mSearchView.getVisibility() == 0) && (this.mSearchView.getWindowVisibility() == 0)) {
        break label42;
      }
      localCursor = null;
    }
    for (;;)
    {
      return localCursor;
      str = paramCharSequence.toString();
      break;
      try
      {
        label42:
        localCursor = getSearchManagerSuggestions(this.mSearchable, str, 50);
        if (localCursor != null) {
          localCursor.getCount();
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        localCursor = null;
      }
    }
  }
  
  public void setQueryRefinement(int paramInt)
  {
    this.mQueryRefinement = paramInt;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SuggestionsAdapter
 * JD-Core Version:    0.7.0.1
 */