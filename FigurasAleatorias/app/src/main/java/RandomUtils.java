import java.util.Objects;
import java.util.Random;

/**
 * Created by mati on 9/11/16.
 */

public class RandomUtils {

    private static Random r =  new Random();

    public static int RandomInt(int range) {

        return r.nextInt(range);

    }

    public static int RandomIndex(Object [] array) {

        return RandomInt(array.length);
    }

    public static <T> T RandomElement (T [] array) {

        return array[RandomIndex(array)];

    }

    public static float RandomFloat (int n) {

        return (float)Math.random()*n;
    }
}
