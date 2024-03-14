package m4.e2_library.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookLogger {
    @AfterReturning(pointcut="execution(* m4.e2_library.service.BorrowService.borrow(..))", returning = "retVal")
    public void logAfterAllMethods(JoinPoint joinPoint, Object retVal)
    {
        System.out.printf("action %s success, book quantity decrease %s%n", joinPoint.getSignature().getName(), retVal);
    }
}
