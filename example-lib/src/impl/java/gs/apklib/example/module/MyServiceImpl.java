package gs.apklib.example.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MyServiceImpl implements MyService {
    private final Random random = new Random();

    @Override
    public List<Data> getData() {
        int count = random.nextInt(8) + 4;
        List<Data> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            String text1 = "text#" + i;
            String text2 = Long.toHexString(random.nextLong());

            data.add(new Data(text1, text2));
        }
        return data;
    }

}
