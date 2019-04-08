package demoJsp;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SimpleBean implements Serializable {

    private String name;
    private List<String> words;

    public SimpleBean() {
        this.words = Stream.of("Ala", "ma", "kota").collect(toList());
    }

    public List<String> getWords() {
        return words;
    }
    public void setWords(List<String> words) {
        this.words = words;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
