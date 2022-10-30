package ru.yandex.incoming34.NestedObjects.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class Attr implements HavingAttrs{

    private final List<Attr> nestedAttrs;
    private final int deviceId;

    @Override
    public List<Attr> getAttrs() {
        return nestedAttrs;
    }

    @Override
    public int getValue() {
        return deviceId;
    }

}
