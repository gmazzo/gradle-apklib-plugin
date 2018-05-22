package gs.apklib.example.module;

import com.google.auto.service.AutoService;

@AutoService(EntryPoint.class)
public class EntryPointImpl implements EntryPoint {

    @Override
    public MyService provideMyService() {
        return new MyServiceImpl();
    }

}
