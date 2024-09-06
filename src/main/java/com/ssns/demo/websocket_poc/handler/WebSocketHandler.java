package com.ssns.demo.websocket_poc.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {

    private CopyOnWriteArrayList<WebSocketSession> webSocketSessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.webSocketSessions.add(session);
        log.info("Connection Created: {}",session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("Session({}),sent({}),({})",session.getId(),message.getPayload(),message);
        webSocketSessions.forEach(socketSession -> {
                    try {
                        socketSession.sendMessage(message);
                    } catch (IOException e) {
                        throw new RuntimeException();
                    }
                }
        );
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.webSocketSessions.remove(session);
        log.info("Connection Closed: {}",session);
    }
}
