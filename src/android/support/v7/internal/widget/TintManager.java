package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.util.TypedValue;

public class TintManager
{
  private static final TintManager.ColorFilterLruCache COLOR_FILTER_CACHE;
  private static final int[] CONTAINERS_WITH_TINT_CHILDREN;
  private static final boolean DEBUG;
  static final PorterDuff.Mode DEFAULT_MODE;
  private static final String TAG = TintManager.class.getSimpleName();
  private static final int[] TINT_COLOR_BACKGROUND_MULTIPLY;
  private static final int[] TINT_COLOR_CONTROL_ACTIVATED;
  private static final int[] TINT_COLOR_CONTROL_NORMAL;
  private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  private final Context mContext;
  private ColorStateList mDefaultColorStateList;
  private final Resources mResources;
  private ColorStateList mSwitchThumbStateList;
  private ColorStateList mSwitchTrackStateList;
  private final TypedValue mTypedValue;
  
  static
  {
    DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    COLOR_FILTER_CACHE = new TintManager.ColorFilterLruCache(6);
    int[] arrayOfInt1 = new int[14];
    arrayOfInt1[0] = R.drawable.abc_ic_ab_back_mtrl_am_alpha;
    arrayOfInt1[1] = R.drawable.abc_ic_go_search_api_mtrl_alpha;
    arrayOfInt1[2] = R.drawable.abc_ic_search_api_mtrl_alpha;
    arrayOfInt1[3] = R.drawable.abc_ic_commit_search_api_mtrl_alpha;
    arrayOfInt1[4] = R.drawable.abc_ic_clear_mtrl_alpha;
    arrayOfInt1[5] = R.drawable.abc_ic_menu_share_mtrl_alpha;
    arrayOfInt1[6] = R.drawable.abc_ic_menu_copy_mtrl_am_alpha;
    arrayOfInt1[7] = R.drawable.abc_ic_menu_cut_mtrl_alpha;
    arrayOfInt1[8] = R.drawable.abc_ic_menu_selectall_mtrl_alpha;
    arrayOfInt1[9] = R.drawable.abc_ic_menu_paste_mtrl_am_alpha;
    arrayOfInt1[10] = R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha;
    arrayOfInt1[11] = R.drawable.abc_ic_voice_search_api_mtrl_alpha;
    arrayOfInt1[12] = R.drawable.abc_textfield_search_default_mtrl_alpha;
    arrayOfInt1[13] = R.drawable.abc_textfield_default_mtrl_alpha;
    TINT_COLOR_CONTROL_NORMAL = arrayOfInt1;
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = R.drawable.abc_textfield_activated_mtrl_alpha;
    arrayOfInt2[1] = R.drawable.abc_textfield_search_activated_mtrl_alpha;
    arrayOfInt2[2] = R.drawable.abc_cab_background_top_mtrl_alpha;
    TINT_COLOR_CONTROL_ACTIVATED = arrayOfInt2;
    int[] arrayOfInt3 = new int[3];
    arrayOfInt3[0] = R.drawable.abc_popup_background_mtrl_mult;
    arrayOfInt3[1] = R.drawable.abc_cab_background_internal_bg;
    arrayOfInt3[2] = R.drawable.abc_menu_hardkey_panel_mtrl_mult;
    TINT_COLOR_BACKGROUND_MULTIPLY = arrayOfInt3;
    int[] arrayOfInt4 = new int[6];
    arrayOfInt4[0] = R.drawable.abc_edit_text_material;
    arrayOfInt4[1] = R.drawable.abc_tab_indicator_material;
    arrayOfInt4[2] = R.drawable.abc_textfield_search_material;
    arrayOfInt4[3] = R.drawable.abc_spinner_mtrl_am_alpha;
    arrayOfInt4[4] = R.drawable.abc_btn_check_material;
    arrayOfInt4[5] = R.drawable.abc_btn_radio_material;
    TINT_COLOR_CONTROL_STATE_LIST = arrayOfInt4;
    int[] arrayOfInt5 = new int[1];
    arrayOfInt5[0] = R.drawable.abc_cab_background_top_material;
    CONTAINERS_WITH_TINT_CHILDREN = arrayOfInt5;
  }
  
