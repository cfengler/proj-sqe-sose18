package de.tuberlin.sqe.ss18.reqexchange.common.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ReqExchangeFileType {
    ReqIF("ReqIF", "reqif", "reqifz"),
    SysML("SysML"), //TODO was sind die Datentypen fuer SysML Dateien?
    Docx("Word Document", "doc", "docx"),
    Xslx("Excel Sheet", "xls", "xlsx");

    private String name;
    private List<String> filetypes;

    private ReqExchangeFileType(String name, String... filetypes) {
        this.name = name;
        this.filetypes = new ArrayList<>();
        this.filetypes.addAll(Arrays.asList(filetypes));
    }

    public String getName() {
        return name;
    }

    public List<String> getFiletypes() {
        return filetypes;
    }

    @Override
    public String toString() {
        return name;
    }
}
