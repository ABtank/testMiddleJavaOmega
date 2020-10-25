package ru.abramov.tests_middle;

import ru.abramov.tests_middle.models.DElement;
import ru.abramov.tests_middle.models.Entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainParserXmlWithSax {

    public static void main(String[] args) {

        Path xmlPath = Paths.get("files/for/parsing/xml");

        //собираем все файлы из папки для парсинга
        List<Path> collect = null;
        try {
            collect = Files.list(xmlPath).filter(path -> !Files.isDirectory(path)).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("bad path");
            e.printStackTrace();
        }
        //получаем коллекцию расспарсенных файлов
        List<SaxParser> saxParserList = new ArrayList<>();
        for (Path path : collect) {
            SaxParser saxParser = getSaxParser(path.normalize().toAbsolutePath().toString());
            saxParserList.add(saxParser);
        }
        // забираем готовую коллекцию на разбор в бд

    }

    private static SaxParser getSaxParser(String xmlPath) {
        SaxParser saxParser = new SaxParser();
        saxParser.parse(xmlPath);
        return saxParser;
    }
}
