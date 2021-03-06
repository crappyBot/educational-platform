package com.educational.platform.administration.course.create;

import com.educational.platform.courses.integration.event.SendCourseToApproveIntegrationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Event listener for {@link SendCourseToApproveIntegrationEvent}, executes the logic for creating course proposal by {@link CreateCourseProposalCommandHandler}.
 */
@Component
@RequiredArgsConstructor
public class SendCourseToApproveIntegrationEventListener {

    private final CreateCourseProposalCommandHandler handler;

    @Async
    @EventListener
    public void handleSendCourseToApproveEvent(SendCourseToApproveIntegrationEvent event) {
        handler.handle(new CreateCourseProposalCommand(event.getCourseId()));
    }

}
