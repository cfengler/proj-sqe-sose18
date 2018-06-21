package de.tuberlin.sqe.ss18.reqexchange.model.service;

import java.io.File;

public interface ModelTransformationService {

    boolean transform(File source, File destination);
}
