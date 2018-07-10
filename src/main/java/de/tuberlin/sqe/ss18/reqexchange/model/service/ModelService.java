package de.tuberlin.sqe.ss18.reqexchange.model.service;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.sysml.SysMLModel;
import org.eclipse.rmf.reqif10.ReqIF;

import java.io.File;
import java.nio.file.Path;

public interface ModelService {

    ReqIF getReqIFModel(Path filePath);
    boolean saveReqIFModel(ReqIF reqIFModel, Path filePath);

    SysMLModel getSysMLModel(Path filePath);
    boolean saveSysMLModel(SysMLModel sysMLModel, Path filePath);

}
