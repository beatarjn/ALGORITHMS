package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateBinStrings {

    public List<String> generateBinStrings(String temp) {
        List<String> result = new ArrayList<>();
        List<Integer> list = IntStream.range(0, temp.length()).filter(i -> temp.charAt(i) == '?')
                .boxed().collect(Collectors.toList());

        generateBin(temp, 0, result, list);
        return result;
    }

    private List<String> generateBin(String temp, int index, List<String> result, List<Integer> indexes) {
        if (index >= indexes.size() || index >= temp.length()) {
            result.add(temp);
            return result;
        }

        StringBuilder new0 = new StringBuilder(temp);
        new0.setCharAt(indexes.get(index), '0');
        StringBuilder new1 = new StringBuilder(temp);
        new1.setCharAt(indexes.get(index), '1');

        generateBin(new0.toString(), index + 1, result, indexes);
        generateBin(new1.toString(), index + 1, result, indexes);

        return result;
    }
}