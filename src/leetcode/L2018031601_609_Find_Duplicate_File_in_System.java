package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class L2018031601_609_Find_Duplicate_File_in_System {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            goThrough(path, map);
        }

        return map.values().stream().filter(l -> l.size() > 1).collect(Collectors.toList());
    }

    private void goThrough(String path, HashMap<String, List<String>> map) {

        String[] split = path.split(" ");
        String directory = split[0];
        for (int i = 1; i < split.length; i++) {
            String filePart = split[i];
            String leftBracket = "\\(";
            String[] fileSplit = filePart.split(leftBracket);
            String fileName = fileSplit[0];
            String content = fileSplit[1].substring(0, fileSplit[1].length() - 1);
            String fileFullPath = directory + "/" + fileName;
            List<String> pathsWithTheContent = map.getOrDefault(content, new ArrayList<>());
            pathsWithTheContent.add(fileFullPath);
            map.put(content, pathsWithTheContent);
        }
    }
}
