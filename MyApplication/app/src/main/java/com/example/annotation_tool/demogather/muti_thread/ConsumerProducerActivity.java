package com.example.annotation_tool.demogather.muti_thread;

import android.app.Activity;
import android.os.Bundle;

import com.example.annotation_tool.demogather.R;
import com.example.annotation_tool.demogather.common.VincentLog;

/**
 * Created by VincentChen on 2017/4/27.
 */
public class ConsumerProducerActivity extends Activity {

    private ProductContainer container = new ProductContainer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_producer_layout);
        test();
    }

    private void test() {
        Thread consumerThread = new ConsumerThread();
        Thread producerThread = new ProducerThread();
        consumerThread.start();
        producerThread.start();
    }


    private class ProductContainer {

        private Product[] container = new Product[5];
        private int index = 0;

        public synchronized void put(Product product) {
            while (index == container.length) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            container[index++] = product;
            notify();
        }

        public synchronized Product get() {
            while (index == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Product product = container[--index];
            notify();
            return product;
        }
    }

    /**
     * 生产/消费 的产品
     */
    private class Product {
        public int id;
    }

    /**
     * 消费者
     */
    private class ConsumerThread extends Thread {

        @Override
        public void run() {
            while (true){
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Product product = container.get();
                VincentLog.logE("获取 product");
            }
        }
    }

    /**
     * 生产者
     */
    private class ProducerThread  extends  Thread {

        @Override
        public void run() {
            while (true){
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Product product = new Product();
                VincentLog.logE("创建 product");
                container.put(product);
            }
        }
    }
}
