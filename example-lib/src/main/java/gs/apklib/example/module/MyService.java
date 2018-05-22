package gs.apklib.example.module;

import java.util.List;

public interface MyService {

    List<Data> getData();

    class Data {
        public final CharSequence text1;
        public final CharSequence text2;

        public Data(CharSequence text1, CharSequence text2) {
            this.text1 = text1;
            this.text2 = text2;
        }
    }

}
