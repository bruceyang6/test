package com.example.demo.sortprint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestSortPrint {

    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new Runnable() {
                        @Override
                        public void run() {
                            foo.one();
                        }
                    });
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(new Runnable() {
                        @Override
                        public void run() {
                            foo.two();
                        }
                    });
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new Runnable() {
                        @Override
                        public void run() {
                            foo.three();
                        }
                    });
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
