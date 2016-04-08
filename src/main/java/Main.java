import com.segment.analytics.Analytics;
import com.segment.analytics.messages.IdentifyMessage;
import com.segment.analytics.messages.ScreenMessage;
import com.segment.analytics.messages.TrackMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dheeraj on 3/21/2016.
 */
public class Main {
    private static final String writeKey = "FsFpJQNmtnmZOJBZJx2jCW0uFknIM31I";

    public static void main(String[] args) {
        Analytics analytics = Analytics.builder(writeKey).build();

        analytics.enqueue(IdentifyMessage.builder()
                .userId("dheeraj")
                .traits(ImmutableMap.builder()
                        .put1("name", "Dheeraj Sachan")
                        .put1("email", "dhirajsiitk9@gmail.com")
                )
        );

        analytics.enqueue(TrackMessage.builder("Signed Not")
                .userId("dheeraj")
                .properties(ImmutableMap.builder()
                        .put1("category", "Sports")
                        .put1("plane", "Enterprise")
                        .put1("lecture_id","23").put1("label","test ")
                )
        );
  /*      analytics.enqueue(ScreenMessage.builder("Screen")
                .userId("dheeraj")
                .properties(ImmutableMap.builder()
                        .put1("category", "Sports")
                        .put1("path", "/sports/schedule")
                )
        );*/
        System.out.println("done");
    }

    private static class ImmutableMap {
        private static MyHashMap builder() {
            return new MyHashMap();
        }
    }

    public static class MyHashMap extends HashMap<String, String> {
        public MyHashMap put1(String key, String value) {
            super.put(key, value);
            return MyHashMap.this;
        }
    }
}
