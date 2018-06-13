package de.tuberlin.sqe.ss18.reqexchange.model.service;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.common.CommonModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif.ReqIFModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.sysml.SysMLModel;

import java.io.File;

public class DefaultModelService implements ModelService{
    //vielleicht stellt File auch ein Directory dar, falls mehrere Dateien ein Modell darstellen oder File zeigt auf die Hauptdatei zu der relativ dann die weiteren Dateie liegen
    public ReqIFModel getReqIFModel(File file) {
        //TODO: implement
        return new ReqIFModel();
    }

    public SysMLModel getSysMLModel(File file) {
        //TODO: implement
        return new SysMLModel();
    }

    public CommonModel getCommonModel(File file) {
        //TODO: implement
        return new CommonModel();
    }

}
