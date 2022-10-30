package ru.yandex.incoming34.NestedObjects.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.incoming34.NestedObjects.components.Attr;
import ru.yandex.incoming34.NestedObjects.components.Mdata;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class ParserMdataTest {

    @Autowired
    ParserMdata parserMdata;

    @Test
    public void parseMdataTest(){

        Mdata mdata = createTestMdata();

        parserMdata.parseMdata(mdata);

    }

    private Mdata createTestMdata() {

        Attr deepestAttr = new Attr(Collections.emptyList(), 41);
        Attr deepAttr = new Attr(List.of(deepestAttr), 31);

        Attr nestedAttr11 = new Attr(Collections.emptyList(), 11);
        Attr nestedAttr12 = new Attr(List.of(deepAttr), 12);
        Attr nestedAttr21 = new Attr(Collections.emptyList(), 21);
        Attr nestedAttr22= new Attr(Collections.emptyList(), 22);

        Attr attr1 = new Attr(List.of(nestedAttr11, nestedAttr12), 1);
        Attr attr2 = new Attr(List.of(nestedAttr21, nestedAttr22), 2);

        return new Mdata(List.of(attr1, attr2),12345 );
    }

}