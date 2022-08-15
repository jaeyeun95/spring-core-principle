package com.example.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRepositoryVO orderRepositoryVO;

    public void orderItem(String itemId){
        orderRepositoryVO.save(itemId);
    }
}
