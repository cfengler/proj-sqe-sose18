package de.tuberlin.sqe.ss18.reqexchange.model;

import java.nio.file.Path;

public interface ModelTransformationService {

    boolean transform(Path source, Path destination);
}
