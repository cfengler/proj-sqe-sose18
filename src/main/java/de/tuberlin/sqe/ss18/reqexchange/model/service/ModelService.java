package de.tuberlin.sqe.ss18.reqexchange.model.service;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.uml2.uml.Package;

import java.nio.file.Path;

public interface ModelService {

    ReqIF loadReqIFModel(Path filePath);
    boolean saveReqIFModel(ReqIF reqIFModel, Path filePath);

    EList<EObject> loadSysMLModel(Path filePath);
    boolean saveSysMLModel(EList<EObject> umlModel, Path filePath);

//    Workbook loadXlsxModel(Path filePath);
//    boolean saveXlsxModel(Workbook xlsxModel, Path filePath);

}
