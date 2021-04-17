package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Notification;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.INotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@CrossOrigin("*")
public class NotificationController {
    private final INotificationService notificationService;

    public NotificationController(INotificationService notificationService)
    {
        this.notificationService=notificationService;
    }
    @PostMapping("/insert")
    public ResponseEntity<GeneralResponse> insert(@RequestBody Notification notification) {
        return notificationService.insert(notification);
    }

    @GetMapping("/findById")
    public Notification findById(@RequestParam("id") String id) {
        return notificationService.findById(id);
    }

    @GetMapping("/findByNotificationNoReply")
    public List<Notification> notificationNoAnswered(@RequestParam("reply") boolean reply, @RequestParam("bildiri") boolean bildiri ) {
        return notificationService.findByNotificationNoReply(reply,bildiri);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@RequestBody Notification notification) {
        return notificationService.update(notification);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return notificationService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> delete(@RequestBody Notification notification) {
        return notificationService.delete(notification);
    }
}
