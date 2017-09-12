package nonLeetcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CleanInventroy {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/zrruimin/workspace/redshift", "Inventory.txt");
        try (Stream<String> lines = Files.lines(path)) {
            List<String> all = lines.filter(s -> s.contains("_1")||s.contains("_2")||s.contains("_30")||s.contains("_31")||s.contains("_32")||s.contains("_33")||s.contains("_34")||s.contains("_35")||s.contains("_36")).collect(Collectors.toList());
            all.forEach(id -> System.out.println("delete from lws_inventory where instance_id = '" + id + "';")
            );
        }
    }
}
