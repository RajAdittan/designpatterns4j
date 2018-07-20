package io.codej.designpatterns.structural.proxy;

import java.time.LocalDateTime;

public class SecuredExecutionHandler implements ExecutionHandler {

    private final int timeout = 5;

    private final String user;
    private final String passwd;
    private ExecutionHandler executionHandler;
    private LocalDateTime futureTime;

    public SecuredExecutionHandler(String user, String passwd) {

        this.user = user;
        this.passwd = passwd;

        executionHandler = () -> {
            System.out.println("execution:");
            System.out.println("- ");
        };

        futureTime = LocalDateTime.now().plusSeconds(timeout);
    }

    @Override
    public void execute() {
        if(secure()) {
            System.out.println("security check done");
        } else {
            System.out.println("security check is not done");
        }
        executionHandler.execute();
    }

    private boolean secure() {
        if(futureTime.getNano() < LocalDateTime.now().getNano()) {
            System.out.println("verify user credentials ...");
            if(passwd.hashCode() == "s3cr3tNoIs42".hashCode()) {
                System.out.println("secure { user:" + user + ", time:" + LocalDateTime.now() + "}, secured");
                futureTime = LocalDateTime.now().plusSeconds(timeout);
                return true;
            } else {
                System.out.println("secure { user:" + user + ", time:" + LocalDateTime.now() + "}, failed to secure, specified passwd hash:" + passwd.hashCode() + " is wrong");
                futureTime = LocalDateTime.now().plusSeconds(timeout);
                return false;
            }
        }
        System.out.println("secure: security check is ignored, the call is well with in the guarded timeout period");
        System.out.println("secure { user:" + user + ", time:" + LocalDateTime.now() + "}, secured");
        return true;
    }
}
