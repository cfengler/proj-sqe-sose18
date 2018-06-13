package de.tuberlin.sqe.ss18.reqexchange.model.service;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.common.CommonModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif.ReqIFModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.sysml.SysMLModel;

public interface ModelTransformationService {

    ReqIFModel transformCommonModelToReqIF(CommonModel commonModel);
    CommonModel transformReqIFToCommonModel(ReqIFModel reqIFModel);

    SysMLModel transformCommonModelToSysMLModel(CommonModel commonModel);
    CommonModel transformSysMLModelToCommonModel(SysMLModel sysMLModel);

}
