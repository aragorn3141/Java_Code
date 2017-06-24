package ict4315.finalproject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContactListUnitTests.class, ContactUnitTests.class,
		PhoneTypeUnitTests.class, PhoneUnitTests.class,
		USStatesUnitTests.class, ValidateInputUnitTests.class })
public class AllUnitTests {

}
