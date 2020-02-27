package service;

import annotation.Init;
import annotation.Service;

@Service(name = "Very lazy servise")
public class LazyService {
    @Init
    public void lazyInit() throws Exception {
        if (Math.random()>0.5) {
            System.out.println("Lazy service init has been started");
        } else throw new Exception();
    }
}
