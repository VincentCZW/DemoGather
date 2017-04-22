package com.example.vincent.demogather.java.entity;


import com.example.vincent.demogather.common.VincentLog;

/**
 * Created by VincentChen on 2017/4/22.
 */
public class StaticClass {

    private static StaticClass instance = new StaticClass();

    public StaticClass() {
        VincentLog.logD("print c");
    }

    public static void print() {
        VincentLog.logD("print a");
    }

    static {
        VincentLog.logD("print b");
    }


    private static class InnerStaticClass {

        private InnerStaticClass innerStaticClass = new InnerStaticClass();

        static {
            VincentLog.logD("print d");
        }

        public InnerStaticClass() {
            VincentLog.logD("print e");
        }

        public static void print() {
            VincentLog.logD("print f");
        }
    }
}
