package br.com.mystatement.service;

import br.com.mystatement.domain.enums.ConstCredentialsEnum;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.mystatement.utils.FormatUtils.formatCredentials;

@Service
public class ReadTxtService {

    public Map<ConstCredentialsEnum, String> getArch(String path, ConstCredentialsEnum... constCredentialsEnums) {
        Resource resource = new FileSystemResource(path);
        List<String> lines = new ArrayList<>();
        Map<ConstCredentialsEnum, String> map = new HashMap<>();

        try {
            InputStream stream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            Arrays.stream(constCredentialsEnums).toList().forEach(c -> {
                String stringStream = lines.stream().filter(l -> l.contains(c.getName())).findFirst().get();

                if (!map.containsKey(c))
                    map.put(c, formatCredentials(stringStream));
            });

            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }
}
