package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.models.Notification;
import com.scpfoundation.psybotic.server.services.NotificationService;

import java.util.List;

public interface INotificationService extends ICRUDService<Notification, String>{

    List<Notification> findByNotificationNoReply(boolean reply, boolean bildiri);
}
