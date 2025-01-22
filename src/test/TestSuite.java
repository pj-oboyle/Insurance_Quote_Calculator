package ie.gmit.dip;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
@SelectClasses({
	AccidentClassTests.class,
	AgeClassTests.class,
	InsuranceClassTest.class
})

class TestSuite {
	
}
