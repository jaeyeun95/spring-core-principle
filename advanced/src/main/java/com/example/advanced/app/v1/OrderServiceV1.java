package com.example.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryVO;

    public void orderItem(String itemId){
        orderRepositoryVO.save(itemId);
    }
}
