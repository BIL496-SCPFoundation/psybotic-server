package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.models.Notification;
import com.scpfoundation.psybotic.server.repositories.NotificationRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.INotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationService
        extends CRUDService<NotificationRepository, Notification>
        implements INotificationService {

    private final NotificationRepository notificationRepository;


    public NotificationService(NotificationRepository notificationRepository) {
        super(notificationRepository);
        this.notificationRepository = notificationRepository;
    }

}
