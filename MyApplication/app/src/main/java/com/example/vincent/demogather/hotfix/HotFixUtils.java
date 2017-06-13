package com.example.vincent.demogather.hotfix;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashSet;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * Created by VincentChen on 2017/6/6.
 */
public class HotFixUtils {

    private static HashSet<File> dexFiles = new HashSet<>();

    public static void print(Context context) {
        Log.d("Vincent", "context.getCacheDir = " + context.getCacheDir());
        Log.d("Vincent", "context.getExternalCacheDir = " + context.getExternalCacheDir());
    }

    public static void copyFile(String destFilePath, String originFilePath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldFile = new File(originFilePath);
            if (oldFile.exists()) {
                InputStream inputStream = new FileInputStream(originFilePath);
                OutputStream outputStream = new FileOutputStream(destFilePath);
                byte[] buffer = new byte[1024];
                int length;
                while ((byteread = inputStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    System.out.print(bytesum);
                    outputStream.write(buffer, 0, byteread);
                }
                inputStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    public static void loadFixedDex(Context context) {
        File fileDir = context.getCacheDir();
        if (fileDir != null) {
            File[] files = fileDir.listFiles();
            for (File file : files) {
                if (file.getName().endsWith("4.dex")) {
                    Log.d("Vincent", "找到dex文件：" + file.getName());
                    dexFiles.add(file);
                }
            }
            doDexInject(context, fileDir, dexFiles);
        }
    }

    private static void doDexInject(Context context, File fileDir, HashSet<File> dexFiles) {
        String optimizeDir = fileDir.getAbsolutePath() + File.separator + "opt_dex;";
        File fopt = new File(optimizeDir);
        if (!fopt.exists()) {
            fopt.mkdir();
        }
        try {
            for (File file : dexFiles) {
                DexClassLoader dexClassLoader = new DexClassLoader(file.getAbsolutePath(), fopt.getAbsolutePath(), null, context.getClassLoader());
                inject(dexClassLoader, context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void inject(DexClassLoader dexLoader, Context context) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        try {
            Object dexElements = combineArray(getDexElements(getPathList(dexLoader)), getDexElements(getPathList(pathClassLoader)));
            Object pathList = getPathList(pathClassLoader);
            setField(pathList, pathList.getClass(), "dexElements", dexElements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object getPathList(Object baseDexClassLoader) {
        try {
            return getField(baseDexClassLoader, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }

    private static Object getDexElements(Object paramObject) {
        return getField(paramObject, paramObject.getClass(), "dexElements");
    }

    private static Object getField(Object object, Class<?> cls, String field) {
        try {
            Field localField = cls.getDeclaredField(field);
            localField.setAccessible(true);
            return localField.get(object);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object combineArray(Object arrayLhs, Object arrayRhs) {
        Class<?> localClass = arrayLhs.getClass().getComponentType();
        int i = Array.getLength(arrayLhs);
        int j = i + Array.getLength(arrayRhs);
        Object result = Array.newInstance(localClass, j);
        for (int k = 0 ; k < j ; ++k) {
            if (k < i ) {
                 Array.set(result, k, Array.get(arrayLhs, k));
            } else {
                Array.set(result, k, Array.get(arrayRhs, k - i));
            }
        }
        return result;
    }

    private static void setField(Object obj, Class<?> cls, String field, Object value) {
        try {
            Field localField = cls.getDeclaredField(field);
            localField.setAccessible(true);
            localField.set(obj, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
