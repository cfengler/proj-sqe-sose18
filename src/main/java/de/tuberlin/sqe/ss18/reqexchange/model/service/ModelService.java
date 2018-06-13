package de.tuberlin.sqe.ss18.reqexchange.model.service;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.common.CommonModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif.ReqIFModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.sysml.SysMLModel;

import java.io.File;

public interface ModelService {

    ReqIFModel getReqIFModel(File file);

    SysMLModel getSysMLModel(File file);

    CommonModel getCommonModel(File file);

}
