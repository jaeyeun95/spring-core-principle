package com.example.advanced.trace.threadlocal;

import com.example.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");

        // 람다식을 사용하지 않았을 때
//        Runnable userA = new Runnable() {
//            @Override
//            public void run() {
//                fieldService.logic("userA");
//            }
//        };

        // 람다 사용
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000);    // 동시성 문제 발생 x
        sleep(1000);    // 동시성 문제 발생 o
        threadB.start();

        sleep(2000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
