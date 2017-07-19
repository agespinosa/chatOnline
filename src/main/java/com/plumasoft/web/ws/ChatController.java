package com.plumasoft.web.ws;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


import com.plumasoft.dto.ChatDto;
import com.plumasoft.entity.Mensaje;


@Controller
@MessageMapping("chat")
public final class ChatController {

	/** A logger reference */
	private static Logger logger = Logger.getLogger(ChatController.class);


	/*@Autowired
	private ChatDto wData;*/

	/** Web socket message template */
	@Autowired
	private SimpMessagingTemplate template;

	/**
	 * Get weather info for a given place.
	 *
	 * @param place
	 *            - The place
	 * @return The weather info
	 */
	//@MessageMapping("sendmsj/{my}") //"/app/chat.sendmsj.{my}".
	@MessageMapping("sendmsj")
	@SendTo("/topic/chatmsj")
	public void getchat(Mensaje chatRequest
			//,@DestinationVariable String my
			//, Principal principal
			) {
		
		 //this.template.convertAndSend("/topic/pedidoinfo-" +chatRequest.getCodigoLocal(),pedidosByLocal);
		this.template.convertAndSend("/topic/chatmsj",chatRequest);
	}

	/**
	 * Run weather info periodically.
	 */
	//@Scheduled(fixedRate = 10000)
	/*public void runWInfo() {
		Integer[] locales={494,534};
		for(Integer locale:locales){
		this.template.convertAndSend("/topic/pedidoinfo-"+locale,
				wData.getPedidosByLocal(locale));
		}
	}*/

	/**
	 * @return the wData
	 */
	/*public PedidoDto getwData() {
		return wData;
	}*/

	/**
	 * @param wDataArg
	 *            the wData to set
	 */
	/*public void setwData(PedidoDto wDataArg) {
		wData = wDataArg;
	}*/
}
