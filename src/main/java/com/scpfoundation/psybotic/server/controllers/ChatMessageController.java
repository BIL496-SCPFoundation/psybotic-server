package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.ICRUDService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IChatMessageService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatMessages")
@CrossOrigin("*")
public class ChatMessageController {

    private final IChatMessageService chatMessageService;

    public ChatMessageController(IChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @PostMapping("/insert")
    public ResponseEntity<GeneralResponse> insert(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.insert(chatMessage);
    }

    @GetMapping("/findById")
    public ChatMessage findById(@RequestParam("id") String id) {
        return chatMessageService.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.update(chatMessage);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return chatMessageService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> delete(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.delete(chatMessage);
    }
}
