package com.educational.platform.courses.course.numberofsudents.update;

import com.educational.platform.course.enrollments.integration.event.StudentEnrolledToCourseIntegrationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Event listener for {@link StudentEnrolledToCourseIntegrationEvent}.
 */
@Component
@RequiredArgsConstructor
public class StudentEnrolledToCourseIntegrationEventListener {

    private final IncreaseNumberOfStudentsCommandHandler handler;

    @Async
    @EventListener
    public void handleStudentEnrolledToCourseEvent(StudentEnrolledToCourseIntegrationEvent event) {
        handler.handle(new IncreaseNumberOfStudentsCommand(event.getCourseId()));
    }

}
