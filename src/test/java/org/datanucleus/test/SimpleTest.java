package org.datanucleus.test;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import mydomain.model.DummyWithOneIndex;
import mydomain.model.DummyWithTwoIndices;
import org.datanucleus.api.jdo.DataNucleusHelperJDO;
import org.datanucleus.metadata.ClassMetaData;
import org.datanucleus.util.NucleusLogger;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SimpleTest
{
    @Test
    public void testSingleIndexWithExtensions() {
        NucleusLogger.GENERAL.info(">> test single index with extensions START");
        PersistenceManagerFactory pmf = null;
        try {
            pmf = JDOHelper.getPersistenceManagerFactory("MyTest");
            ClassMetaData cmd = DataNucleusHelperJDO.getMetaDataForClass(pmf, DummyWithOneIndex.class);
            cmd.getIndexMetaData().forEach((imd) -> {
                assertNotNull(String.format("extensions of index %s should not be null", imd.getName()), imd.getExtensions());
            });
        } finally {
            if (pmf != null) {
                pmf.close();
            }
        }
        NucleusLogger.GENERAL.info(">> test single index with extensions END");
    }

    @Test
    public void testMultipleIndicesWithExtensions() {
        NucleusLogger.GENERAL.info(">> test multiple indices with extensions START");
        PersistenceManagerFactory pmf = null;
        try {
            pmf = JDOHelper.getPersistenceManagerFactory("MyTest");
            ClassMetaData cmd = DataNucleusHelperJDO.getMetaDataForClass(pmf, DummyWithTwoIndices.class);
            cmd.getIndexMetaData().forEach((imd) -> {
                // fails for datanucleus-api-jdo up to commit c8250f17319fe419f8fe3e6e8f431e8cf58f8af6 (currently latest master)
                assertNotNull(String.format("extensions of index %s should not be null", imd.getName()), imd.getExtensions());
            });
        } finally {
            if (pmf != null) {
                pmf.close();
            }
        }
        NucleusLogger.GENERAL.info(">> test multiple indices with extensions END");
    }
}
