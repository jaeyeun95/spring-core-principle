package com.example.advanced.trace.logtrace;

import com.example.advanced.trace.TraceStatus;

// 로그 추적기를 위한 최소한의 기능만 선언
public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
