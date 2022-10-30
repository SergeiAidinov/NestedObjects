package ru.yandex.incoming34.NestedObjects.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class Mdata implements HavingAttrs{

    private final List<Attr> attrs;
    private final int src;

    @Override
    public List<Attr> getAttrs() {
        return attrs;
    }

    @Override
    public int getValue() {
        return src;
    }

}
