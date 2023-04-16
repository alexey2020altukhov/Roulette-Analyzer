package com.ra.model;

import com.ra.enums.TypeSequence;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Accessors(chain = true)
@Data
public class Sequence<T> {

    private int sequenceLength;

    private boolean identicalValues;

    private TypeSequence type;

    private LinkedList<Number> values;

    private List<T> betOn;
}