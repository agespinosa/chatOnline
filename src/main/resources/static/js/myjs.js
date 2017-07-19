/* JavaScript for websocket client */
var stompClient = null;
var msj='un msj';

/* Show connection status */
function setConnected(connected) {
	msj = document.getElementById('msj').value;
	var status = "disconnected";
	if(connected){
		status = "connected";
	}
    document.getElementById('status').innerHTML = status;
}

/* Connect to topic using web sockets */
function connect() {	
    var socket = new SockJS('/chatonli');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/chatmsj', function(msj){
            showChatMsj(msj);
        });
    });
}

/* Disconnect */
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

/* Send local */
function sendMsj() {
	msj = document.getElementById('msj').value;
    stompClient.send("/app/chat/sendmsj/yo", {}, JSON.stringify({ 'msj': msj,'origin':'oscarO','destination':'oscarD' }));
}

/* Show chat info */
function showChatMsj(chatMsj) {
    var response = document.getElementById('chatInfo');
    var newInfo ='';
    /*for(var i=0;i<pInfo.length;i++){
    	newInfo+= "<p>[" + pInfo[i].id + "](" + pInfo[i].descripcion + "): " + pInfo[i].provincia + "</p><b/>"
    }*/
    newInfo+= "<p>actualizado: "+chatMsj.body+"-----"+new Date()+"<b/>"
    //var content = response.innerHTML;
    response.innerHTML =  newInfo;
}