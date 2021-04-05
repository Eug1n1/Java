package com.company.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value={DBClassTests.class, DBConnectionTest.class})
public class TestPack {
}