  public TintManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mResources = new TintResources(paramContext.getResources(), this);
    this.mTypedValue = new TypedValue();
  }
  
  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool = false;
    int i = paramArrayOfInt.length;
    for (int j = 0;; j++) {
      if (j < i)
      {
        if (paramArrayOfInt[j] == paramInt) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  private ColorStateList getDefaultColorStateList()
  {
    if (this.mDefaultColorStateList == null)
    {
      int i = getThemeAttrColor(R.attr.colorControlNormal);
      int j = getThemeAttrColor(R.attr.colorControlActivated);
      int[][] arrayOfInt = new int[7][];
      int[] arrayOfInt1 = new int[7];
      int[] arrayOfInt2 = new int[1];
      arrayOfInt2[0] = -16842910;
      arrayOfInt[0] = arrayOfInt2;
      arrayOfInt1[0] = getDisabledThemeAttrColor(R.attr.colorControlNormal);
      int[] arrayOfInt3 = new int[1];
      arrayOfInt3[0] = 16842908;
      arrayOfInt[1] = arrayOfInt3;
      arrayOfInt1[1] = j;
      int[] arrayOfInt4 = new int[1];
      arrayOfInt4[0] = 16843518;
      arrayOfInt[2] = arrayOfInt4;
      arrayOfInt1[2] = j;
      int[] arrayOfInt5 = new int[1];
      arrayOfInt5[0] = 16842919;
      arrayOfInt[3] = arrayOfInt5;
      arrayOfInt1[3] = j;
      int[] arrayOfInt6 = new int[1];
      arrayOfInt6[0] = 16842912;
      arrayOfInt[4] = arrayOfInt6;
      arrayOfInt1[4] = j;
      int[] arrayOfInt7 = new int[1];
      arrayOfInt7[0] = 16842913;
      arrayOfInt[5] = arrayOfInt7;
      arrayOfInt1[5] = j;
      arrayOfInt[6] = new int[0];
      arrayOfInt1[6] = i;
      this.mDefaultColorStateList = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.mDefaultColorStateList;
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    if (isInTintList(paramInt)) {}
    for (Drawable localDrawable = new TintManager(paramContext).getDrawable(paramInt);; localDrawable = ContextCompat.getDrawable(paramContext, paramInt)) {
      return localDrawable;
    }
  }
  
  private ColorStateList getSwitchThumbColorStateList()
  {
    if (this.mSwitchThumbStateList == null)
    {
      int[][] arrayOfInt = new int[3][];
      int[] arrayOfInt1 = new int[3];
      int[] arrayOfInt2 = new int[1];
      arrayOfInt2[0] = -16842910;
      arrayOfInt[0] = arrayOfInt2;
      arrayOfInt1[0] = getDisabledThemeAttrColor(R.attr.colorSwitchThumbNormal);
      int[] arrayOfInt3 = new int[1];
      arrayOfInt3[0] = 16842912;
      arrayOfInt[1] = arrayOfInt3;
      arrayOfInt1[1] = getThemeAttrColor(R.attr.colorControlActivated);
      arrayOfInt[2] = new int[0];
      arrayOfInt1[2] = getThemeAttrColor(R.attr.colorSwitchThumbNormal);
      this.mSwitchThumbStateList = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.mSwitchThumbStateList;
  }
  
  private ColorStateList getSwitchTrackColorStateList()
  {
    if (this.mSwitchTrackStateList == null)
    {
      int[][] arrayOfInt = new int[3][];
      int[] arrayOfInt1 = new int[3];
      int[] arrayOfInt2 = new int[1];
      arrayOfInt2[0] = -16842910;
      arrayOfInt[0] = arrayOfInt2;
      arrayOfInt1[0] = getThemeAttrColor(16842800, 0.1F);
      int[] arrayOfInt3 = new int[1];
      arrayOfInt3[0] = 16842912;
      arrayOfInt[1] = arrayOfInt3;
      arrayOfInt1[1] = getThemeAttrColor(R.attr.colorControlActivated, 0.3F);
      arrayOfInt[2] = new int[0];
      arrayOfInt1[2] = getThemeAttrColor(16842800, 0.3F);
      this.mSwitchTrackStateList = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.mSwitchTrackStateList;
  }
  
  private static boolean isInTintList(int paramInt)
  {
    if ((arrayContains(TINT_COLOR_BACKGROUND_MULTIPLY, paramInt)) || (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt)) || (arrayContains(TINT_COLOR_CONTROL_ACTIVATED, paramInt)) || (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) || (arrayContains(CONTAINERS_WITH_TINT_CHILDREN, paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  int getDisabledThemeAttrColor(int paramInt)
  {
    this.mContext.getTheme().resolveAttribute(16842803, this.mTypedValue, true);
    return getThemeAttrColor(paramInt, this.mTypedValue.getFloat());
  }
  
  public Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = ContextCompat.getDrawable(this.mContext, paramInt);
    Object localObject;
    if (localDrawable != null) {
      if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
        localObject = new TintDrawableWrapper(localDrawable, getDefaultColorStateList());
      }
    }
    for (;;)
    {
      return localObject;
      if (paramInt == R.drawable.abc_switch_track_mtrl_alpha)
      {
        localObject = new TintDrawableWrapper(localDrawable, getSwitchTrackColorStateList());
      }
      else if (paramInt == R.drawable.abc_switch_thumb_material)
      {
        localObject = new TintDrawableWrapper(localDrawable, getSwitchThumbColorStateList(), PorterDuff.Mode.MULTIPLY);
      }
      else if (arrayContains(CONTAINERS_WITH_TINT_CHILDREN, paramInt))
      {
        localObject = this.mResources.getDrawable(paramInt);
      }
      else
      {
        tintDrawable(paramInt, localDrawable);
        localObject = localDrawable;
      }
    }
  }
  
  int getThemeAttrColor(int paramInt)
  {
    int i;
    if (this.mContext.getTheme().resolveAttribute(paramInt, this.mTypedValue, true)) {
      if ((this.mTypedValue.type >= 16) && (this.mTypedValue.type <= 31)) {
        i = this.mTypedValue.data;
      }
    }
    for (;;)
    {
      return i;
      if (this.mTypedValue.type == 3) {
        i = this.mResources.getColor(this.mTypedValue.resourceId);
      } else {
        i = 0;
      }
    }
  }
  
  int getThemeAttrColor(int paramInt, float paramFloat)
  {
    int i = getThemeAttrColor(paramInt);
    int j = Color.alpha(i);
    return i & 0xFFFFFF | Math.round(paramFloat * j) << 24;
  }
  
  void tintDrawable(int paramInt, Drawable paramDrawable)
  {
    int j;
    Object localObject;
    int k;
    int i;
    if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt))
    {
      j = R.attr.colorControlNormal;
      localObject = null;
      k = 1;
      i = -1;
    }
    for (;;)
    {
      PorterDuffColorFilter localPorterDuffColorFilter1;
      PorterDuffColorFilter localPorterDuffColorFilter2;
      if (k != 0)
      {
        if (localObject == null) {
          localObject = DEFAULT_MODE;
        }
        int m = getThemeAttrColor(j);
        localPorterDuffColorFilter1 = COLOR_FILTER_CACHE.get(m, (PorterDuff.Mode)localObject);
        if (localPorterDuffColorFilter1 != null) {
          break label203;
        }
        localPorterDuffColorFilter2 = new PorterDuffColorFilter(m, (PorterDuff.Mode)localObject);
        COLOR_FILTER_CACHE.put(m, (PorterDuff.Mode)localObject, localPorterDuffColorFilter2);
      }
      label203:
      for (PorterDuffColorFilter localPorterDuffColorFilter3 = localPorterDuffColorFilter2;; localPorterDuffColorFilter3 = localPorterDuffColorFilter1)
      {
        paramDrawable.setColorFilter(localPorterDuffColorFilter3);
        if (i != -1) {
          paramDrawable.setAlpha(i);
        }
        return;
        if (arrayContains(TINT_COLOR_CONTROL_ACTIVATED, paramInt))
        {
          j = R.attr.colorControlActivated;
          localObject = null;
          k = 1;
          i = -1;
          break;
        }
        if (arrayContains(TINT_COLOR_BACKGROUND_MULTIPLY, paramInt))
        {
          PorterDuff.Mode localMode = PorterDuff.Mode.MULTIPLY;
          k = 1;
          i = -1;
          localObject = localMode;
          j = 16842801;
          break;
        }
        if (paramInt != R.drawable.abc_list_divider_mtrl_alpha) {
          break label210;
        }
        j = 16842800;
        int n = Math.round(40.799999F);
        localObject = null;
        k = 1;
        i = n;
        break;
      }
      label210:
      i = -1;
      j = 0;
      localObject = null;
      k = 0;
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     android.support.v7.internal.widget.TintManager

 * JD-Core Version:    0.7.0.1

 */