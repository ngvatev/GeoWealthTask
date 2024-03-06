package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Set;
import java.util.stream.Collectors;

public class DictionaryProvider {
    private static final String DICTIONARY_URL_STRING =
        "https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt";

    public Set<String> downloadDictionary() {
        URL dictionaryUrl = tryConstructingUrl(DICTIONARY_URL_STRING);

        try (InputStream inputStream = dictionaryUrl.openConnection().getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            return bufferedReader.lines()
                .skip(2)
                .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException("Could not read dictionary", e);
        }
    }

    private URL tryConstructingUrl(String url) {
        try {
            return new URI(url).toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException("MalformedURL URL", e);
        }
    }
}
