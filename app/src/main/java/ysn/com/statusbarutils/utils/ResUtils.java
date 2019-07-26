package ysn.com.statusbarutils.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.View;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ysn.com.statusbarutils.R;

/**
 * @Author yangsanning
 * @ClassName ResUtils
 * @Description 资源Utils
 * @Date 2019/7/26
 * @History 2019/7/26 author: description:
 */
public final class ResUtils {

    private static final String TAG = "ResUtil";
    @SuppressLint("StaticFieldLeak")
    private static Application application = null;
    private static Resources resources = null;

    public static void inject(@NonNull Application application) {
        ResUtils.application = application;
        resources = application.getResources();
    }

    public static int getViewId(String packageName, String idName) {
        int id = 0;
        try {
            Class<?> cls = Class.forName(packageName + ".R$" + "id");
            id = cls.getField(idName).getInt(cls);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "NoSuchFieldException: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int getViewId(String idName) {
        int id = 0;
        try {
            Class<?> cls = R.id.class;
            id = cls.getField(idName).getInt(cls);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "NoSuchFieldException: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int getDrawableId(String packageName, String idName) {
        int id = 0;
        try {
            Class<?> cls = Class.forName(packageName + ".R$" + "drawable");
            id = cls.getField(idName).getInt(cls);
        } catch (Exception ignored) {
        }
        return id;
    }

    public static int getDrawableId(String idName) {
        int id = 0;
        try {
            Class<?> cls = R.drawable.class;
            id = cls.getField(idName).getInt(cls);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "NoSuchFieldException: " + e.getMessage());
        } catch (Exception ignored) {
        }
        return id;
    }

    public static int getStringId(String packageName, String idName) {
        int id = 0;
        try {
            Class<?> cls = Class.forName(packageName + ".R$" + "string");
            id = cls.getField(idName).getInt(cls);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "NoSuchFieldException: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int getStringId(String idName) {
        int id = View.NO_ID;
        try {
            Class<?> cls = R.string.class;
            id = cls.getField(idName).getInt(cls);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "NoSuchFieldException: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int getXmlId(String packageName, String idName) {
        int id = 0;
        try {
            Class<?> cls = Class.forName(packageName + ".R$" + "xml");
            id = cls.getField(idName).getInt(cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int[] getArrayRes(@ArrayRes int id) {
        return application.getResources().getIntArray(id);
    }

    public static String[] getStringArray(@ArrayRes int id) {
        return application.getResources().getStringArray(id);
    }

    public static int[] getResourcesIdArray(@ArrayRes int id) {
        TypedArray typedArray = application.getResources().obtainTypedArray(id);
        int length = typedArray.length();
        int[] resArray = new int[length];
        for (int i = 0; i < length; i++) {
            int resourceId = typedArray.getResourceId(i, 0);
            resArray[i] = resourceId;
        }
        typedArray.recycle();
        return resArray;
    }

    public static Integer[] getResourcesIdIntegerArray(@ArrayRes int id) {
        TypedArray typedArray = application.getResources().obtainTypedArray(id);
        int length = typedArray.length();
        Integer[] resArray = new Integer[length];
        for (int i = 0; i < length; i++) {
            int resourceId = typedArray.getResourceId(i, 0);
            resArray[i] = resourceId;
        }
        typedArray.recycle();
        return resArray;
    }

    public static List<Integer> getResourcesIdList(@ArrayRes int id) {
        return Arrays.asList(getResourcesIdIntegerArray(id));
    }

    public static List<String> getListString(@ArrayRes int id) {
        return Arrays.asList(application.getResources().getStringArray(id));
    }

    public static List<String> getMutableListString(@ArrayRes int id) {
        List<String> l = new ArrayList<>();
        l.addAll(Arrays.asList(application.getResources().getStringArray(id)));
        return l;
    }

    public static String getString(@StringRes int id) {
        return application.getResources().getString(id);
    }

    public static String getStringFormat(@StringRes int id, Object... args) {
        return String.format(application.getResources().getString(id), args);
    }

    public static String getStringFormat(String string, Object... args) {
        return String.format(string, args);
    }

    public static int getColor(@ColorRes int id) {
        return application.getResources().getColor(id);
    }

    public static Drawable getDrawable(@DrawableRes int id) {
        return application.getResources().getDrawable(id);
    }

    public static Resources getResources() {
        return resources;
    }

    public static String Md5(String MStr) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(MStr.getBytes());
            return bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException var2) {
            return String.valueOf(MStr.hashCode());
        }
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; ++i) {
            String hex = Integer.toHexString(255 & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }

            sb.append(hex);
        }
        return sb.toString();
    }

    public static float getDimension(@DimenRes int dimenID) {
        return application.getResources().getDimension(dimenID);
    }
}
