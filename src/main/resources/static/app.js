const protocol = location.protocol === 'https:' ? 'wss' : 'ws';

const stompClient = new StompJs.Client({
    brokerURL: `${protocol}://vigilant-umbrella-97pvr56x45fp9gp-8080.app.github.dev/websocketpoc`
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/movements', (greeting) => {
        showGreeting(greeting.body);
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.publish({
        destination: "/app/move",
        body: JSON.stringify({
            'source': 'Station 69',
            'target': 'Station 70',
            'modeOfTransport': 'auto',
            'playerName': 'chicha',
            'playerRole': 'detective',
            'stepNumber': 2
        })
    });
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $( "#connect" ).click(() => connect());
    $( "#disconnect" ).click(() => disconnect());
    $( "#send" ).click(() => sendName());
});