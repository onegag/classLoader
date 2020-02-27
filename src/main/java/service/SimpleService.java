package service;

import annotation.Init;
import annotation.Service;

@Service(name = "Super simple service")
public class SimpleService {
    @Init
    public void initService(){
        System.out.println("Simple Service init has been started");
    }

}
