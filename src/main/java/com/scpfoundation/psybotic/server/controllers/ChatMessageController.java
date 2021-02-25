package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.IChatMessageService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatMessages")
public class ChatMessageController {

    private final IChatMessageService chatMessageService;

    public ChatMessageController(IChatMessageService chatMessageService){
        this.chatMessageService=chatMessageService;
    }

    @PostMapping("/insert")
    public GeneralResponse insert(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.insert(chatMessage);
    }

    @GetMapping("/findById")
    public ChatMessage findById(@RequestParam("id") String id) {
        return chatMessageService.findById(id);
    }

}
