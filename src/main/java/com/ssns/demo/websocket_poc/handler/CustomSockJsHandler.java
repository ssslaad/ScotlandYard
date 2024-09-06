package com.ssns.demo.websocket_poc.handler;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.sockjs.transport.SockJsServiceConfig;
import org.springframework.web.socket.sockjs.transport.handler.SockJsWebSocketHandler;
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession;

public class CustomSockJsHandler extends SockJsWebSocketHandler {
    public CustomSockJsHandler(SockJsServiceConfig serviceConfig, WebSocketHandler webSocketHandler, WebSocketServerSockJsSession sockJsSession) {
        super(serviceConfig, webSocketHandler, sockJsSession);
    }
}
