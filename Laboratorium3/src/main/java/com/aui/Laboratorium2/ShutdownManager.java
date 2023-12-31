package com.aui.Laboratorium2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

@Component
public class ShutdownManager {

    @Autowired
    private ApplicationContext appContext;

    /*
     * Invoke with `0` to indicate no error or different code to indicate
     * abnormal exit. es: shutdownManager.initiateShutdown(0);
     **/
    public void initiateShutdown(int returnCode){
        SpringApplication.exit(appContext, () -> returnCode);
    }
}
