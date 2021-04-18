package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.ChatRoomResponse;
import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.serviceInterfaces.IChatMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findByReceiverId")
    public List<ChatMessage> findByReceiverId(@RequestParam("receiverId") String receiverId) {
        return chatMessageService.findByReceiverId(receiverId);
    }

    @GetMapping("/chatRooms")
    public List<ChatRoomResponse> findChatRooms(@RequestParam("userId") String userId) {
        return chatMessageService.getChatRooms(userId);
    }

    @GetMapping("/history")
    public List<ChatMessage> history(@RequestParam("chatRoomId") String chatRoomId) {
        return chatMessageService.getChatHistory(chatRoomId);
    }
}
