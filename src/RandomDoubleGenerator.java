import java.util.ArrayList;
import java.util.Collections;

class RandomDoubleGenerator
{
    final static int kDOUBLES_TO_GENERATE = 100; //total number of doubles to generate
    static ArrayList<Double> randomDoubleList = new ArrayList<>();

    static void getRandomDoubles()
    {
        final int kINT_GEN = 999999;
        ArrayList<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < kINT_GEN; i++)
        {
            integerList.add(i);
        }

        Collections.shuffle(integerList);

        for (int i = 0; i < kDOUBLES_TO_GENERATE; i++)
        {
            double randomDouble = Math.random() + integerList.get(i);
            randomDoubleList.add(randomDouble);
        }
    }
}