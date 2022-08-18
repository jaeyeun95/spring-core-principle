package com.example.advanced.trace;

public class TraceStatus {

    private TraceId traceId;
    private Long startTiemMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTieMs, String message) {
        this.traceId = traceId;
        this.startTiemMs = startTieMs;
        this.message = message;
    }

    public Long getStartTimeMs() {
        return startTiemMs;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimdMs() {
        return startTiemMs;
    }

    public String getMessage() {
        return message;
    }
}
