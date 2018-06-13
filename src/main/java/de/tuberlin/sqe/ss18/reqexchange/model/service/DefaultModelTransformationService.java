package de.tuberlin.sqe.ss18.reqexchange.model.service;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.common.CommonModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif.ReqIFModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.sysml.SysMLModel;

public class DefaultModelTransformationService implements ModelTransformationService {

    public ReqIFModel transformCommonModelToReqIF(CommonModel commonModel) {
        //TODO: implement
        return new ReqIFModel();
    }

    public CommonModel transformReqIFToCommonModel(ReqIFModel reqIFModel) {
        //TODO: implement
        return new CommonModel();
    }

    public SysMLModel transformCommonModelToSysMLModel(CommonModel commonModel) {
        //TODO: implement
        return new SysMLModel();
    }

    public CommonModel transformSysMLModelToCommonModel(SysMLModel sysMLModel) {
        //TODO: implement
        return new CommonModel();
    }

}
