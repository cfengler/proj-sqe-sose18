package de.tuberlin.sqe.ss18.reqexchange.model;

import de.tuberlin.sqe.ss18.reqexchange.UnitTestHelper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultModelValidationServiceTest {

    ModelValidationService mvs = new DefaultModelValidationService();

    @Test
    public void test_01_ValidateExistingPath() {
        Assert.assertTrue(mvs.validate(UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("04_Papyrus_ReqExchange.uml")));
    }

    @Test
    public void test_02_ValidateNotExistingPath() {
        Assert.assertFalse(mvs.validate(null));
        Assert.assertFalse(mvs.validate(UnitTestHelper.getTestPath().resolve("ichexistierenicht.exe")));
    }
}
