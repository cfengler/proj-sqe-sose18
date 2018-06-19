package de.tuberlin.sqe.ss18.reqexchange.project.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ReqExchangeFileType {
    ReqIF("ReqIF", "reqif", "reqifz"),
    SysML("SysML"), //TODO was sind die Datentypen fuer SysML Dateien?
    Docx("Word", "doc", "docx"),
    Xslx("Excel", "xls", "xlsx");

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

    /**
     * reads file ending and determines what ReqExchangeFileType it is
     * @param filename filename to be examined
     * @return determined ReqExchangeFileType, if none was found it returns null
     */
    public static ReqExchangeFileType getFileTypeFromFileName(String filename) {
        ReqExchangeFileType determinedFileType  = null;
        if(filename != null) {
            String[] segments = filename.split("\\.");
            String ending = "";
            if(segments.length > 0) {
                ending = segments[segments.length - 1];
            } else {
                return null;
            }
            for(ReqExchangeFileType type: ReqExchangeFileType.values()) {
                if(type.getFiletypes().contains(ending)) {
                    determinedFileType = type;
                }
            }
        }
        return determinedFileType;
    }

    @Override
    public String toString() {
        return name;
    }
}
