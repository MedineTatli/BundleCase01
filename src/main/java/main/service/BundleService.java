package main.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class BundleService {

    public List<Integer> convertToDatas(ArrayList<ArrayList<String>> request) {
        List<Integer> result = new ArrayList<>();
        request.stream().filter(Objects::nonNull).forEach(topList -> {

            ArrayList<Integer> cleanList = new ArrayList<>();
            topList.stream().forEach(childList -> {
                try {
                    cleanList.add(Integer.parseInt(childList));
                } catch (NumberFormatException e) {
                    log.error("An error occurred while converting to int : {}", childList);
                }
            });
            int groupSize = cleanList.size() / 3;
            int count = 0;
            for (int i = 0; i < groupSize; i++) {
                List<Integer> group = cleanList.subList(count, 3 + count);
                count += 3;
                if (group.stream().mapToInt(Integer::intValue).sum() > 90) {
                    result.add(group.stream().mapToInt(Integer::intValue).sum());
                }
            }
        });
        return result;

    }
}
