package strangecalculator.reader;

import strangecalculator.Formula;

public interface ReaderInterface {
    Boolean hasNext();
    Formula readNext();
}
